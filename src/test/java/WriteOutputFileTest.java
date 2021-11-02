import app.EscritaNaoPermitidaException;
import app.FalhaLeituraArquivoException;
import app.ArquivoNaoEncontradoException;
import app.FileParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class WriteOutputFileTest {

//    @Test(expected = EscritaNaoPermitidaException.class)
//    public void test() throws Exception {
//        FileParser parser = new FileParser();
//
//        try {
//            parser.readFile("src/test/resources/analysisMemory.out");
//        } catch (FalhaLeituraArquivoException e) {
//            e.printStackTrace();
//        } catch (ArquivoNaoEncontradoException e) {
//            throw e;
//        }
//
//        parser.parseDataFile();
//
//        parser.delimiter = ';';
//        parser.outputFormat = "linhas";
//        parser.outputPath = "src/test/resources/analysisMemoryTab.out";
//
//        // this test needs to change permission to simulate EscritaNaoPermitidaException exception
//
//        parser.writeOutputFile();
//    }

    @Test
    public void testLines() {
        FileParser parser = new FileParser();

        String[] wantedOutput = {
                "0;1;3;2;9;8",
                "1;2;2;3",
                "2;2;7"
        };;

        try {
            parser.readFile("src/test/resources/analysisMemory03.out");
        } catch (ArquivoNaoEncontradoException e) {
            e.printStackTrace();
        } catch (FalhaLeituraArquivoException e) {
            e.printStackTrace();
        }

        parser.parseDataFile();

        parser.delimiter = ';';
        parser.outputFormat = "linhas";
        parser.outputPath = "src/test/resources/analysisMemoryTab.out";

        try {
            parser.writeOutputFile();
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


        Assert.assertArrayEquals(wantedOutput, parser.getPersistenceFileLines().toArray());
    }

    @Test
    public void testColumns() {
        FileParser parser = new FileParser();

        String[] wantedOutput = {
                "0;1;2",
                "1;2;2;",
                "3;2;7;",
                "2;3;",
                "9;",
                "8;"
        };

        try {
            parser.readFile("src/test/resources/analysisMemory03.out");
        } catch (ArquivoNaoEncontradoException e) {
            e.printStackTrace();
        } catch (FalhaLeituraArquivoException e) {
            e.printStackTrace();
        }

        parser.parseDataFile();

        parser.delimiter = ';';
        parser.outputFormat = "colunas";
        parser.outputPath = "src/test/resources/analysisMemoryTab.out";

        try {
            parser.writeOutputFile();
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

        Assert.assertArrayEquals(wantedOutput, parser.getPersistenceFileLines().toArray());
    }
}
