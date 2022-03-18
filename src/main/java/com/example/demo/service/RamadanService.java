package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Ramadan;
import com.example.demo.repo.RamadanRepo;



@Service
public class RamadanService implements ServiceMethods<Ramadan> {

	private RamadanRepo repo;
	
	public RamadanService(RamadanRepo repo) {
		this.repo=repo;
	}
	
	
	@Override
	public Ramadan addDay(Ramadan ramadan) {
		return this.repo.save(ramadan);
	}

	@Override
	public List<Ramadan> readAll() {
		return this.repo.findAll();
	}

	@Override
	public Ramadan readById(long id) {
		Optional<Ramadan> getRamadan = this.repo.findById(id);
		if(getRamadan.isPresent()) {
			return getRamadan.get();
		}
		return null;
	}

	@Override
	public Ramadan updateDay(long id, Ramadan ramadan) {
		Optional<Ramadan> existingRamadan = this.repo.findById(id);
		if(existingRamadan.isPresent()) {
			Ramadan exists = existingRamadan.get();
			exists.setDay(ramadan.getDay());
			exists.setFajr(ramadan.getFajr());
			exists.setDhur(ramadan.getDhur());
			exists.setAsr(ramadan.getAsr());
			exists.setMaghrib(ramadan.getMaghrib());
			exists.setIsha(ramadan.getIsha());
			return this.repo.saveAndFlush(exists);
			}
		return null;
	}

	@Override
	public boolean deleteDay(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	

}
