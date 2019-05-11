package com.siatsenko.findpath.prepare;

import com.siatsenko.findpath.entity.Node;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PrepareHandlerTest {

    private static final List<String> LIST = Arrays.asList(
            "..........",
            ".S...#..#.",
            ".....#.#..",
            ".......#.X"
    );

    private static final char[][] ARRAY =
            {
                    {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                    {'.', 'S', '.', '.', '.', '#', '.', '.', '#', '.'},
                    {'.', '.', '.', '.', '.', '#', '.', '#', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '#', '.', 'X'},
            };

    @Test
    public void getArrayFromStrings() {
        assertArrayEquals(ARRAY, new PrepareHandler().getArrayFromStrings(LIST));
    }

    @Test
    public void getNodesFromArray() {
        PrepareHandler prepareHandler = new PrepareHandler(LIST);
        List<Node> nodes = prepareHandler.getNodes();
        assertEquals(40, nodes.size());
        assertTrue(nodes.get(11).isStart());
        assertTrue(nodes.get(39).isFinish());
        assertNull(nodes.get(37));
    }
}