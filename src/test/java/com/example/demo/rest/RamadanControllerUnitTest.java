package com.example.demo.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Ramadan;
import com.example.demo.service.RamadanService;
@SpringBootTest
public class RamadanControllerUnitTest {

	@Autowired
	private RamadanController controller;
	
	@MockBean
	private RamadanService service;
	
	@Test
	public void createRamadanTest() {
		Ramadan ramadan = new Ramadan(1, "4: AM","12: PM","3: PM","5. PM","7. PM");
		
		Mockito.when(this.service.addDay(ramadan)).thenReturn(ramadan);
		
		ResponseEntity<Ramadan> response = new ResponseEntity<Ramadan>(ramadan, HttpStatus.CREATED);
		
		assertThat(response).isEqualTo(this.controller.createRamadan(ramadan));
		
		Mockito.verify(this.service, times(1)).addDay(ramadan);
	}
	
	@Test
	public void UpdateRamadanTest() {
		Ramadan ramadan = new Ramadan(1, "4:19 AM","12:11 PM","3:16 PM","5:16 PM","7:20 PM");
		
		Mockito.when(this.service.addDay(ramadan)).thenReturn(ramadan);
		
		ResponseEntity<Ramadan> response = new ResponseEntity<Ramadan>(ramadan, HttpStatus.ACCEPTED);
		
		assertThat(response).isEqualTo(this.controller.updateRamadan(1, ramadan));
		
		Mockito.verify(this.service, times(1)).updateDay(1, ramadan);
	}
	
	@Test
	public void ReadByIdTest() {
		Ramadan ramadan = new Ramadan(1, "4:19 AM","12:11 PM","3:16 PM","5:16 PM","7:20 PM");
		
		Mockito.when(this.service.addDay(ramadan)).thenReturn(ramadan);
		
		ResponseEntity<Ramadan> response = new ResponseEntity<Ramadan>(ramadan, HttpStatus.OK);
		
		assertThat(response).isEqualTo(this.controller.readById(1));
		
		Mockito.verify(this.service, times(1)).readById(1);
	}
	
	@Test
	public void readAllRamadansTest() {
		Ramadan ramadan = new Ramadan(1, "4:19 AM","12:11 PM","3:16 PM","5:16 PM","7:20 PM");
		
		Mockito.when(this.service.addDay(ramadan)).thenReturn(ramadan);
		
		ResponseEntity<Ramadan> response = new ResponseEntity<Ramadan>(ramadan, HttpStatus.OK);
		
		assertThat(response).isEqualTo(this.controller.readAllRamadans());
		
		Mockito.verify(this.service, times(1)).readAll();
	}
	
	@Test
	public void deleteRamadanTest() {
		Ramadan ramadan = new Ramadan(1, "4:19 AM","12:11 PM","3:16 PM","5:16 PM","7:20 PM");
		
		Mockito.when(this.service.addDay(ramadan)).thenReturn(ramadan);
		
		ResponseEntity<Ramadan> response = new ResponseEntity<Ramadan>(ramadan, HttpStatus.NO_CONTENT);
		
		assertThat(response).isEqualTo(this.controller.deleteRamadan(1));
		
		Mockito.verify(this.service, times(1)).deleteDay(1);
	}
	
	
	
	

}
