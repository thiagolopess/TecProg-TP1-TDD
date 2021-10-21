import app.FileParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ReadOutputFormatTest {
    @Test
    public void test() {
        InputStream sysInBackup = System.in;
        String input = "linhas";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        FileParser parser = new FileParser();

        parser.readOutputFormat();

        Assert.assertEquals(parser.outputFormat, input);

        System.setIn(sysInBackup);
    }

    @Test
    public void test1() {
        InputStream sysInBackup = System.in;
        String input = "colunas";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        FileParser parser = new FileParser();

        parser.readOutputFormat();

        Assert.assertEquals(parser.outputFormat, "colunas");

        System.setIn(sysInBackup);
    }
}

