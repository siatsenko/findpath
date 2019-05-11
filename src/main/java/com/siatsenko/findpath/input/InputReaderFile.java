package com.siatsenko.findpath.input;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class InputReaderFile extends AbstractInputReader {

    private String fileName;

    public InputReaderFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    Reader getReader() {
        try {
            return new FileReader (fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
