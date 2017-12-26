package com.mborgraeve.arduinoserver;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mborgraeve.arduinoserver.models.Greeting;
import com.mborgraeve.arduinoserver.models.Instruction;
import com.mborgraeve.arduinoserver.repository.InstructionRepository;

@RestController
public class DummyConfigurationController {

	@Autowired
	InstructionRepository repo;

	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/greetings", produces = "application/json")
	public Greeting root(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("served at " + LocalDateTime.now());
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping(value = "/instruction", produces = "application/json")
	public Instruction dummyInstruction() {
		System.out.println("served at " + LocalDateTime.now());
		return new Instruction(0, 19.0f, 15.0f, (new Date()), 60);
	}

	@RequestMapping(value = "/instruction/now", produces = "application/json")
	public Instruction CurrentInstruction() {
		System.out.println("served at " + LocalDateTime.now());
		return new Instruction(0, 19.0f, 15.0f, (new Date()), 60);
	}

	@RequestMapping(value="/instruction/byId/{id}",produces="application/json")
	public Instruction CurrentInstruction(@PathVariable("id") int id) {
		System.out.println("served at "+LocalDateTime.now());
		return repo.findById(id);
	}
	
	@RequestMapping(value="/instruction/all/",produces="application/json")
	public Iterable<Instruction> AllInstructions() {
		repo.save(new Instruction(15.0f, 12.0f, new Date(), 70));
		System.out.println("served at "+LocalDateTime.now());
		return repo.findAll();
	}

}