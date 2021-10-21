package app;

import java.io.IOException;
import java.util.InputMismatchException;

public class EscritaNaoPermitidaException extends IOException {
    public EscritaNaoPermitidaException() {
        super("Não é permitido escrever no arquivo.");
    }
}
