package com.siatsenko;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PathHandlerTest {
    /*
        .S..
        .#..
        ..X.
    */
    private static final List<Node> NODES = new ArrayList<>(Arrays.asList(
            new Node(0, false, false, Arrays.asList(1, 4)),
            new Node(1, true, false, Arrays.asList(0, 2)),
            new Node(2, false, false, Arrays.asList(1, 3, 6)),
            new Node(3, false, false, Arrays.asList(2, 7)),

            new Node(4, false, false, Arrays.asList(0, 8)),
            null,
            new Node(6, false, false, Arrays.asList(2, 7, 10)),
            new Node(7, false, false, Arrays.asList(3, 11, 6)),

            new Node(8, false, false, Arrays.asList(4, 9)),
            new Node(9, false, false, Arrays.asList(8, 10)),
            new Node(10, false, true, Arrays.asList(6, 11, 9)),
            new Node(11, false, false, Arrays.asList(7, 10))
    ));

    @Test
    public void getStartIndex() {
        PathHandler pathHandler = new PathHandler(NODES);
        assertEquals(1, pathHandler.getStartIndex());
    }

    @Test
    public void getFinishIndex() {
        PathHandler pathHandler = new PathHandler(NODES);
        assertEquals(10, pathHandler.getFinishIndex());
    }

    @Test
    public void pushWave() {
        PathHandler pathHandler = new PathHandler(NODES);
        List<Node> nodes = pathHandler.pushWave();
        assertEquals(2, nodes.get(4).getStep());
        assertEquals(3, nodes.get(7).getStep());
        assertEquals(3, nodes.get(10).getStep());
    }
}