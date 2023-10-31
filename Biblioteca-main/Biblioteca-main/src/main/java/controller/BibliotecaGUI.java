package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BibliotecaGUI extends JFrame {

    public BibliotecaGUI() {
        setTitle("Biblioteca");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Defina o caminho absoluto para a imagem de fundo
        String imagePath = "imagens/livrosbiblioteca.jpg";


        // Crie um JLabel para exibir a imagem de fundo
        JLabel backgroundLabel = new JLabel(new ImageIcon(imagePath));

        // Defina o layout do JFrame como BorderLayout
        setLayout(new BorderLayout());

        // Adicione o JLabel de plano de fundo ao centro do JFrame
        add(backgroundLabel, BorderLayout.CENTER);

        createMenuBar();
        createButtonsPanel();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Opções: ");
        menuBar.add(menu);

        //Menu
        JMenuItem cadastro = new JMenuItem("Cadastro");
        JMenuItem pesquisa = new JMenuItem("Pesquisa");
        JMenuItem operacoes = new JMenuItem("Operações");
        JMenuItem salvar = new JMenuItem("Salvar");
        JMenuItem sair = new JMenuItem("Sair");

        menu.add(cadastro);
        menu.add(pesquisa);
        menu.add(operacoes);
        menu.add(salvar);
        menu.add(sair);

        // Adicionar tratadores de eventos para as opções do menu
        cadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroDeLivroController cadastroDoLivro = new CadastroDeLivroController();
            }
        });

        pesquisa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PesquisaDeLivroController pesquisaDoLivro = new PesquisaDeLivroController();
            }
        });

        operacoes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OperacoesControllerGUI operacoesController = new OperacoesControllerGUI();
            }
        });

        salvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Adicione a lógica para salvar os dados
            }
        });

        sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Fechar o programa
            }
        });
    }

    private void createButtonsPanel() {
        // JPanel no centro da janela
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());

        // Botões no centro
        JButton button1 = new JButton("1 - Cadastro");
        JButton button2 = new JButton("2 - Pesquisa");
        JButton button3 = new JButton("3 - Operações");
        JButton button4 = new JButton("4 - Salvar");
        JButton button5 = new JButton("5 - Sair");

        // Adicione os botões ao JPanel
        centerPanel.add(button1);
        centerPanel.add(button2);
        centerPanel.add(button3);
        centerPanel.add(button4);
        centerPanel.add(button5);

        // Adicione o JPanel ao centro da janela
        add(centerPanel, BorderLayout.NORTH);

        // Adicione tratadores de eventos para os botões no centro
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroDeLivroController cadastroDoLivro = new CadastroDeLivroController();
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PesquisaDeLivroController pesquisaDoLivro = new PesquisaDeLivroController();
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OperacoesControllerGUI operacoesController = new OperacoesControllerGUI();
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Adicione a lógica para a opção 4
            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BibliotecaGUI();
            }
        });
    }
}

