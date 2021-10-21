package app;


public class Main {

    public static void main(String[] args) {

        try {

            FileParser parser = new FileParser();

            parser.readFile("resources/analysisMemory.out");

            parser.parseDataFile();

            parser.writeOutputFile("linhas", "resources/analysisMemoryTab.out");


        } catch(Exception e) {
            e.printStackTrace();
        }

        // write your code here
    }
}
