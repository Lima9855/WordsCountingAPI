package com.example.zadanierekrutacyjne.controller;

import com.example.zadanierekrutacyjne.model.WordAnalysis;
import com.example.zadanierekrutacyjne.service.AnalysisService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    private final AnalysisService analysisService;

    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping
    public List<WordAnalysis> createAnalysisResponse(@RequestBody String text) {
        return analysisService.createListOfWordAnalysis(text);
    }

}
