package com.mborgraeve.arduinoserver;

import com.mborgraeve.arduinoserver.model.PlanningInstruction;
import com.mborgraeve.arduinoserver.repository.PlanningInstructionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest
@ContextConfiguration(classes = {DummyConfigurationController.class, WebSecurityConfig.class, ArduinoServerApplication.class})
public class DummyControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PlanningInstructionRepository repo;
    //TODO complete tests with checking content. follow https://www.baeldung.com/spring-boot-testing


    @Before
    public void prepareTest() throws InterruptedException {
//        wait(1800);
//        repo.save(new PlanningInstruction(15.0f, 12.0f, new Date(), new Date((new Date()).getTime() + 1l * 1000l * 60l * 60l), 70, 5.0f));
//        repo.save(new PlanningInstruction(15.0f, 12.0f, new Date(), new Date((new Date()).getTime() + 1l * 1000l * 60l * 60l), 70, 10f));
    }

//    @Test
//    public void getInstructionByIdTest() throws Exception {
//        mvc.perform(get("/instruction/byId/1/").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string(startsWith(("{"))));
//    }

    @Test
    public void givenInstruction_whenGetAll_thenReturnJsonArray()
            throws Exception {

        PlanningInstruction instruction1 = new PlanningInstruction(15.0f, 12.0f, new Date(), new Date((new Date()).getTime() + 1l * 1000l * 60l * 60l), 70, 5.0f);
        PlanningInstruction instruction2 = new PlanningInstruction(15.0f, 12.0f, new Date(), new Date((new Date()).getTime() + 1l * 1000l * 60l * 60l), 70, 10f);

        List<PlanningInstruction> allInstructions = Arrays.asList(instruction1, instruction2);

        given(repo.findAll()).willReturn(allInstructions);

        mvc.perform(get("/instruction/all/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(instruction1.getId())));
    }
//
//    @Test
//    public void getCurrentInstructionTest() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/instruction/current/").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string(startsWith(("{"))));
//    }
//
//    @Test
//    public void getAllInstructionsTest() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/instruction/all/").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string(startsWith(("["))));
//    }
//
//    @Test
//    public void getArduinoTest() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/arduino/current/").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string(startsWith(("{"))));
//    }
}
