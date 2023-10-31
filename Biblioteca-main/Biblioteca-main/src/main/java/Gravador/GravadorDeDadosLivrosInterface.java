package Gravador;

import entidades.Livro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public interface GravadorDeDadosLivrosInterface {
    void salvarLivro(Map<String, Livro> livros) throws IOException;
    HashMap<String, Livro> recuperarLivro() throws IOException;
}
