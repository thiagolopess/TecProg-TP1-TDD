package app;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteOutputFile {

    BufferedWriter bw;
    Map<Integer, List<Integer>> fileData;
    char delimiter;

    public WriteOutputFile(BufferedWriter bw, Map<Integer, List<Integer>> fileData, char delimiter) {
        this.bw = bw;
        this.fileData = fileData;
        this.delimiter = delimiter;
    }

    public void writeLines() throws IOException {
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

    public void writeColumns() throws IOException {
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

}
