package view;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalView extends JFrame {
    JMenuBar menubar;
    JMenu mConfig;
    JMenuItem miCadastrar, miConsultar, miSair;

    ImageIcon imagemIcon = new ImageIcon("img/logo.png");
    JLabel imagemLabel = new JLabel(imagemIcon);

    public PrincipalView() {
        setTitle("BijuGerencia");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        Container cont = getContentPane();

        // Painel central
        JPanel painelCentral = new JPanel();
        cont.add(painelCentral);

        painelCentral.add(imagemLabel);

        Color corDeFundo = new Color(243, 215, 241);
        painelCentral.setBackground(corDeFundo);

        menubar = new JMenuBar();
        mConfig = new JMenu("Menu");
        JMenuItem miRegistro = new JMenuItem("Cadastrar Cliente");
        JMenuItem miControle = new JMenuItem("Cadastrar Produto");

        mConfig.add(miRegistro);
        mConfig.add(miControle);
        menubar.add(mConfig);

        // Defina a cor de fundo do JMenuBar usando RGB
        menubar.setBackground(new Color(246, 59, 116)); // Cor de fundo em RGB

        // Defina cores RGB personalizadas para os itens do menu
        Color corMenu = new Color(246, 59, 116); // Cor vermelha (RGB)
        miRegistro.setBackground(corMenu);
        miControle.setBackground(corMenu);

        // Crie uma borda personalizada para os itens do menu
        Border bordaMenuItem = BorderFactory.createLineBorder(Color.BLACK, 1); // Borda preta de 1 pixel

        // Defina a borda personalizada para os itens do menu
        miRegistro.setBorder(bordaMenuItem);
        miControle.setBorder(bordaMenuItem);

        setJMenuBar(menubar);

        miRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para lidar com a ação de miRegistro
                dispose();
                CadastrarCliente registroV = new CadastrarCliente();
                registroV.setVisible(true);
            }
        });

        miControle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para lidar com a ação de miControle
                dispose();
                CadastrarProduto controleE = new CadastrarProduto();
                controleE.setVisible(true);
            }
        });
    }
}