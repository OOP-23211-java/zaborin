package org.app;

import java.io.BufferedReader;
import java.io.IOException;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;

public class WordCounter {
    private final BufferedReader file;
    Multimap<Integer, String> sortedWordCount = TreeMultimap.create();
    public WordCounter(BufferedReader file) {
        this.file = file;
    }

    public void process() throws IOException {
        String line;
        while ((line = file.readLine()) != null) {
            String[] words = line.split("[\\s.,!?]+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    int newKey = 0;

                    for (var entry : sortedWordCount.entries()) {
                        if (entry.getValue().equals(word)) {
                            newKey = entry.getKey();
                            sortedWordCount.remove(newKey, word);
                            break;
                        }
                    }

                    sortedWordCount.put(newKey + 1, word);
                }
            }
        }
    }
}


