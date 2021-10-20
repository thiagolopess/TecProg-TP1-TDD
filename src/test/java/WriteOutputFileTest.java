import app.EscritaNaoPermitidaException;
import app.FileParser;
import org.junit.Test;

public class WriteOutputFileTest {

    @Test(expected = EscritaNaoPermitidaException.class)
    public void test() throws Exception {
        FileParser parser = new FileParser();

        parser.writeOutputFile();
    }
}
