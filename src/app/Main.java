package app;

public class Main {
    public static void main(String[] args) {
        try {
            FileParser parser = new FileParser();

            parser.readFile("resources/analysisMemory.out");

            parser.parseDataFile();

            System.out.print("Digite o delimitador: ");
            parser.readOutputDelimiter();

            System.out.print("\nDigite o formato (linhas ou colunas): ");
            parser.readOutputFormat();

            System.out.print("\nDigite o caminho do arquivo de saída: ");
            parser.readOutputPath();

            parser.writeOutputFile();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
