import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    private Reader reader;

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
        if ((list == null) || (list.size() == 0) || list.get(0).length() == 0) {
            return false;
        }
        int columnsCount = list.get(0).length();
        for (String s : list) {
            int length = s.length();
            if (length != columnsCount) {
                return false;
            }
        }
        return true;
    }

}