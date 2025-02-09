package org.example;

import java.util.List;
import java.util.Map;

public class CSVWriter {
    public void write(WordCounter word_counter){
        for (Map.Entry<Integer, List<String>> entry : word_counter.sorted_word_count.entrySet()) {
            int value = entry.getKey();
            for (String item : entry.getValue()){
                System.out.println(item + ";" + value);
            }

        }
    }
}