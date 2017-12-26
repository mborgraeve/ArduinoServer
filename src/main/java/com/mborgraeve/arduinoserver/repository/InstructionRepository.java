package com.mborgraeve.arduinoserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mborgraeve.arduinoserver.model.Instruction;


public interface InstructionRepository extends JpaRepository<Instruction, Integer>{
	Instruction findById(int id);

}
