package org.app;

import com.google.common.collect.Multimap;

import java.io.IOException;

import com.google.common.collect.TreeMultimap;
/**
 * Класс для подсчета количества вхождений слов в текстовом файле
 * с использованием {@link Multimap} для хранения отсортированных данных.
 */
public class WordCounter {
    private final IReader file;
    Multimap<Integer, String> sortedWordCount = TreeMultimap.create();
    public WordCounter(IReader file) {
        this.file = file;
    }
    /**
     * Обрабатывает текстовый ввод, подсчитывая количество вхождений слов.
     * Результаты сохраняются в {@code sortedWordCount},.
     *
     * @throws IOException если возникает ошибка при чтении файла
     */
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


