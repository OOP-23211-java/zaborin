package org.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("1.txt"))) {
            WordCounter wordCounter = new WordCounter(reader);

            wordCounter.process();

            CSVWriter writer = new CSVWriter();
            writer.write(wordCounter);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}


