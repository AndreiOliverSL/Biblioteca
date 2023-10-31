package entidades;

import genero.GeneroDosLivros;

import java.io.Serializable;
import java.util.Objects;

public class Livro implements Serializable {

    private String titulo;
    private String autor;
    private GeneroDosLivros genero;

    public Livro(){
    }

    public Livro(String titulo, String autor, GeneroDosLivros genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public GeneroDosLivros getGenero() {
        return genero;
    }

    public void setGenero(GeneroDosLivros genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "---Livro---" +
                "\nTítulo: " + titulo +
                "\nAutor: " + autor +
                "\nGênero:" + genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return titulo.equals(livro.titulo) && autor.equals(livro.autor) && genero == livro.genero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, genero);
    }
}