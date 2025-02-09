package org.example;

import java.io.IOException;
import java.util.*;

public class WordCounter {
    Reader file;
    Map<String, Integer> word_count = new HashMap<>();
    public Map<Integer, List<String>> sorted_word_count = new TreeMap<>();
    public WordCounter(Reader file) {
        this.file = file;
    }
    public void processing() throws IOException {
        String line = file.read_line();
        while (line != null) {
            String[] words = line.split("[\\s.,!?]+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    word_count.compute(word, (key, value) -> (value == null) ? 1 : value + 1);
                }
            }
            line = file.read_line();
        }
        sorting();

    }
    private void sorting(){
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