package org.example;

import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try {
            Reader read = new Reader("1.txt");

            WordCounter word_counter = new WordCounter(read);
            word_counter.processing();

            CSVWriter writer = new CSVWriter();
            writer.write(word_counter);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}