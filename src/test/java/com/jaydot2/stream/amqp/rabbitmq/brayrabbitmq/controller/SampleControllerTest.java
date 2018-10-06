package com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SampleControllerTest {

    MockMvc mockMvc;

    SampleController controller;

    @BeforeEach
    void setUp() {
        controller = new SampleController();
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void home() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    void postMessageToQueue() throws Exception {
        mockMvc.perform(post("/send")).andExpect(status().isOk());
    }

    @Test
    void getMessageFromQueue() throws Exception {
        mockMvc.perform(post("/getMessage")).andExpect(status().isOk());
    }
}