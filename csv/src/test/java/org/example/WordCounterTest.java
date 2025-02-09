package org.example;

import org.example.Reader;
import org.example.WordCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WordCounterTest {

    private WordCounter wordCounter;
    private Reader readerMock;

    @BeforeEach
    public void setUp() {
        readerMock = mock(Reader.class);
        wordCounter = new WordCounter(readerMock);
    }

    @Test
    public void testProcessing() throws IOException {
        when(readerMock.read_line())
                .thenReturn("hello world")
                .thenReturn("hello")
                .thenReturn("world world")
                .thenReturn(null);

        wordCounter.processing();

        Map<Integer, List<String>> expected = new TreeMap<>();
        expected.put(2, List.of("hello"));
        expected.put(3, List.of("world"));

        assertEquals(expected, wordCounter.sorted_word_count);
    }
    @Test
    public void testProcessingEmptyLine() throws IOException {
        when(readerMock.read_line())
                .thenReturn("")
                .thenReturn(null);

        wordCounter.processing();

        assertTrue(wordCounter.sorted_word_count.isEmpty());
    }
    @Test
    public void testProcessingSingleWordRepeated() throws IOException {
        when(readerMock.read_line())
                .thenReturn("apple apple apple")
                .thenReturn(null);

        wordCounter.processing();

        Map<Integer, List<String>> expected = new TreeMap<>();
        expected.put(3, List.of("apple"));

        assertEquals(expected, wordCounter.sorted_word_count);
    }
    @Test
    public void testProcessingSpacesAroundWords() throws IOException {
        when(readerMock.read_line())
                .thenReturn("  apple  orange ")
                .thenReturn(null);

        wordCounter.processing();

        Map<Integer, List<String>> expected = new TreeMap<>();
        expected.put(1, List.of("orange", "apple"));

        assertEquals(expected, wordCounter.sorted_word_count);
    }

}
