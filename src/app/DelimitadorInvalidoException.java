package app;

import java.io.FileNotFoundException;

public class DelimitadorInvalidoException extends FileNotFoundException {
    public DelimitadorInvalidoException() {
        super("O delimitador não pode ser uma string");
    }
}
