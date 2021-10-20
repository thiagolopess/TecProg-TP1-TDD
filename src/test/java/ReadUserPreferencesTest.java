import app.ArquivoNaoEncontradoException;
import app.DelimitadorInvalidoException;
import app.FalhaLeituraArquivoException;
import app.FileParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ReadUserPreferencesTest {
    @Test(expected = DelimitadorInvalidoException.class)
    public void test() throws DelimitadorInvalidoException {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("Minha string".getBytes());
        System.setIn(in);

        FileParser parser = new FileParser();

        parser.readOutputDelimiter();

        System.setIn(sysInBackup);
    }
}
