package com.example.demo.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.Entity.Ramadan;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("service")
public class RamadanUnitTesting {

	@Autowired	
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void testaddDayMethod() throws Exception {
		Ramadan testRamadan = new Ramadan(1,"4: AM","12: PM","3: PM","5. PM","7. PM");
		String testRamadanAsJSON = this.mapper.writeValueAsString(testRamadan);
		RequestBuilder req = post("/ramadan/addDay").content(testRamadanAsJSON).contentType(MediaType.APPLICATION_JSON);
		
		Ramadan testSavedRamadan = new Ramadan(1,1,"4: AM","12: PM","3: PM","5. PM","7. PM");
		String testSavedRamadanAsJSON = this.mapper.writeValueAsString(testSavedRamadan);
		ResultMatcher checkStatus = status().isCreated();
		
		ResultMatcher checkBody = content().json(testSavedRamadanAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void testreadbyId() throws Exception {
//		RequestBuilder req= get("/ramadan/readById/1");
//		
//		ResultMatcher checkStatus = status().isOk();
//		
//		Ramadan testSavedRamadan = new Ramadan(1,1,"4:15 AM","12:10 PM","3:15 PM","5.15 PM","7.15 PM");
//		String testSavedRamadanAsJSON = this.mapper.writeValueAsString(testSavedRamadan);
//		
//		ResultMatcher checkbody = content().json(testSavedRamadanAsJSON);
//		
//		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkbody);
		
//		Ramadan entry = new Ramadan(1L,1,"4: AM","12: PM","3: PM","5. PM","7. PM");
		Ramadan entry = new Ramadan(1L,1, "4:18 AM","12:10 PM","3:15 PM","5:15 PM","7:19 PM");
		List<Ramadan> ramadan= new ArrayList<>();
		ramadan.add(entry);
		
		
		this.mvc.perform(get("/ramadan/readById/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		
		
	}
	
	
	
	@Test
	public void testReadAll() throws Exception{
		Ramadan entry = new Ramadan(1L,1,"4: AM","12: PM","3: PM","5. PM","7. PM");
		List<Ramadan> ramadan= new ArrayList<>();
		ramadan.add(entry);
		String ramadanOutputAsJson = this.mapper.writeValueAsString(ramadan);
		
		this.mvc.perform(get("/ramadan/readAll").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json(ramadanOutputAsJson));
		
	}
	
	
	
}



