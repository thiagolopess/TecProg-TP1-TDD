package app;

import java.io.FileNotFoundException;

public class ArquivoNaoEncontradoException extends FileNotFoundException {
    public ArquivoNaoEncontradoException(String errorMessage) {
        super(errorMessage);
    }
}
