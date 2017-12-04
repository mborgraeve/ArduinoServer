package com.mborgraeve.arduinoserver.repository;

import org.springframework.data.repository.CrudRepository;

import com.mborgraeve.arduinoserver.models.Instruction;

public interface InstructionRepository extends CrudRepository<Instruction, Long> {
	Instruction findById(Long id);
}
