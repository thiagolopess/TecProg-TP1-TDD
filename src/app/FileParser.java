package app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class FileParser {
    public Map<Integer, int[]> fileData = new HashMap<>();
    public List<String> fileLines = new ArrayList<>();

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

    public void parseDataFile() {
    }
}
