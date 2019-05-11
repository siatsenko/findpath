package com.siatsenko;

import java.util.ArrayList;
import java.util.List;

import static com.siatsenko.GeneralProperties.*;


public class PrepareHandler {

    private char[][] mazeArray;
    private int rowCount;
    private int colCount;

    public PrepareHandler() {

    }

    public PrepareHandler(List<String> list) {
        this.mazeArray = getArrayFromList(list);
        this.rowCount = mazeArray.length;
        this.colCount = mazeArray[0].length;
    }

    List<Node> getNodesFromArray() {
        List<Node> list = new ArrayList<>(rowCount * colCount);
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                Point point = new Point(row, col);
                if (point.getValue() == BLOCKED_SYMBOL) {
                    list.add(null);
                    continue;
                }
                Node node = new Node(point.getNum());
                if (point.getValue() == START_SYMBOL) {
                    node.setStart(true);
                }
                if (point.getValue() == FINISH_SYMBOL) {
                    node.setFinish(true);
                }
                for (int i = 0; i < 4; i++) {
                    Point neighbourPoint = point.move(i);
                    if (neighbourPoint == null) {
                        continue;
                    }
                    if (!neighbourPoint.isValid()) {
                        continue;
                    }
                    if (neighbourPoint.getValue() != BLOCKED_SYMBOL) {
                        node.getNeighboursIndexes().add(neighbourPoint.getNum());
                    }
                }
                list.add(node);
            }
        }
        return list;
    }

    char[][] getArrayFromList(List<String> list) {
        int maxRow = list.size();
        int maxCol = list.get(0).length();
        char[][] array = new char[maxRow][maxCol];
        for (int row = 0; row < list.size(); row++) {
            String line = list.get(row);
            for (int col = 0; col < line.length(); col++) {
                array[row][col] = line.charAt(col);
            }
        }
        return array;
    }

    private class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getNum() {
            return row * mazeArray[0].length + col;
        }

        public Character getValue() {
            if (isValid()) {
                return mazeArray[row][col];
            }
            return null;
        }

        public Point move(int direction) {
            if (direction == 0) {
                return new Point(row, col + 1);
            } // right
            if (direction == 1) {
                return new Point(row + 1, col);
            } // down
            if (direction == 2) {
                return new Point(row, col - 1);
            } // left
            if (direction == 3) {
                return new Point(row - 1, col);
            }  // up
            return null;
        }

        private boolean isValid() {
            if (row > mazeArray.length - 1 || col > mazeArray[0].length - 1 || row < 0 || col < 0) {
                return false;
            }
            return true;
        }

    }
}
