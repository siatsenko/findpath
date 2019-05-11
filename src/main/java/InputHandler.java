import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    private char statrChar = 'S';
    private char finishChar = 'X';

    private Reader reader;

    public InputHandler() {
    }

    public InputHandler(Reader reader) {
        this.reader = reader;
    }

    public List<String> getFromReader() {
        return getFromReader(reader);
    }

    protected List<String> getFromReader(Reader reader) {
        List<String> list = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
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
        boolean startFound = false;
        boolean finishFound = false;

        if ((list == null) || (list.size() == 0) || list.get(0).length() == 0) {
            throw new RuntimeException("Wrong list size");
        }
        int columnsCount = list.get(0).length();
        for (String s : list) {
            int length = s.length();
            if (length != columnsCount) {
                throw new RuntimeException("Wrong list size");
            }
            startFound = startFound || s.contains(String.valueOf(statrChar));
            finishFound = finishFound || s.contains(String.valueOf(finishChar));
        }
        if (!startFound) {
            throw new RuntimeException("Start marker not found");
        }
        if (!finishFound) {
            throw new RuntimeException("Finish marker not found");
        }
        return true;
    }

}