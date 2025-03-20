package org.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Класс {@code MyBufferedReader} обертка для стандартного класса {@code BufferedReader}.
 * Нужен для имплеминтации интерфейса
 *
 */
public class MyBufferedReader  extends BufferedReader implements IReader{
    public MyBufferedReader(FileReader in) {
        super(in);
    }

    @Override
    public String readLine() throws IOException {
        return super.readLine();
    }
}
