package com.mborgraeve.arduinoserver.repository;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mborgraeve.arduinoserver.model.Instruction;

@NamedQuery(name = "InstructionRepository.findCurrent",
query = "select * from INSTRUCTION where timelimit >CURRENT_TIMESTAMP order by priority desc")
//TODO put a start in the instruction on server side (not needed on Arduino side), that will probably transalte as a different object, like Instruction and ArduinoInstruction (that would be flattened in the FlattenedInstruction sense)
public interface InstructionRepository extends JpaRepository<Instruction, Integer>{
	Instruction findById(int id);
	
	@Query("select * from ")
	Instruction findCurrent();
// create method to find current instruction. Probably something like add an int priority to instructions and sort them out (float to be able to reorganize them ?).
}
