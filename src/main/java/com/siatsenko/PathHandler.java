package com.siatsenko;

import java.util.LinkedList;
import java.util.List;

import static com.siatsenko.GeneralProperties.*;

public class PathHandler {

    List<Node> nodes;
    int startIndex;
    int finishIndex;

    public PathHandler(List<Node> nodes) {
        this.nodes = nodes;
        setIndexes();
    }

    String findPath() {
        LinkedList<Node> queue = new LinkedList<>();
        Node startNode = nodes.get(startIndex);
        startNode.setState(NodeState.FOUND);
        startNode.setStep(0);
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nextStep = node.getStep() + 1;
            List<Integer> neighbours = node.getNeighboursIndexes();
            for (int i = 0; i < 4; i++) {
                Integer index = neighbours.get(i);
                if (index == null) {
                    continue;
                }
                Node currNode = nodes.get(index);
                if (currNode.getState() == NodeState.UNTOUCHED) {
                    currNode.setState(NodeState.FOUND);
                    currNode.setStep(nextStep);
                    queue.offer(currNode);
                    String path = node.getPath();
                    String currPath = (path == null ? "" : (path + ",")) + STEPS.get(i);
                    currNode.setPath(currPath);
                    if (currNode.isFinish()) {
                        return currPath;
                    }
                }
            }
            node.setState(NodeState.PROCESSED);
        }
        return PATH_NOT_FOUND;
    }

    void setIndexes() {
        int done = 0;
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if (node == null) {
                continue;
            }
            if (node.isStart()) {
                startIndex = i;
                done++;
            }
            if (node.isFinish()) {
                finishIndex = i;
                done++;
            }
            if (done == 2) {
                break;
            }
        }
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getFinishIndex() {
        return finishIndex;
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
