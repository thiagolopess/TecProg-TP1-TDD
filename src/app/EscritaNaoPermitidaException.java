package app;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.InputMismatchException;

public class EscritaNaoPermitidaException extends AccessDeniedException {
    public EscritaNaoPermitidaException() {
        super("Não é permitido escrever no arquivo.");
    }
}
