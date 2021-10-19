import app.ArquivoNaoEncontradoException;
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
        }

        parser.parseDataFile();

        Assert.assertArrayEquals(parser.fileData.get(0), new int[] { 1 });
        Assert.assertArrayEquals(parser.fileData.get(1), new int[] { 2 });
        Assert.assertArrayEquals(parser.fileData.get(2), new int[] { 3 });
    }
}
