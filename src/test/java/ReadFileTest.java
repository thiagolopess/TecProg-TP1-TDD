import app.ArquivoNaoEncontradoException;
import app.FalhaLeituraArquivoException;
import app.FileParser;
import org.junit.Assert;
import org.junit.Test;

public class ReadFileTest {

    @Test(expected = ArquivoNaoEncontradoException.class)
    public void test() throws ArquivoNaoEncontradoException {
        FileParser parser = new FileParser();

        try {
            parser.readFile("src/analysisMemory.out");
        } catch (FalhaLeituraArquivoException e) {
            e.printStackTrace();
        }
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
            parser.readFile("src/test/resources/analysisMemory02.out");
        } catch (ArquivoNaoEncontradoException e) {
            e.printStackTrace();
        } catch (FalhaLeituraArquivoException e) {
            e.printStackTrace();
        }

        Assert.assertArrayEquals(parser.fileLines.toArray(), lines);
    }
}
