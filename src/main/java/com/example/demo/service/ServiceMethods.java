package com.example.demo.service;

import java.util.List;

public interface ServiceMethods<T> {
	T addDay(T ramadan);
	
	List<T> readAll();
	
	T readById(long id);
	
	T updateDay(long id, T ramadan);
	
	boolean deleteDay(long id);
		

	}


