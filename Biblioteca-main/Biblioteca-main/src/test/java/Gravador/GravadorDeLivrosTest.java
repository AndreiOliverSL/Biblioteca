package Gravador;


import entidades.Livro;
import genero.GeneroDosLivros;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeLivrosTest {

    @Test
    public void testSalvarRecuperarLivro() throws IOException {
        // Criando um mapa de livros para teste
        Map<String, Livro> livrosMap = new HashMap<>();
        livrosMap.put("1", new Livro("Dom Casmurro", "Machado de Assis", GeneroDosLivros.Acao));
        livrosMap.put("2", new Livro("O Senhor dos Anéis", "J.R.R. Tolkien",GeneroDosLivros.Acao));
        livrosMap.put("3", new Livro("1984", "George Orwell",GeneroDosLivros.Acao));

        GravadorDeLivros.GravadorDeDadosLivros gravador = new GravadorDeLivros.GravadorDeDadosLivros();

        // Salvando os livros no arquivo
        gravador.salvarLivro(livrosMap);

        // Recuperando os livros do arquivo
        Map<String, Livro> livrosRecuperados = gravador.recuperarLivro();

        // Verificando se os livros recuperados são iguais aos livros originais
        assertEquals(livrosMap, livrosRecuperados);
    }
}

