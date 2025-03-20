package org.app;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String fileName;
        try {
             fileName = Validator.validateFileArgument(args);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return;
        }

        try (IReader reader = new MyBufferedReader(new FileReader(fileName))) {
            WordCounter WordCounter = new WordCounter(reader);

            WordCounter.process();

            CSVWriter writer = new CSVWriter();
            writer.write(WordCounter);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


