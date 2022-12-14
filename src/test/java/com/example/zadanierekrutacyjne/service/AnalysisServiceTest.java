package com.example.zadanierekrutacyjne.service;

import com.example.zadanierekrutacyjne.model.WordAnalysis;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisServiceTest {

    @Test
    void shouldReturnTrueIfListHasSameObject() {
        AnalysisService analysisService = new AnalysisService();
        String text = "Lista pozycji została zwrócona, zwrócona została pozycji lista";
        List<WordAnalysis> words = analysisService.createListOfWordAnalysis(text);
        assertNotNull(words);
        WordAnalysis wordAnalysis = new WordAnalysis("lista", 2, List.of(1, 8));
        assertTrue(words.contains(wordAnalysis));
    }


    @Test
    void shouldReturnMapOfStringsWithNumbersOfWordRepetitions() {
        AnalysisService analysisService = new AnalysisService();
        String text = "Powturka' Powtórka; Śledź- Sledz Sledz ;;;;;  ";
        Map<String, Integer> test = analysisService.textAnalysisCountingRepetitions(analysisService.getListOfStringsFromText(text));
        assertEquals(2, test.get("sledz"));
        assertEquals(1, test.get("powturka"));
        assertEquals(1, test.get("śledź"));
        assertNull(test.get("śledż"));
    }

    @Test
    void shouldReturnMapOfStringsWithListOfTheirsListOfPositions() {
        AnalysisService analysisService = new AnalysisService();
        String text = "Lista pozycji została zwrócona, zwrócona została pozycji lista";
        Map<String, List<Integer>> test = analysisService.textAnalysisCountingPositionOfWord(analysisService.getListOfStringsFromText(text));
        assertEquals(List.of(1, 8), test.get("lista"));
        assertEquals(List.of(2, 7), test.get("pozycji"));
        assertEquals(List.of(3, 6), test.get("została"));
        assertEquals(List.of(4, 5), test.get("zwrócona"));
    }

    @Test
    void shouldReturnListOfStringsInLowerCaseWithoutSpecialCharactersAndWhiteSpaces() {
        AnalysisService analysisService = new AnalysisService();
        String text = "- ; - - ;;;; .... .. Test .... ,,,, ,,  ,,, test TEST";
        List<String> test = List.of("test", "test", "test");
        analysisService.getListOfStringsFromText(text);
        assertEquals(test, analysisService.getListOfStringsFromText(text));
    }
}