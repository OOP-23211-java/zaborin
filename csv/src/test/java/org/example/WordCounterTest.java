package org.example;

import org.example.Reader;
import org.example.WordCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WordCounterTest {

    private WordCounter wordCounter;
    private BufferedReader readerMock;

    @BeforeEach
    public void setUp() {
        readerMock = mock(BufferedReader.class);
        wordCounter = new WordCounter(readerMock);
    }

    @Test
    public void testProcess() throws IOException {
        when(readerMock.readLine())
                .thenReturn("hello world")
                .thenReturn("hello")
                .thenReturn("world world")
                .thenReturn(null);

        wordCounter.process();

        Map<Integer, List<String>> expected = new TreeMap<>();
        expected.put(2, List.of("hello"));
        expected.put(3, List.of("world"));

        assertEquals(expected, wordCounter.sorted_word_count);
    }
    @Test
    public void testProcessEmptyLine() throws IOException {
        when(readerMock.readLine())
                .thenReturn("")
                .thenReturn(null);

        wordCounter.process();

        assertTrue(wordCounter.sorted_word_count.isEmpty());
    }
    @Test
    public void testProcessSingleWordRepeated() throws IOException {
        when(readerMock.readLine())
                .thenReturn("apple apple apple")
                .thenReturn(null);

        wordCounter.process();

        Map<Integer, List<String>> expected = new TreeMap<>();
        expected.put(3, List.of("apple"));

        assertEquals(expected, wordCounter.sorted_word_count);
    }
    @Test
    public void testProcessSpacesAroundWords() throws IOException {
        when(readerMock.readLine())
                .thenReturn("  apple  orange ")
                .thenReturn(null);

        wordCounter.process();

        Map<Integer, List<String>> expected = new TreeMap<>();
        expected.put(1, List.of("orange", "apple"));

        assertEquals(expected, wordCounter.sorted_word_count);
    }

}
