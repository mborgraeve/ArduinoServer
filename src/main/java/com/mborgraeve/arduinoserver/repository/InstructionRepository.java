package com.mborgraeve.arduinoserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mborgraeve.arduinoserver.model.Instruction;


public interface InstructionRepository extends JpaRepository<Instruction, Integer>{
	Instruction findById(int id);
// create method to find current instruction. Probably something like add an int priority to instructions and sort them out (float to be able to reorganize them ?).
}
