package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Ramadan;
import com.example.demo.repo.RamadanRepo;

@SpringBootTest
public class RamadanServiceUnitTest {

	@Autowired
	private RamadanService service;

	
	@MockBean
	private RamadanRepo repo;

	@Test
	public void AddDayTest() {
		Ramadan input = new Ramadan(3,1, "4:19 AM","12:11 PM","3:16 PM","5:16 PM","7:20 PM" );
		Ramadan output = new Ramadan(1L, 1, "4:19 AM","12:11 PM","3:16 PM","5:16 PM","7:20 PM" );

		
		Mockito.when(this.repo.save(input)).thenReturn(output);

	
		assertEquals(output, this.service.addDay(input));
		
		
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}
	
	@Test
	public void readByIdTest() {

		Optional<Ramadan> optionalOutput = Optional.of(new Ramadan(1L,1, "4:19 AM","12:11 PM","3:16 PM","5:16 PM","7:20 PM"));
		Ramadan output = new Ramadan(1L, 1, "4:19 AM","12:11 PM","3:16 PM","5:16 PM","7:20 PM");
		

		Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(optionalOutput);
		
		assertEquals(output, this.service.readById(Mockito.anyLong()));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
	}
	
	
	@Test
	public void readAllTest() {
	
		
		Ramadan output = new Ramadan(1L, 1, "4:19 AM","12:11 PM","3:16 PM","5:16 PM","7:20 PM");
		List<Ramadan> times = new ArrayList<Ramadan>();
		times.add(output);
		
		Mockito.when(this.repo.findAll()).thenReturn(times);
		
		assertEquals(times, this.service.readAll());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	
	
	
	
	
	
	@Test
	public void deleteTrueTest() {
		Mockito.when(this.repo.existsById(1L)).thenReturn(false);
		
		assertTrue(this.service.deleteDay(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}

	@Test
	public void UpdateDayTest() {
		Optional<Ramadan> optionalOutput = Optional.of(new Ramadan(1L,1, "4:20 AM","12:12 PM","3:17 PM","5:17 PM","7:21 PM"));
		Ramadan input = new Ramadan(1, "4:19 AM","12:11 PM","3:16 PM","5:16 PM","7:20 PM" );
		Ramadan output = new Ramadan(1L, 1, "4:19 AM","12:11 PM","3:16 PM","5:16 PM","7:20 PM" );

		Mockito.when(this.repo.findById(1L)).thenReturn(optionalOutput);
		
		
		Mockito.when(this.repo.saveAndFlush(output)).thenReturn(output);
		assertEquals(output, this.service.updateDay(1L, input));
	
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(output);
	}
	
	
}
