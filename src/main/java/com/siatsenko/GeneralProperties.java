package com.siatsenko;

import java.util.Arrays;
import java.util.List;

public class GeneralProperties {
    static final char FREE_SYMBOL = '.';
    static final char BLOCKED_SYMBOL = '#';
    static final char START_SYMBOL = 'S';
    static final char FINISH_SYMBOL = 'X';
    static final List<String> STEPS = Arrays.asList("l", "d", "r", "u");
    static final String PATH_NOT_FOUND = "Path not found";
}
