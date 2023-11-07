package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarProduto extends JFrame {

    Color corButton = new Color(60, 179, 113);
    Dimension tamanhoBotaoEnviar = new Dimension(80, 30);

    public CadastrarProduto() {
        // Configurar o título, tamanho e ação de fechamento da janela
        setTitle("Cadastrar produto");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurar a borda da janela
        LineBorder borda = new LineBorder(Color.BLACK, 2);
        getRootPane().setBorder(borda);

        // Criar um painel com um layout GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        add(panel);

        // Configurar a cor de fundo do painel
        Color corDeFundo = new Color(243, 215, 241);
        panel.setBackground(corDeFundo);

        // Configuração de GridBagConstraints para o layout GridBagLayout
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(3, 5, 5, 10);

        // Label e TextArea para a Descrição do Produto
        JLabel label = new JLabel("Produto:");
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label, c);

        JTextArea textArea = new JTextArea(5, 30);
        c.gridx = 0;
        c.gridy = 1;
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(textArea, c);
        panel.add(scrollPane, c);
        
     // Adicionar um botão "Voltar" ao lado do botão "Enviar"
        JButton btnVoltar = new JButton("Voltar");
        c.gridx = 1; // Coloca o botão "Voltar" ao lado do botão "Enviar"
        c.gridy = 0;
        btnVoltar.setPreferredSize(tamanhoBotaoEnviar);
        btnVoltar.setBackground(corButton);
        //btnVoltar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1);

        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para lidar com a ação de miControle
                dispose();
                PrincipalView principal = new PrincipalView();
                principal.setVisible(true);
            }
        });

        panel.add(btnVoltar, c);

        // Label e TextField para a Quantidade
        JLabel label2 = new JLabel("Quantidade:");
        c.gridx = 0;
        c.gridy = 2;
        panel.add(label2, c);

        JTextField textField = new JTextField(20);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(textField, c);

        // Label e TextField para a Data de entrada
        JLabel label3 = new JLabel("Data de entrada:");
        c.gridx = 0;
        c.gridy = 4;
        panel.add(label3, c);

        JTextField textField3 = new JTextField(20);
        c.gridx = 0;
        c.gridy = 5;
        panel.add(textField3, c);

        // Label e JFormattedTextField para o Valor (número real)
        JLabel label4 = new JLabel("Valor:");
        c.gridx = 0;
        c.gridy = 6;
        panel.add(label4, c);

        NumberFormat format = NumberFormat.getNumberInstance(); // Formato de número
        JFormattedTextField textField4 = new JFormattedTextField(format);
        textField4.setColumns(10); // Defina o número de colunas desejado
        c.gridx = 0;
        c.gridy = 7;
        panel.add(textField4, c);

        // Adicionar um botão "Enviar"
        JButton customButton = new JButton("Enviar");
        c.gridx = 0;
        c.gridy = 8;
        customButton.setPreferredSize(tamanhoBotaoEnviar);
        customButton.setBackground(corButton);
        //customButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1);

        // Configurar a ação do botão "Enviar" (adicionar ActionListener)
        customButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código a ser executado quando o botão "Enviar" for clicado
            }
        });

        panel.add(customButton, c);
    }

    public static void main(String[] args) {
        // Criar e exibir a janela
        CadastrarProduto bijulix = new CadastrarProduto();
        bijulix.setVisible(true);
    }
}