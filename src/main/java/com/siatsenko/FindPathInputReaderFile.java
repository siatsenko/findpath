package com.siatsenko;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class FindPathInputReaderFile extends AbstractFindPathInputReader {

    private File file;

    public FindPathInputReaderFile(File file) {
        this.file = file;
    }

    public FindPathInputReaderFile(String fileName) {
        this.file = new File(fileName);
    }

    @Override
    Reader getReader() {
        try {
            return new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
