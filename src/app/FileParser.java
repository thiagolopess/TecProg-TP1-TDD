package app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    public List<String> fileLines = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new File(".").getAbsoluteFile());
    }

    public void readFile(String filename) throws ArquivoNaoEncontradoException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String fileLine = br.readLine();

            while (fileLine != null) {
                fileLines.add(fileLine);

                fileLine = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new ArquivoNaoEncontradoException("Arquivo não encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(String filename) throws ArquivoNaoEncontradoException {

    }
}
