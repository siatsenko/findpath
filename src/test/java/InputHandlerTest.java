import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InputHandlerTest {

    private static final String INPUT_STRING_CORRECT = "" +
            ".............\n" +
            "..S...#..#...\n" +
            "......#.#....\n" +
            "........#.X..\n";

    private static final List<String> OUTPUT_LIST = Arrays.asList(
            ".............",
            "..S...#..#...",
            "......#.#....",
            "........#.X.."
    );

    private static final String INPUT_STRING_WRONG_1 = "" +
            ".............\n" +
            "..S...#..#...\n" +
            "......#.#....\n" +
            "........#....\n";

    private static final String INPUT_STRING_WRONG_2 = "" +
            ".............\n" +
            "......#..#...\n" +
            "......#.#....\n" +
            "........#.X..\n";

    private static final String INPUT_STRING_WRONG_3 = "" +
            "............\n" +
            "..S...#..#...\n" +
            "......#.#....\n" +
            "........#.X..\n";

    @Test
    public void getFromReader() {
        List<String> list = new InputHandler(new StringReader(INPUT_STRING_CORRECT)).getFromReader();
        assertEquals(OUTPUT_LIST,list);
    }

    @Test
    public void checkValidInputList() {
    }
}