package app;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class DelimitadorInvalidoException extends InputMismatchException {
    public DelimitadorInvalidoException() {
        super("O delimitador não pode ser uma string");
    }
}
