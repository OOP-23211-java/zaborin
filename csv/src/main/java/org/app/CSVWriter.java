package org.app;
/**
 * Класс {@code CSVWriter} предназначен для записи данных из объекта {@link WordCounter}
 * в формате CSV.
 * слово и количество повторений разделены символом ;.
 */
public class CSVWriter {
    public void write(WordCounter WordCounter){
        for (var entry : WordCounter.sortedWordCount.entries()) {
            int key = entry.getKey();
                System.out.println(entry.getValue() + ";" + key);
        }
    }
}