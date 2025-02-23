package org.app;

import java.util.List;
import java.util.Map;

public class CSVWriter {
    public void write(WordCounter wordCounter){
        for (var entry : wordCounter.sortedWordCount.entries()) {
            int key = entry.getKey();
                System.out.println(entry.getValue() + ";" + key);
        }
    }
}


