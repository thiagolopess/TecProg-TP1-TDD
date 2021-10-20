import app.DelimitadorInvalidoException;
import app.FileParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ReadOutputPathTest {
    @Test
    public void test() {
        InputStream sysInBackup = System.in;
        String input = "src/test/resources/arquivo.out";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        FileParser parser = new FileParser();

        parser.readOutputDelimiter();

        Assert.assertEquals(parser.outputPath, input);

        System.setIn(sysInBackup);
    }
}
