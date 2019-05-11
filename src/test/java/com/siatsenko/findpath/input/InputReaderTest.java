package com.siatsenko.findpath.input;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InputReaderTest {

    private static final String INPUT_STRING_CORRECT = "" +
            ".............\n" +
            "..S...#..#...\n" +
            "......#.#....\n" +
            "........#.X..\n";

    private static final List<String> CORRECT_LIST = Arrays.asList(
            ".............",
            "..S...#..#...",
            "......#.#....",
            "........#.X.."
    );

    private static final List<String> WRONG_LIST_1 = Arrays.asList(
            "............",
            "..S...#..#...",
            "......#.#....",
            "........#.X.."
    );

    private static final List<String> WRONG_LIST_2 = Arrays.asList(
            ".............",
            "......#..#...",
            "......#.#....",
            "........#.X.."
    );

    private static final List<String> WRONG_LIST_3 = Arrays.asList(
            ".............",
            "..S...#..#...",
            "......#.#....",
            "........#...."
    );

    private static final List<String> WRONG_LIST_4 = Arrays.asList(
            ".............",
            "..S...#..#...",
            "..S...#.#....",
            "........#..X."
    );

    private static final List<String> WRONG_LIST_5 = Arrays.asList(
            ".............",
            "..S...#..#...",
            "......#.#....",
            "........#..XX"
    );

    private static final List<String> WRONG_LIST_6 = Arrays.asList(
            "............,",
            "..S...#..#...",
            "......#.#....",
            "........#..X."
    );

    @After
    public void after() {
        System.setIn(System.in);
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void getFromReader() {
        ByteArrayInputStream in = new ByteArrayInputStream(INPUT_STRING_CORRECT.getBytes());
        System.setIn(in);
        List<String> list = new InputReaderStdIn().getStrings();
        assertEquals(CORRECT_LIST,list);
    }

    @Test
    public void checkValidInputList() {
        InputReaderStdIn inputReader = new InputReaderStdIn();
        assertTrue(inputReader.checkValidInputList(CORRECT_LIST));
    }

    @Test
    public void checkValidInputListWrong1() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Wrong list size");
        new InputReaderStdIn().checkValidInputList(WRONG_LIST_1);
    }

    @Test
    public void checkValidInputListWrong2() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Start marker not found");
        new InputReaderStdIn().checkValidInputList(WRONG_LIST_2);;
    }

    @Test
    public void checkValidInputListWrong3() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Finish marker not found");
        new InputReaderStdIn().checkValidInputList(WRONG_LIST_3);
    }

    @Test
    public void checkValidInputListWrong4() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Maze has more then one Start marker");
        new InputReaderStdIn().checkValidInputList(WRONG_LIST_4);
    }

    @Test
    public void checkValidInputListWrong5() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Maze has more then one Finish marker");
        new InputReaderStdIn().checkValidInputList(WRONG_LIST_5);
    }

    @Test
    public void checkValidInputListWrong6() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Maze has forbidden symbol");
        new InputReaderStdIn().checkValidInputList(WRONG_LIST_6);
    }

}