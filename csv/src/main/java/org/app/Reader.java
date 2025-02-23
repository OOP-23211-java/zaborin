package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public String file_name;
    public BufferedReader reader;
    public Reader(String file_name) throws IOException{
        this.file_name = file_name;
        reader = new BufferedReader(new FileReader(file_name)) ;
    }
    public String read_line() throws IOException{
        String line;
        line = reader.readLine();
        return line;
    }
}