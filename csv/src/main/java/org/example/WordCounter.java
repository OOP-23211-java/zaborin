package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

public class WordCounter {
    private final BufferedReader file;
    Map<String, Integer> word_count = new HashMap<>();
    public Map<Integer, List<String>> sorted_word_count = new TreeMap<>();
    public WordCounter(BufferedReader file) {
        this.file = file;
    }
    public void process() throws IOException {
        String line;
        while ((line = file.readLine()) != null) {
            String[] words = line.split("[\\s.,!?]+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    word_count.compute(word, (key, value) -> (value == null) ? 1 : value + 1);
                }
            }
        }
        sort();
    }
    private void sort(){
        for (Map.Entry<String, Integer> entry : word_count.entrySet()) {
            sorted_word_count.compute(entry.getValue(), (key, value) -> {
                if (value == null) {
                    value = new ArrayList<>();
                }
                value.add(entry.getKey());
                return value;
            });
        }
    }
}