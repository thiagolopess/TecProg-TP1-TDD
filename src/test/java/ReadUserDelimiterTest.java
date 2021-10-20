import app.DelimitadorInvalidoException;
import app.FileParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ReadUserDelimiterTest {
    @Test(expected = DelimitadorInvalidoException.class)
    public void test() throws DelimitadorInvalidoException {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("Minha string".getBytes());
        System.setIn(in);

        FileParser parser = new FileParser();

        parser.readOutputDelimiter();

        System.setIn(sysInBackup);
    }

    @Test
    public void test1() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(";".getBytes());
        System.setIn(in);

        FileParser parser = new FileParser();

        try {
            parser.readOutputDelimiter();
        } catch (DelimitadorInvalidoException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(parser.delimiter, ';');


        System.setIn(sysInBackup);
    }
}
