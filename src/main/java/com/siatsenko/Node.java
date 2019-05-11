package com.siatsenko;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private int num;
    private boolean start;
    private boolean finish;

    private NodeState state;
    private int stepCount;
    private List<Integer> neighbours;
    private List<Node> path;

    public Node(int num) {
        this.num = num;
        this.state = NodeState.UNTOUCHED;
        this.stepCount = 0;
        this.neighbours = new ArrayList<Integer>();
        this.path = new ArrayList<Node>();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public List<Integer> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Integer> neighbours) {
        this.neighbours = neighbours;
    }

    public List<Node> getPath() {
        return path;
    }

    public void setPath(List<Node> path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", start=" + start +
                ", finish=" + finish +
                ", state=" + state +
                ", stepCount=" + stepCount +
                ", neighbours=" + neighbours +
                ", path=" + path +
                '}';
    }
}
