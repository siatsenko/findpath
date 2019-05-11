package com.siatsenko;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PrepareHandlerTest {

    private static final List<String> LIST = Arrays.asList(
            ".............",
            "..S...#..#...",
            "......#.#....",
            "........#.X.."
    );

    private static final int[][] ARRAY =
            {
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 2, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 3, 0, 0}
            };

    @Test
    public void getFromList() {
        assertArrayEquals(ARRAY,new PrepareHandler().getFromList(LIST));
    }
}