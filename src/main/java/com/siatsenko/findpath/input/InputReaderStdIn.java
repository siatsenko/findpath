package com.siatsenko.findpath.input;

import java.io.InputStreamReader;
import java.io.Reader;

public class InputReaderStdIn extends AbstractInputReader {

    @Override
    Reader getReader() {
        return new InputStreamReader(System.in);
    }
}
