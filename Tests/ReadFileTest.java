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
}
