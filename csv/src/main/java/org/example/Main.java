package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("1.txt"))) {
            WordCounter word_counter = new WordCounter(reader);

            word_counter.process();

            CSVWriter writer = new CSVWriter();
            writer.write(word_counter);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}


