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
        Scanner reader = new Scanner(System.in);

        this.outputFormat = reader.next();
    }

    public void writeOutputFile() throws EscritaNaoPermitidaException {
        try {
            OutputStream os = new FileOutputStream(outputPath);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

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

    private void writeColumns(BufferedWriter bw) throws IOException {
        int count;
        count = 0;
        int maxValues = Integer.MIN_VALUE;

        for (Map.Entry<Integer, List<Integer>> entry : fileData.entrySet()) {
            bw.write(entry.getKey().toString());

            if (count < entry.getValue().size() - 1) {
                bw.write(delimiter);
            }

            int values = entry.getValue().size();

            if (values > maxValues) {
                maxValues = values;
            }

            count++;
        }

        bw.write("\n");

        for (int i = 0; i < maxValues; i++) {
            for (Map.Entry<Integer, List<Integer>> entry : fileData.entrySet()) {
                try {
                    if (entry.getValue().get(i) != null) {
                        bw.write(entry.getValue().get(i).toString());

                        bw.write(delimiter);
                    }
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
            bw.write("\n");
        }
    }

    private void writeLines(BufferedWriter bw) throws IOException {
        int count;
        for (Map.Entry<Integer, List<Integer>> entry : fileData.entrySet()) {
            count = 0;
            bw.write(entry.getKey().toString() + delimiter);

            for (Integer value : entry.getValue()) {
                count++;
                bw.write(value.toString());
                if (count < entry.getValue().size()) {
                    bw.write(delimiter);
                }

            }

            bw.write("\n");
        }
    }
}
