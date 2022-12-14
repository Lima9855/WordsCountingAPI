package com.example.zadanierekrutacyjne.service;

import com.example.zadanierekrutacyjne.model.WordAnalysis;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnalysisService {

    public List<WordAnalysis> createListOfWordAnalysis(String text) {
        Map<String, Integer> repetitions = textAnalysisCountingRepetitions(getListOfStringsFromText(text));
        Map<String, List<Integer>> positions = textAnalysisCountingPositionOfWord(getListOfStringsFromText(text));
        Set<String> words = repetitions.keySet();
        List<WordAnalysis> wordAnalysisList = new ArrayList<>();
        for (String s : words) {
            wordAnalysisList.add(
                    new WordAnalysis(
                            s,
                            repetitions.get(s),
                            positions.get(s)
                    )
            );
        }
        return wordAnalysisList;
    }

    public Map<String, Integer> textAnalysisCountingRepetitions(List<String> words) {
        TreeMap<String, Integer> countedWords = new TreeMap<>();
        for (String s : words) {
            if (countedWords.containsKey(s)) {
                int count = countedWords.get(s);
                countedWords.put(s, count + 1);
            } else {
                countedWords.put(s, 1);
            }
        }
        return countedWords;
    }

    public Map<String, List<Integer>> textAnalysisCountingPositionOfWord(List<String> words) {
        HashMap<String, List<Integer>> wordPosition = new HashMap<>();
        int counter = 1;
        for (String s : words) {
            wordPosition.computeIfAbsent(s, integer -> new ArrayList<>()).add(counter);
            counter++;
        }
        return wordPosition;
    }

    public List<String> getListOfStringsFromText(String text) {
        return Arrays.stream(text.toLowerCase()
                .replaceAll("[-+,+.+(+)+–+;+:+!+?+'+^+@+#+$+%+&+*+|+>+<]", " ")
                .split(" ")).filter(string -> !string.equals("")).toList();
    }


}
