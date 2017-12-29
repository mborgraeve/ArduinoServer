package com.mborgraeve.arduinoserver;

import com.mborgraeve.arduinoserver.model.PlanningInstruction;
import com.mborgraeve.arduinoserver.repository.PlanningInstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
public class DummyConfigurationController {

    @Autowired
    PlanningInstructionRepository instructionRepository;

    /*
     * @RequestMapping(value = "/instruction", produces = "application/json") public
     * Instruction dummyInstruction() { System.out.println("served at " +
     * LocalDateTime.now()); return new Instruction(0, 19.0f, 15.0f, (new Date()),
     * 60); }
     *
     * @RequestMapping(value = "/instruction/now", produces = "application/json")
     * public Instruction CurrentInstruction() { System.out.println("served at " +
     * LocalDateTime.now()); return new Instruction(0, 19.0f, 15.0f, (new Date()),
     * 60); }
     */
    @RequestMapping(value = "/instruction/byId/{id}", produces = "application/json")
    public PlanningInstruction getInstructionById(@PathVariable("id") int id) {
        System.out.println("served at " + LocalDateTime.now());
        return instructionRepository.findById(id);
    }

    @RequestMapping(value = "/instruction/all/", produces = "application/json")
    public Iterable<PlanningInstruction> AllInstructions() {
        PlanningInstruction inst = new PlanningInstruction(15.0f, 12.0f, new Date(), new Date((new Date()).getTime() + 1l * 1000l * 60l * 60l), 70, 5.0f);
        PlanningInstruction inst2 = new PlanningInstruction(15.0f, 12.0f, new Date(), new Date((new Date()).getTime() + 1l * 1000l * 60l * 60l), 70, 10f);
        instructionRepository.save(inst);
        System.out.println("served at " + LocalDateTime.now() + ", id of created instructions:" + inst.getId() + "," + inst2.getId());
        instructionRepository.save(inst2);
        System.out.println("new :" + inst2.getId());
        return instructionRepository.findAll();
    }

    @RequestMapping(value = "/instruction/current/", produces = "application/json")
    public PlanningInstruction CurrentInstruction() {
        System.out.println("served at " + LocalDateTime.now());

        List<PlanningInstruction> instructions = instructionRepository.findCurrent();
        PlanningInstruction tmp = instructions.isEmpty() ? null : instructions.get(0);
        return tmp;
    }

}