package app;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.util.*;



public class FileParser {
    public Map<Integer, List<Integer>> fileData = new HashMap<>();
    public List<String> fileLines = new ArrayList<>();
    public char delimiter = ';';
    public String outputPath;
    public String outputFormat;

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
        Scanner reader = new Scanner(System.in);

        this.outputFormat = reader.next();
    }

    public void writeOutputFile() throws EscritaNaoPermitidaException {
        try {
            BufferedWriter bw = openOutputWriteFile();

            int count = 0;

            if (outputFormat.equals("linhas")) {
                writeLines(bw);
            } else {
                writeColumns(bw);
            }

            bw.close();
        } catch (AccessDeniedException e) {
            throw new EscritaNaoPermitidaException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedWriter openOutputWriteFile() throws FileNotFoundException {
        OutputStream os = new FileOutputStream(outputPath);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        return bw;
    }

    private void writeColumns(BufferedWriter bw) throws IOException {
        new WriteOutputFile(bw, fileData, delimiter).writeColumns();
    }

    private void writeLines(BufferedWriter bw) throws IOException {
        new WriteOutputFile(bw, fileData, delimiter).writeLines();
    }

}
