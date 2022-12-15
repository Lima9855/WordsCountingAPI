package com.example.zadanierekrutacyjne.controller;

import com.example.zadanierekrutacyjne.service.AnalysisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AnalysisController.class)
@Import(AnalysisService.class)
class AnalysisControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void createAnalysisResponse() throws Exception {
        mvc.perform(post("/analysis")
                        .content("Lista pozycji została zwrócona, zwrócona została pozycji lista"))
                .andExpect(status().isOk());
    }
}