import app.EscritaNaoPermitidaException;
import app.FalhaLeituraArquivoException;
import app.ArquivoNaoEncontradoException;
import app.FileParser;
import org.junit.Assert;
import org.junit.Test;

public class WriteOutputFileTest {

    @Test(expected = EscritaNaoPermitidaException.class)
    public void test() throws Exception {
        FileParser parser = new FileParser();

        try {
            parser.readFile("/");
        } catch (FalhaLeituraArquivoException e) {
            e.printStackTrace();
        } catch (ArquivoNaoEncontradoException e) {
            e.printStackTrace();
        }

        parser.parseDataFile();

//        File file = new File("\\\\wsl$\\Ubuntu-20.04\\out");
//        file.setWritable(false);

        parser.delimiter = ';';
        parser.outputPath = "\\\\wsl$\\Ubuntu-20.04\\home\\output.out";

        parser.writeOutputFile("colunas");
    }

    @Test
    public void testLines() {
        FileParser parser = new FileParser();
        String[] wantedOutput = {
                "0;1;3;4",
                "1;2;2;3",
                "2;4;1;2"
        };;

        try {
            parser.readFile("src/test/resources/analysisMemory02.out");
        } catch (ArquivoNaoEncontradoException e) {
            e.printStackTrace();
        } catch (FalhaLeituraArquivoException e) {
            e.printStackTrace();
        }

        try {
            parser.writeOutputFile("linhas");
        } catch (EscritaNaoPermitidaException e) {
            e.printStackTrace();
        }

        try {
            parser.readFile("src/test/resources/analysisMemoryTab.out");
        } catch (ArquivoNaoEncontradoException e) {
            e.printStackTrace();
        } catch (FalhaLeituraArquivoException e) {
            e.printStackTrace();
        }


        Assert.assertArrayEquals(wantedOutput, parser.fileLines.toArray());
    }

    @Test
    public void testColumns() {
        FileParser parser = new FileParser();
        String[] wantedOutput = {
                "0;1;2",
                "1;2;4",
                "3;2;1",
                "4;3;2"
        };;

        try {
            parser.readFile("src/test/resources/analysisMemory02.out");
        } catch (ArquivoNaoEncontradoException e) {
            e.printStackTrace();
        } catch (FalhaLeituraArquivoException e) {
            e.printStackTrace();
        }

        try {
            parser.writeOutputFile("colunas");
        } catch (EscritaNaoPermitidaException e) {
            e.printStackTrace();
        }

        try {
            parser.readFile("src/test/resources/analysisMemoryTab.out");
        } catch (ArquivoNaoEncontradoException e) {
            e.printStackTrace();
        } catch (FalhaLeituraArquivoException e) {
            e.printStackTrace();
        }


        Assert.assertArrayEquals(wantedOutput, parser.fileLines.toArray());
    }
}
