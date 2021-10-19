package App;

import Exceptions.ArquivoNaoEncontradoException;

public class FileParser {
    public void readFile(String filename) throws ArquivoNaoEncontradoException {
        throw new ArquivoNaoEncontradoException("Arquivo não encontrado.");
    }
}
