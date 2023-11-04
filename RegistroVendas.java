package SistemaBijux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class RegistroVendas extends JFrame {
    
	public RegistroVendas() {
        setTitle("Registro de Vendas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        LineBorder borda = new LineBorder(Color.BLACK, 2);
        getRootPane().setBorder(borda);
        
        JPanel panel = new JPanel(new GridBagLayout());
        add(panel);
        
        Color corDeFundo = new Color(243, 215, 241);
        panel.setBackground(corDeFundo);
        
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

        // Label e TextField para o Produto
        JLabel label2 = new JLabel("Descrição do produto:");
        c.gridx = 0;
        c.gridy = 2;
        panel.add(label2, c);

        JTextArea textArea = new JTextArea(5,30);
        c.gridx = 0;
        c.gridy = 3;
        
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Crie uma barra de rolagem para a JTextArea
        JScrollPane scrollPane = new JScrollPane(textArea);
      
        panel.add(textArea, c);
        panel.add(scrollPane);
        
        //Label para Data
        JLabel label3 = new JLabel("Data:");
        c.gridx = 0;
        c.gridy = 4;
        panel.add(label3, c);

        JTextField textField3 = new JTextField(20);
        c.gridx = 0;
        c.gridy = 5;
        panel.add(textField3, c);
        
        
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
        c.gridx = 90; // Defina a posição X desejada
        c.gridy = 8; // Defina a posição Y desejada
        
        Color corButton = new Color(60, 179, 113);
        customButton.setBackground(corButton);
        
        customButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        Dimension tamanhoBotao = new Dimension(80, 30); // Ajuste as dimensões conforme necessário
        customButton.setPreferredSize(tamanhoBotao);
        
        panel.add(customButton, c);
        
        
    }

    public static void main(String[] args) {
    	RegistroVendas bijulix = new RegistroVendas();
    	 bijulix.setVisible(true);
    }
}
