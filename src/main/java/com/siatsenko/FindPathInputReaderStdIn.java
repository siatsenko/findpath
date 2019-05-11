package com.siatsenko;

import java.io.InputStreamReader;
import java.io.Reader;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader {

    @Override
    Reader getReader() {
        return new InputStreamReader(System.in);
    }
}
