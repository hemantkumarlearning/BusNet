package com.hemant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hemant.controller.BusController;
import com.hemant.exceptions.BusException;
import com.hemant.model.Bus;
import com.hemant.service.BusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BusController.class)
public class BusControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BusService busService;

    @InjectMocks
    private BusController busController;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(busController).build();
    }

    @Test
    public void saveBusTest() throws Exception{
        Bus bus = new Bus();
        bus.setBusId(1);
        bus.setBusName("Payal");
        bus.setBusType("AC");
        when(busService.addBus(any(Bus.class))).thenReturn(bus);

        mockMvc.perform(post("/save")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(bus)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.BusId").value(1))
                .andExpect(jsonPath("$.BusName").value("Payal"))
                .andExpect(jsonPath("$.BusType").value("AC"));
    }
}
