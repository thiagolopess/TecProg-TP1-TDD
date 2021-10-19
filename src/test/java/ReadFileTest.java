import app.ArquivoNaoEncontradoException;
import app.FileParser;
import org.junit.Assert;
import org.junit.Test;

public class ReadFileTest {

    @Test(expected = ArquivoNaoEncontradoException.class)
    public void test() throws ArquivoNaoEncontradoException {
        FileParser parser = new FileParser();

        parser.readFile("src/analysisMemory.out");
    }

    @Test
    public void test1() {
        FileParser parser = new FileParser();
        String[] lines = {
                "---------- Evolution 0 ----------",
                "1",
                "---------- Evolution 1 ----------",
                "2",
                "---------- Evolution 2 ----------",
                "3"
        };

        try {
            parser.readFile("src/test/resources/analysisMemory.out");
        } catch (ArquivoNaoEncontradoException e) {
            e.printStackTrace();
        }

        Assert.assertArrayEquals(parser.fileLines.toArray(), lines);
    }
}
