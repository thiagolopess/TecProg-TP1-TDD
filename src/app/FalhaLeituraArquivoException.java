package app;

import java.io.IOException;

public class FalhaLeituraArquivoException extends IOException {
    public FalhaLeituraArquivoException(String errorMessage) {
        super(errorMessage);
    }
}
