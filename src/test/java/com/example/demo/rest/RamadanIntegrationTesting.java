package com.example.demo.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.entity.Ramadan;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
//@TestMethodOrder(OrderAnnotation.class)
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD,scripts ={"classpath:Ramadan-schema.sql",
 "classpath:Ramadan-data.sql"})
public class RamadanIntegrationTesting {

	@Autowired	
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	
	@Test
//	@Order(1)
	public void testaddDayMethod() throws Exception {
		Ramadan testRamadan = new Ramadan(1,"4: AM","12: PM","3: PM","5. PM","7. PM");
		String testRamadanAsJSON = this.mapper.writeValueAsString(testRamadan);
		RequestBuilder req = post("/ramadan/addDay").content(testRamadanAsJSON).contentType(MediaType.APPLICATION_JSON);
		
		Ramadan testSavedRamadan = new Ramadan(2L,1,"4: AM","12: PM","3: PM","5. PM","7. PM");
		String testSavedRamadanAsJSON = this.mapper.writeValueAsString(testSavedRamadan);
		ResultMatcher checkStatus = status().isCreated();
		
		ResultMatcher checkBody = content().json(testSavedRamadanAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
//	@Order(2)
	public void testreadbyId() throws Exception {

		Ramadan entry = new Ramadan(1L,1, "4:19 AM","12:11 PM","3:16 PM","5:16 PM","7:20 PM");
		
		String ramadanOutputAsJson = this.mapper.writeValueAsString(entry);
	
		this.mvc.perform(get("/ramadan/readById/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(content().json(ramadanOutputAsJson));
		
		
	}
	
	
	@Test
//	@Order(3)
	public void testReadAll() throws Exception{
		Ramadan entry = new Ramadan(1L,1, "4:19 AM","12:11 PM","3:16 PM","5:16 PM","7:20 PM");
		List<Ramadan> ramadan= new ArrayList<>();
		ramadan.add(entry);
		String ramadanOutputAsJson = this.mapper.writeValueAsString(ramadan);
		
		this.mvc.perform(get("/ramadan/readAll").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
	}
	
	@Test
//	@Order(4)
	public void testdeleteDay() throws Exception{
		
		this.mvc.perform(delete("/ramadan/deleteDay/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNoContent());
		
	}
	
	
	
	
	@Test
	public void testupdateDay() throws Exception {

		Ramadan entry = new Ramadan(1,"4: AM","12: PM","3: PM","5. PM","7. PM");
		
		String ramadanOutputAsJson = this.mapper.writeValueAsString(entry);
		
        Ramadan result = new Ramadan(1L,1,"4: AM","12: PM","3: PM","5. PM","7. PM");
		
		String resultOutputAsJson = this.mapper.writeValueAsString(result);
	
		this.mvc.perform(put("/ramadan/updateDay/1").contentType(MediaType.APPLICATION_JSON).content(ramadanOutputAsJson))
		.andExpect(status().isAccepted()).andExpect(content().json(resultOutputAsJson));
		
		
	}
	
	
	
}



