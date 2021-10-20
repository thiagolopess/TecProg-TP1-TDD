import app.ArquivoNaoEncontradoException;
import app.FalhaLeituraArquivoException;
import app.FileParser;
import org.junit.Assert;
import org.junit.Test;

public class ParseFileTest {
    @Test
    public void test() {
        FileParser parser = new FileParser();

        try {
            parser.readFile("src/test/resources/analysisMemory.out");
        } catch (ArquivoNaoEncontradoException e) {
            e.printStackTrace();
        } catch (FalhaLeituraArquivoException e) {
            e.printStackTrace();
        }

        parser.parseDataFile();

        Assert.assertArrayEquals(parser.fileData.get(0).toArray(), new Integer[] { 1 });
        Assert.assertArrayEquals(parser.fileData.get(1).toArray(), new Integer[] { 2 });
        Assert.assertArrayEquals(parser.fileData.get(2).toArray(), new Integer[] { 3 });
    }

    @Test
    public void test1() {
        FileParser parser = new FileParser();

        try {
            parser.readFile("src/test/resources/analysisMemory02.out");
        } catch (ArquivoNaoEncontradoException e) {
            e.printStackTrace();
        } catch (FalhaLeituraArquivoException e) {
            e.printStackTrace();
        }

        parser.parseDataFile();

        Assert.assertArrayEquals(parser.fileData.get(0).toArray(), new Integer[] { 1, 3, 4 });
        Assert.assertArrayEquals(parser.fileData.get(1).toArray(), new Integer[] { 2, 2, 3 });
        Assert.assertArrayEquals(parser.fileData.get(2).toArray(), new Integer[] { 4, 1, 2 });
    }
}
