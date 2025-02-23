package org.app;

import com.google.common.collect.Multimap;
import org.app.Reader;
import org.app.WordCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.google.common.collect.TreeMultimap;

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

        Multimap<Integer,String> expected = TreeMultimap.create();
        expected.put(2, "hello");
        expected.put(3, "world");

        assertEquals(expected, wordCounter.sortedWordCount);
    }
    @Test
    public void testProcessEmptyLine() throws IOException {
        when(readerMock.readLine())
                .thenReturn("")
                .thenReturn(null);

        wordCounter.process();

        assertTrue(wordCounter.sortedWordCount.isEmpty());
    }
    @Test
    public void testProcessSingleWordRepeated() throws IOException {
        when(readerMock.readLine())
                .thenReturn("apple apple apple")
                .thenReturn(null);

        wordCounter.process();

        Multimap<Integer, String> expected = TreeMultimap.create();
        expected.put(3, "apple");

        assertEquals(expected, wordCounter.sortedWordCount);
    }
    @Test
    public void testProcessSpacesAroundWords() throws IOException {
        when(readerMock.readLine())
                .thenReturn("  apple  orange ")
                .thenReturn(null);

        wordCounter.process();

        Multimap<Integer, String> expected = TreeMultimap.create();;
        expected.put(1, "orange");
        expected.put(1, "apple");

        assertEquals(expected, wordCounter.sortedWordCount);
    }

}


