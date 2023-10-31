package Gravador;

import entidades.Livro;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeLivros {

    public static class GravadorDeDadosLivros implements GravadorDeDadosLivrosInterface {
        public static final String ARQUIVO_LIVROS = "C:\\Users\\Raphael\\Documents\\ProjetoAyla2023.1.POO\\livros.dat";

        public HashMap<String, Livro> recuperarLivro() throws IOException {
            ObjectInputStream in = null;
            try {
                in = new ObjectInputStream(new FileInputStream(ARQUIVO_LIVROS));
                return (HashMap<String, Livro>) in.readObject();
            } catch (Exception e) {
                System.out.println("Não foi possível recuperar os livros");
                throw new IOException("Não foi possível recuperar os dados do arquivo " + ARQUIVO_LIVROS, e);
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        }

        public void salvarLivro(Map<String, Livro> livros) throws IOException {
            ObjectOutputStream out = null;
            try {
                out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_LIVROS));
                out.writeObject(livros);
            } catch (Exception e) {
                e.printStackTrace();
                throw new IOException("Erro ao salvar os livros no arquivo " + ARQUIVO_LIVROS, e);
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        }
    }
}
