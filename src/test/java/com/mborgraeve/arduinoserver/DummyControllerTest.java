package com.mborgraeve.arduinoserver;

import com.mborgraeve.arduinoserver.model.PlanningInstruction;
import com.mborgraeve.arduinoserver.repository.PlanningInstructionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {DummyConfigurationController.class, WebSecurityConfig.class, ArduinoServerApplication.class})
public class DummyControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    PlanningInstructionRepository repo;
    //TODO complete tests with checking content.

    @Before
    public void prepareTest() {
        repo.save(new PlanningInstruction(15.0f, 12.0f, new Date(), new Date((new Date()).getTime() + 1l * 1000l * 60l * 60l), 70, 5.0f));
        repo.save(new PlanningInstruction(15.0f, 12.0f, new Date(), new Date((new Date()).getTime() + 1l * 1000l * 60l * 60l), 70, 10f));
    }

    @Test
    public void getInstructionByIdTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/instruction/byId/1/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(startsWith(("{"))));
    }

    @Test
    public void getCurrentInstructionTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/instruction/current/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(startsWith(("{"))));
    }

    @Test
    public void getAllInstructionsTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/instruction/all/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(startsWith(("["))));
    }

    @Test
    public void getArduinoTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/arduino/current/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(startsWith(("{"))));
    }
}
