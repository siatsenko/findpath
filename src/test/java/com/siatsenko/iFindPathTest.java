package com.siatsenko;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class iFindPathTest {

    private static final String INPUT_STRING = "" +
            "....................................\n" +
            "..S...#......................#......\n" +
            "......#......................#......\n" +
            ".............................#......\n" +
            "....................................\n" +
            "....................................\n" +
            "..............#.....................\n" +
            "............#.......................\n" +
            "..........#.........................\n" +
            "....................................\n" +
            ".....................#..........#...\n" +
            ".....................#....X.....#...\n" +
            ".....................#..........#...\n" +
            "....................................";


    private static final String OUTPUT_STRING =
            "l,l,l,d,d,l,l,l,l,l,l,l,l,l,l,l,l,l,l,l,l,l,l,l,l,l,d,d,d,d,d,d,d,d";

    @Before
    public void before() {
        ByteArrayInputStream in = new ByteArrayInputStream(INPUT_STRING.getBytes());
        System.setIn(in);
    }

    @After
    public void after() {
        System.setIn(System.in);
    }

    @Test
    public void get() {
        String path = new FindPathInputReaderStdIn().findPath();
        assertEquals(OUTPUT_STRING, path);
    }

}