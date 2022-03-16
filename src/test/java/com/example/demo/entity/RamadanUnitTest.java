package com.example.demo.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
public class RamadanUnitTest {

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Ramadan.class).usingGetClass().verify();
	}

	@Test
	public void getAndSetTest() {
		// Create empty duck object
		Ramadan ramadan = new Ramadan();

		// Use the setter methods to add values to each field, so we can check the
		// setters work
		ramadan.setId(1L);
		ramadan.setDay(4);
		ramadan.setFajr("5:30 AM");
		ramadan.setDhur("11:30 AM");
		ramadan.setAsr("3:30 PM");
		ramadan.setMaghrib("5:30 PM");
		ramadan.setIsha("8:27 PM");
		

		// make sure after the setters, they actually set the values and are not null
		assertNotNull(ramadan.getId());
		assertNotNull(ramadan.getDay());
		assertNotNull(ramadan.getFajr());
		assertNotNull(ramadan.getDhur());
		assertNotNull(ramadan.getAsr());
		assertNotNull(ramadan.getMaghrib());
		assertNotNull(ramadan.getIsha());

		// make sure that when we use the getters, they get the correct value
		
		assertEquals(ramadan.getId(),1L);
		assertEquals(ramadan.getDay(),4);
		assertEquals(ramadan.getFajr(),"5:30 AM");
		assertEquals(ramadan.getDhur(),"11:30 AM");
		assertEquals(ramadan.getAsr(),"3:30 PM");
		assertEquals(ramadan.getMaghrib(),"5:30 PM");
		assertEquals(ramadan.getIsha(),"8:27 PM");
		
	}

	@Test
	public void allArgsConstructor() {
		Ramadan ramadan = new Ramadan(1L,1, "4:19 AM","12:11 PM","3:16 PM","5:16 PM","7:20 PM" );

		// make sure after the setters, they actually set the values and are not null
		assertNotNull(ramadan.getId());
		assertNotNull(ramadan.getDay());
		assertNotNull(ramadan.getFajr());
		assertNotNull(ramadan.getDhur());
		assertNotNull(ramadan.getAsr());
		assertNotNull(ramadan.getMaghrib());
		assertNotNull(ramadan.getIsha());

		// make sure that when we use the getters, they get the correct value
		assertEquals(ramadan.getId(),1L);
		assertEquals(ramadan.getDay(),1);
		assertEquals(ramadan.getFajr(),"4:19 AM");
		assertEquals(ramadan.getDhur(),"12:11 PM");
		assertEquals(ramadan.getAsr(),"3:16 PM");
		assertEquals(ramadan.getMaghrib(),"5:16 PM");
		assertEquals(ramadan.getIsha(),"7:20 PM");
	}
}
