package com.siatsenko;

import com.siatsenko.InputHandler;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InputHandlerTest {

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

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void getFromReader() {
        List<String> list = new InputHandler(new StringReader(INPUT_STRING_CORRECT)).getFromReader();
        assertEquals(CORRECT_LIST,list);
    }

    @Test
    public void checkValidInputList() {
        InputHandler inputHandler = new InputHandler();
        assertTrue(inputHandler.checkValidInputList(CORRECT_LIST));
    }

    @Test
    public void checkValidInputListWrong1() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Wrong list size");
        new InputHandler().checkValidInputList(WRONG_LIST_1);
    }

    @Test
    public void checkValidInputListWrong2() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Start marker not found");
        new InputHandler().checkValidInputList(WRONG_LIST_2);
    }

    @Test
    public void checkValidInputListWrong3() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Finish marker not found");
        new InputHandler().checkValidInputList(WRONG_LIST_3);
    }

    @Test
    public void checkValidInputListWrong4() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Maze has more then one Start marker");
        new InputHandler().checkValidInputList(WRONG_LIST_4);
    }

    @Test
    public void checkValidInputListWrong5() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Maze has more then one Finish marker");
        new InputHandler().checkValidInputList(WRONG_LIST_5);
    }

    @Test
    public void checkValidInputListWrong6() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Maze has forbidden symbol");
        new InputHandler().checkValidInputList(WRONG_LIST_6);
    }

}