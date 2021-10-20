package app;

import java.io.*;
import java.util.*;

public class FileParser {
    public Map<Integer, List<Integer>> fileData = new HashMap<>();
    public List<String> fileLines = new ArrayList<>();
    public char delimiter = ';';
    public String outputPath;
    public String outputFormat;

    public void readFile(String filename) throws ArquivoNaoEncontradoException, FalhaLeituraArquivoException {
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
            throw new FalhaLeituraArquivoException("Falha na leitura do arquivo");
        }
    }

    public void parseDataFile() {
        int key = 0;

        for (String line : fileLines) {
            if (line.contains("-")) {
                key = Integer.parseInt(line.replaceAll("[^0-9]", ""));
                this.fileData.put(key, new ArrayList<>());
            } else {
                this.fileData.get(key).add(Integer.parseInt(line));
            }
        }
    }

    public void readOutputDelimiter() throws DelimitadorInvalidoException {
        Scanner reader = new Scanner(System.in);
        String input = reader.next();

        if (input.length() > 1) {
            throw new DelimitadorInvalidoException();
        }

        this.delimiter = input.charAt(0);
    }

    public void readOutputPath() {
        Scanner reader = new Scanner(System.in);

        this.outputPath = reader.next();
    }

    public void readOutputFormat() {
    }
}
