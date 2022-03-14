package com.example.demo.service;

import java.util.List;

public interface ServiceMethods<T> {
	T create(T ramadan);
	
	List<T> readAll();
	
	T readById(long id);
	
	T update(long id, T ramadan);
	
	boolean delete(long id);
		

	}


