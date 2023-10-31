package controller;

import entidades.Livro;
import exceptions.LivroJaExisteException;
import exceptions.LivroNaoExisteException;
import genero.GeneroDosLivros;
import mapa.SistemaControleDeBibliotecaMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDeLivroController extends JFrame {

    private JTextField tituloField;
    private JTextField autorField;
    private JTextField generoField; // Campo para o genero
    private JButton cadastrarButton;
    private JButton removerButton;

    public CadastroDeLivroController() {
        setTitle("Cadastro de Livro");
        setSize(300, 250); // Aumentei a altura para acomodar o campo de genero
        setResizable(false);
        createComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar apenas esta janela
        setVisible(true);
    }

    private void createComponents() {
        // Configurar o layout da janela
        setLayout(new GridLayout(4, 2)); // Aumentei o grid para acomodar o campo de genero

        // Adicionar rótulos e campos de entrada
        JLabel tituloLabel = new JLabel("           Título: ");
        tituloField = new JTextField();
        JLabel autorLabel = new JLabel("            Autor: ");
        autorField = new JTextField();
        JLabel generoLabel = new JLabel("           Gênero: "); // Rótulo para o genero
        generoField = new JTextField(); // Campo de entrada para o genero

        add(tituloLabel);
        add(tituloField);
        add(autorLabel);
        add(autorField);
        add(generoLabel); // Adicionar rótulo do genero
        add(generoField); // Adicionar campo do genero

        // Adicionar botões de cadastrar e remover
        cadastrarButton = new JButton("Cadastrar Livro");
        removerButton = new JButton("Remover Livro");

        add(cadastrarButton);
        add(removerButton);

        // Adicionar tratadores de eventos para os botões
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarLivro();
            }
        });

        removerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removerLivro();
            }
        });
    }

    private void cadastrarLivro() {
        // Obtenha os dados dos campos de entrada
        String titulo = tituloField.getText();
        String autor = autorField.getText();
        String genero = generoField.getText(); // Obter o genero

        // Adicione a lógica para cadastrar o livro na classe SistemaControleDeBibliotecaMap
        // Certifique-se de tratar exceções, como livro já existente
        try {
            SistemaControleDeBibliotecaMap sistemaControleDeBibliotecaMap = new SistemaControleDeBibliotecaMap();
            Livro novoLivro = new Livro(titulo, autor, GeneroDosLivros.Acao); // Defina o genero
            // Verifique se o livro já existe
            if (sistemaControleDeBibliotecaMap.existeLivroComTitulo(titulo)) {
                JOptionPane.showMessageDialog(this, "Livro já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                sistemaControleDeBibliotecaMap.cadastraLivro(novoLivro);
                JOptionPane.showMessageDialog(this, "Livro Cadastrado com sucesso!\n\n" + novoLivro, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (LivroJaExisteException e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removerLivro() {
        // Obtenha o título do livro a ser removido
        String titulo = tituloField.getText();

        // Adicione a lógica para remover o livro na classe SistemaControleDeBibliotecaMap
        // Certifique-se de tratar exceções, como livro não encontrado
        try {
            SistemaControleDeBibliotecaMap sistemaControleDeBibliotecaMap = new SistemaControleDeBibliotecaMap();
            if (sistemaControleDeBibliotecaMap.existeLivroComTitulo(titulo)) {
                Livro livro = sistemaControleDeBibliotecaMap.pesquisaLivroNaBiblioteca(titulo);
                sistemaControleDeBibliotecaMap.removeLivro(livro);
                JOptionPane.showMessageDialog(this, "Livro removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Livro não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (LivroNaoExisteException e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
