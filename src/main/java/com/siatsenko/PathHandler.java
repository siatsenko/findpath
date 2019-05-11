package com.siatsenko;

import java.util.LinkedList;
import java.util.List;

public class PathHandler {

    List<Node> nodes;
    int startIndex;
    int finishIndex;

    public PathHandler(List<Node> nodes) {
        this.nodes = nodes;
        setIndexes();
    }

    List<Node> pushWave() {
        LinkedList<Node> queue = new LinkedList<>();
        Node startNode = nodes.get(startIndex);
        startNode.setState(NodeState.FOUND);
        startNode.setStep(0);
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nextStep = node.getStep()+1;
            for (Integer index : node.getNeighboursIndexes()) {
                Node currNode = nodes.get(index);
                if (currNode.getState()==NodeState.UNTOUCHED) {
                    currNode.setState(NodeState.FOUND);
                    currNode.setStep(nextStep);
                    queue.offer(currNode);
                    }
            }
            node.setState(NodeState.PROCESSED);
        }

        return this.nodes;
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
