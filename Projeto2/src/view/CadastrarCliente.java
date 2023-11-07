package view;

import exemplobancodedados.Principal;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastrarCliente extends JFrame {

    public CadastrarCliente() {
        // Configurar o título, tamanho e ação de fechamento da janela
        setTitle("Cadastrar cliente");
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

        // Label e TextField para o Cliente
        JLabel label = new JLabel("Nome do cliente:");
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label, c);

        JTextField textField = new JTextField(20);
        Dimension smallerSize = new Dimension(10, 20); // Defina as dimensões desejadas (largura x altura)
        textField.setPreferredSize(smallerSize);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(textField, c);;

        // Label para Data
        JLabel label2 = new JLabel("Produto comprado:");
        c.gridx = 0;
        c.gridy = 2;
        panel.add(label2, c);

        JTextField textField2 = new JTextField(20);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(textField2, c);
        
        JLabel label3 = new JLabel("Data de entrada:");
        c.gridx = 0;
        c.gridy = 4;
        panel.add(label3, c);

        JTextField textField3 = new JTextField(20);
        c.gridx = 0;
        c.gridy = 5;
        panel.add(textField3, c);

        // Label e TextField para o Valor
        JLabel label4 = new JLabel("Valor do produto:");
        c.gridx = 0;
        c.gridy = 6;
        panel.add(label4, c);

        JTextField textField4 = new JTextField(20);
        c.gridx = 0;
        c.gridy = 7;
        panel.add(textField4, c);

        // Adicionar um botão com posição personalizada
        JButton customButton = new JButton("Enviar");
        c.gridx = 0; // Defina a posição X desejada
        c.gridy = 10; // Defina a posição Y desejada

        Color corButton = new Color(60, 179, 113);
        customButton.setBackground(corButton);
        customButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // Ajustar as dimensões do botão
        Dimension tamanhoBotao = new Dimension(100, 30);
        customButton.setPreferredSize(tamanhoBotao);

        // Configurar a ação do botão (adicionar ActionListener)
        customButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código a ser executado quando o botão for clicado
            }
        });

        panel.add(customButton, c);
        
     // Adicionar um botão "Voltar" ao lado do botão "Enviar"
        JButton btnVoltar = new JButton("Voltar");
        c.gridx = 1; // Coloca o botão "Voltar" ao lado do botão "Enviar"
        c.gridy = 0;
        //btnVoltar.setPreferredSize(tamanhoBotaoEnviar);
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
        
    }
}