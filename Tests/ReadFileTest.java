import App.FileParser;
import org.junit.Test;
import static org.junit.Assert.*;

import Exceptions.ArquivoNaoEncontradoException;

public class ReadFileTest {

    @Test(expected = ArquivoNaoEncontradoException.class)
    public void test() throws ArquivoNaoEncontradoException {
        FileParser parser = new FileParser();

        parser.readFile("analysisMemory.out");
    }

    @Test
    public void test1() {
        FileParser parser = new FileParser();

        try {
            parser.readFile("analysis_files/tests/analysisMemory.out");
        } catch (ArquivoNaoEncontradoException e) {
            e.printStackTrace();
        }

        String[] lines = {
                "---------- Evolution 0 ----------",
                "1", "---------- Evolution 1 ----------",
                "2", "---------- Evolution 2 ----------",
                "3"
        };

        assertArrayEquals(parser.fileLines.toArray(), lines);
    }
}
