package app;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.util.*;



public class FileParser {
    public char delimiter = ';';
    public String outputPath;
    public String outputFormat;

    Persistencia persistencia = new Persistencia();

    public void readFile(String filename) throws ArquivoNaoEncontradoException, FalhaLeituraArquivoException {
        persistencia.readFile(filename);
    }

    public void parseDataFile() {
        persistencia.parseDataFile();
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
        persistencia.writeOutputFile(outputFormat,outputPath, delimiter);

    }

    public Map<Integer, List<Integer>> getPersistenceFileData(){
        return persistencia.getFileData();
    }

    public List<String> getPersistenceFileLines(){
        return persistencia.getFileLines();
    }
}
