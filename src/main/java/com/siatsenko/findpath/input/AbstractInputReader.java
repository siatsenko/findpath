package com.siatsenko.findpath.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import static com.siatsenko.findpath.common.CommonProperties.*;

public abstract class AbstractInputReader {

    abstract Reader getReader();

    public List<String> getStrings() {
        List<String> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(getReader());
        try {
            String line = bufferedReader.readLine();
            while (line != null && !"".equals(line)) {
                list.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    boolean checkValidInputList(List<String> list) {
        long startCount = 0;
        long finishCount = 0;

        if ((list == null) || (list.size() == 0) || list.get(0).length() == 0) {
            throw new RuntimeException("Wrong list size");
        }
        int columnsCount = list.get(0).length();
        for (String s : list) {
            int length = s.length();
            if (length != columnsCount) {
                throw new RuntimeException("Wrong list size");
            }
            long forbiddenCount = s.chars()
                    .filter(ch -> ch != FREE_SYMBOL)
                    .filter(ch -> ch != BLOCKED_SYMBOL)
                    .filter(ch -> ch != START_SYMBOL)
                    .filter(ch -> ch != FINISH_SYMBOL)
                    .count();
            if (forbiddenCount != 0) {
                throw new RuntimeException("Maze has forbidden symbol");
            }

            startCount = startCount + s.chars().filter(ch -> ch == START_SYMBOL).count();
            finishCount = finishCount + s.chars().filter(ch -> ch == FINISH_SYMBOL).count();
        }
        if (startCount == 0) {
            throw new RuntimeException("Start marker not found");
        }
        if (finishCount == 0) {
            throw new RuntimeException("Finish marker not found");
        }
        if (startCount > 1) {
            throw new RuntimeException("Maze has more then one Start marker");
        }
        if (finishCount > 1) {
            throw new RuntimeException("Maze has more then one Finish marker");
        }
        return true;
    }

}
