package com.siatsenko;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.siatsenko.GeneralProperties.*;


public class PrepareHandler {

    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put(FREE_SYMBOL, FREE_NUMBER);
        put(BLOCKED_SYMBOL, BLOCKED_NUMBER);
        put(START_SYMBOL, START_NUMBER);
        put(FINISH_SYMBOL, FINISH_NUMBER);
    }};

    int[][] getFromList(List<String> list) {
        int maxRow = list.size();
        int maxCol = list.get(0).length();
        int[][] mazeArray = new int[maxRow][maxCol];
        for (int row = 0; row < list.size(); row++) {
            String line = list.get(row);
            for (int col = 0; col < line.length(); col++) {
                mazeArray[row][col] = map.get(line.charAt(col));
            }
        }
        return mazeArray;
    }

}
