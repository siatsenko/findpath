package com.siatsenko.findpath.entity;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private boolean start;
    private boolean finish;

    private NodeState state;
    private int step;
    private List<Integer> neighboursIndexes;
    private String path;

    public Node(int num) {
        this.state = NodeState.UNTOUCHED;
        this.step = 0;
        this.neighboursIndexes = new ArrayList<Integer>(4);
    }

    public Node(boolean start, boolean finish, List<Integer> neighboursIndexes) {
        this.start = start;
        this.finish = finish;
        this.state = NodeState.UNTOUCHED;
        this.step = 0;
        this.neighboursIndexes = neighboursIndexes;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public NodeState getState() {
        return state;
    }

    public void setState(NodeState state) {
        this.state = state;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public List<Integer> getNeighboursIndexes() {
        return neighboursIndexes;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Node{" +
                "start=" + start +
                ", finish=" + finish +
                ", state=" + state +
                ", step=" + step +
                ", neighboursIndexes=" + neighboursIndexes +
                ", path='" + path + '\'' +
                '}';
    }
}
