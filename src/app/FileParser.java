package app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class FileParser {
    public Map<Integer, List<Integer>> fileData = new HashMap<>();
    public List<String> fileLines = new ArrayList<>();
    public char delimiter = ';';

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

        System.out.println(this.fileLines);
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

    public void writeOutputFile(String format, String outputPath) throws EscritaNaoPermitidaException, ArquivoNaoEncontradoException{
        try {
            OutputStream os = new FileOutputStream(outputPath);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            int count = 0;

            if (format.equals("linhas")) {
                for (Map.Entry<Integer, List<Integer>> entry : fileData.entrySet()) {
//                    System.out.print(entry.getKey().toString() + delimiter);
                    bw.write(entry.getKey().toString() + delimiter);

                    count = 0;
                    for (Integer value : entry.getValue()) {
                        count ++;
                        bw.write(value.toString());
//                        System.out.print(value.toString());
                        if (count < entry.getValue().size()) {
                            bw.write(delimiter);
//                            System.out.print(delimiter);
                        }

                    }

                    bw.write("\n");
                    System.out.print("\n");
                }
            } else {
                int maxValues = Integer.MIN_VALUE;
                count = 0;
                for (Map.Entry<Integer, List<Integer>> entry : fileData.entrySet()) {


                    bw.write(entry.getKey().toString());
                    if (count <  entry.getValue().size() -1){
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
                    count = 0;

                    for (Map.Entry<Integer, List<Integer>> entry : fileData.entrySet()) {
                        if (entry.getValue().get(i) != null) {
                            bw.write(entry.getValue().get(i).toString());

                            if (count < entry.getValue().size() -1){
                                bw.write(delimiter);
                            }
                            count++;
                        }
                    }

                    bw.write("\n");
                }
            }

            bw.close();
        }  catch (FileNotFoundException e) {
            throw new ArquivoNaoEncontradoException("Arquivo não encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
