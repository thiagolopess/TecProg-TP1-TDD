package app;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.util.*;

public class Persistencia {
    private Map<Integer, List<Integer>> fileData = new HashMap<>();
    private List<String> fileLines = new ArrayList<>();

    public void readFile(String filename) throws ArquivoNaoEncontradoException, FalhaLeituraArquivoException {
        this.fileLines = new ArrayList<>();

        try {
            BufferedReader br = openInputFileReader(filename);
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

    private BufferedReader openInputFileReader(String filename) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filename));
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

    public void writeOutputFile(String outputFormat, String outputPath, char delimiter) throws EscritaNaoPermitidaException {
        try {
            BufferedWriter bw = openOutputWriteFile(outputPath);

            int count = 0;

            if (outputFormat.equals("linhas")) {
                writeLines(bw, delimiter);
            } else {
                writeColumns(bw, delimiter);
            }

            bw.close();
        } catch (AccessDeniedException e) {
            throw new EscritaNaoPermitidaException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedWriter openOutputWriteFile(String outputPath) throws FileNotFoundException {
        OutputStream os = new FileOutputStream(outputPath);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        return bw;
    }

    private void writeColumns(BufferedWriter bw, char delimiter) throws IOException {
        new WriteOutputFile(bw, fileData, delimiter).writeColumns();
    }

    private void writeLines(BufferedWriter bw, char delimiter) throws IOException {
        new WriteOutputFile(bw, fileData, delimiter).writeLines();
    }

    public Map<Integer, List<Integer>> getFileData(){
        return this.fileData;
    }

    public List<String> getFileLines(){
        return this.fileLines;
    }

}
