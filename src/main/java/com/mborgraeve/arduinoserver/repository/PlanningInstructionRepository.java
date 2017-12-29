package com.mborgraeve.arduinoserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mborgraeve.arduinoserver.model.PlanningInstruction;

//TODO put a start in the instruction on server side (not needed on Arduino side), that will probably transalte as a different object, like Instruction and ArduinoInstruction (that would be flattened in the FlattenedInstruction sense)
public interface PlanningInstructionRepository extends JpaRepository<PlanningInstruction, Integer>{
	PlanningInstruction findById(int id);
	
	@Query("select id, instructedTemperature, defaultTemperature, startDate, endDate, cycleDuration from PlanningInstruction where START_DATE > CURRENT_TIMESTAMP and END_DATE < CURRENT_TIMESTAMP order by priority desc")
	PlanningInstruction findCurrent();
// create method to find current instruction. Probably something like add an int priority to instructions and sort them out (float to be able to reorganize them ?).
}