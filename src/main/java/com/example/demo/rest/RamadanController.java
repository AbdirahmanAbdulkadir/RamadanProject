package com.example.demo.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Ramadan;
import com.example.demo.service.RamadanService;



@RestController
@RequestMapping("/ramadan")
public class RamadanController {

	private RamadanService service;

	private RamadanController(RamadanService service) {
		this.service=service;
		}

	@PostMapping("/addDay")
	public ResponseEntity<Ramadan> createRamadan(@RequestBody Ramadan ramadan) {
		return new ResponseEntity<Ramadan>(this.service.addDay(ramadan), HttpStatus.CREATED);
	}

	@GetMapping("/readById/{id}")
	public ResponseEntity<Ramadan> readById(@PathVariable long id) {
		return new ResponseEntity<Ramadan>(this.service.readById(id), HttpStatus.OK);
	}

	@DeleteMapping("/deleteDay/{id}")
	public ResponseEntity<Boolean> deleteRamadan(@PathVariable long id) {
		return (this.service.deleteDay(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/readAll")
	public ResponseEntity<List<Ramadan>> readAllRamadans() {
		return new ResponseEntity<List<Ramadan>>(this.service.readAll(), HttpStatus.OK);

	}

	@PutMapping("/updateDay/{id}")
	public ResponseEntity<Ramadan> updateRamadan(@PathVariable long id, @RequestBody Ramadan ramadan) {
		return new ResponseEntity<Ramadan>(this.service.updateDay(id, ramadan), HttpStatus.ACCEPTED);

	}

}
