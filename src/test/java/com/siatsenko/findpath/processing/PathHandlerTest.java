package com.siatsenko.findpath.processing;

import com.siatsenko.findpath.entity.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PathHandlerTest {
/*
*        .S..
*        .#..
*        ..X.
**/
    private static final List<Node> NODES = new ArrayList<>(Arrays.asList(
            new Node(false, false, Arrays.asList(1, 4, null, null)),
            new Node(true, false, Arrays.asList(2, null, 0, null)),
            new Node(false, false, Arrays.asList(3, 6, 1, null)),
            new Node(false, false, Arrays.asList(null, 2, 7, null)),

            new Node(false, false, Arrays.asList(null, 8, null, 0)),
            null,
            new Node(false, false, Arrays.asList(7, 10, null, 2)),
            new Node(false, false, Arrays.asList(null, 11, 6, 3)),

            new Node(false, false, Arrays.asList(9, null, null, 4)),
            new Node(false, false, Arrays.asList(10, null, 8, null)),
            new Node(false, true, Arrays.asList(11, null, 9, 6)),
            new Node(false, false, Arrays.asList(null, null, 10, 7))
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
    public void findPath() {
        PathHandler pathHandler = new PathHandler(NODES);
        assertEquals("r,d,d", pathHandler.findPath());
    }
}