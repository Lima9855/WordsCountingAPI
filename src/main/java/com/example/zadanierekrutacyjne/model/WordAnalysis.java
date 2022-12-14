package com.example.zadanierekrutacyjne.model;

import java.util.List;
import java.util.Objects;

public class WordAnalysis {

    private String word;
    private int repetition;
    private List<Integer> position;

    public WordAnalysis(String word, int repetition, List<Integer> position) {
        this.word = word;
        this.repetition = repetition;
        this.position = position;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getRepetition() {
        return repetition;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public List<Integer> getPosition() {
        return position;
    }

    public void setPosition(List<Integer> position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "WordAnalysis{" +
                "word=" + word + '\'' +
                ", repetition=" + repetition +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordAnalysis that = (WordAnalysis) o;

        if (repetition != that.repetition) return false;
        if (!Objects.equals(word, that.word)) return false;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        int result = word != null ? word.hashCode() : 0;
        result = 31 * result + repetition;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
