package app;


public class EscritaNaoPermitidaException extends Exception {
    public EscritaNaoPermitidaException(String errorMessage) {
        super(errorMessage);
    }
}
