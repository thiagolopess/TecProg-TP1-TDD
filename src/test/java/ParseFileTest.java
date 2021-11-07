import app.ArquivoNaoEncontradoException;
import app.FalhaLeituraArquivoException;
import app.FileParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ParseFileTest {
    @Test
    public void test() {
        FileParser parser = new FileParser();
        Map<Integer, List<Integer>> fileData;

        try {
            parser.readFile("src/test/resources/analysisMemory.out");
        } catch (ArquivoNaoEncontradoException e) {
            e.printStackTrace();
        } catch (FalhaLeituraArquivoException e) {
            e.printStackTrace();
        }

        parser.parseDataFile();

        fileData = parser.getPersistenceFileData();

        Assert.assertArrayEquals(fileData.get(0).toArray(), new Integer[] { 1 });
        Assert.assertArrayEquals(fileData.get(1).toArray(), new Integer[] { 2 });
        Assert.assertArrayEquals(fileData.get(2).toArray(), new Integer[] { 3 });
    }

    @Test
    public void test1() {
        FileParser parser = new FileParser();
        Map<Integer, List<Integer>> fileData;

        try {
            parser.readFile("src/test/resources/analysisMemory02.out");
        } catch (ArquivoNaoEncontradoException e) {
            e.printStackTrace();
        } catch (FalhaLeituraArquivoException e) {
            e.printStackTrace();
        }

        parser.parseDataFile();

        fileData = parser.getPersistenceFileData();

        Assert.assertArrayEquals(fileData.get(0).toArray(), new Integer[] { 1, 3, 4 });
        Assert.assertArrayEquals(fileData.get(1).toArray(), new Integer[] { 2, 2, 3 });
        Assert.assertArrayEquals(fileData.get(2).toArray(), new Integer[] { 4, 1, 2 });
    }
}
