package com.mborgraeve.arduinoserver;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mborgraeve.arduinoserver.model.Instruction;
import com.mborgraeve.arduinoserver.repository.InstructionRepository;

@RestController
public class DummyConfigurationController {

	@Autowired
	InstructionRepository instructionRepository;
/*
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
*/
	@RequestMapping(value = "/instruction/byId/{id}", produces = "application/json")
	public Instruction CurrentInstruction(@PathVariable("id") int id) {
		System.out.println("served at " + LocalDateTime.now());
		return instructionRepository.findById(id);
	}

	@RequestMapping(value = "/instruction/all/", produces = "application/json")
	public Iterable<Instruction> AllInstructions() {
		Instruction inst = new Instruction(15.0f, 12.0f, new Date(), 70, 5.0f);
		Instruction inst2 = new Instruction(15.0f, 12.0f, new Date(), 70, 10f);
		instructionRepository.save(inst);
		System.out.println("served at " + LocalDateTime.now()+", id of created isntructions:"+inst.getId()+","+inst2.getId());
		instructionRepository.save(inst2);
		System.out.println("new :"+inst2.getId() );
		return instructionRepository.findAll();
	}

}