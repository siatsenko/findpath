package com.siatsenko.findpath.processing;

import com.siatsenko.findpath.input.InputReaderStdIn;
import com.siatsenko.findpath.prepare.PrepareHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.Assert.*;

public class FindPathTest {

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
            "r,r,r,d,d,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,d,d,d,d,d,d,d,d";

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
        List<String> strings = new InputReaderStdIn().getStrings();
        PrepareHandler prepareHandler = new PrepareHandler(strings);
        PathHandler pathHandler = new PathHandler(prepareHandler.getNodes());
        String path = pathHandler.findPath();
        assertEquals(OUTPUT_STRING, path);
    }

}