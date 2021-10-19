package App;

import Exceptions.ArquivoNaoEncontradoException;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileParser {
    public Map<Integer, List<Integer>> fileDataMap = new HashMap<>();

    public void readFile(String filename) throws ArquivoNaoEncontradoException {
        throw new ArquivoNaoEncontradoException("Arquivo não encontrado.");
    }
}
