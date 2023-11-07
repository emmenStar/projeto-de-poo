package SistemaBijux;

package SistemaBijux;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroVendas extends JFrame {

    public RegistroVendas() {
        // Configurar o título, tamanho e ação de fechamento da janela
        setTitle("Registro de Vendas");
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
        JLabel label = new JLabel("Cliente:");
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label, c);

        JTextField textField = new JTextField(20);
        Dimension smallerSize = new Dimension(10, 20); // Defina as dimensões desejadas (largura x altura)
        textField.setPreferredSize(smallerSize);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(textField, c);

        // Label e TextArea para a Descrição do produto
        JLabel label2 = new JLabel("Descrição do produto:");
        c.gridx = 0;
        c.gridy = 2;
        panel.add(label2, c);

        JTextArea textArea = new JTextArea(5, 30);
        c.gridx = 0;
        c.gridy = 3;
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Crie uma barra de rolagem para a JTextArea
        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(textArea, c);
        panel.add(scrollPane, c);

        // Label para Data
        JLabel label3 = new JLabel("Data:");
        c.gridx = 0;
        c.gridy = 4;
        panel.add(label3, c);

        JTextField textField3 = new JTextField(20);
        c.gridx = 0;
        c.gridy = 5;
        panel.add(textField3, c);

        // Obtenha a data atual e formate-a
        Date data1 = new Date();
        String data = new SimpleDateFormat("dd/MM/yy").format(data1);

        // Label e TextField para o Valor
        JLabel label4 = new JLabel("Valor:");
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
        c.gridy = 8; // Defina a posição Y desejada

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
    }

    public static void main(String[] args) {
        // Criar e exibir a janela
            RegistroVendas bijulix = new RegistroVendas();
            bijulix.setVisible(true);
    }
}
