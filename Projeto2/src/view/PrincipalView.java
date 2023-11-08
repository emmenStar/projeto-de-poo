package view;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalView extends JFrame {
    JMenuBar menubar;
    JMenu mConfig, mConfig1;
    JMenuItem miCadastrar, miConsultar;   
    private JLabel lblImageBackground;

    public PrincipalView() {
        setTitle("BijuGerencia");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
       
        Container c = getContentPane();

        // Painel central
        JPanel painelCentral = new JPanel();
        c.add(painelCentral);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("logo.png"));	
        lblImageBackground = new JLabel();
        lblImageBackground.setIcon(icon); //coloca a imagem na label
        painelCentral.add(lblImageBackground);
        getContentPane().add(painelCentral, BorderLayout.CENTER);
        
        menubar = new JMenuBar();
        mConfig = new JMenu("Cadastrar");
        JMenuItem micadastrarCliente = new JMenuItem("Cliente");
        JMenuItem micadastrarProduto = new JMenuItem("Produto");

        mConfig.add(micadastrarCliente);
        mConfig.add(micadastrarProduto);
        menubar.add(mConfig);
        
        mConfig1 = new JMenu("Consultar");
        JMenuItem miconsultarClientes = new JMenuItem("Clientes");
        JMenuItem miconsultarProdutos = new JMenuItem("Produtos");

        mConfig1.add(miconsultarClientes);
        mConfig1.add(miconsultarProdutos);
        menubar.add(mConfig1);

        // Defina a cor de fundo do JMenuBar usando RGB
        menubar.setBackground(new Color(80, 140, 172)); // Cor de fundo em RGB

        // Defina cores RGB personalizadas para os itens do menu
        Color corMenu = new Color(243, 215, 241); // Cor vermelha (RGB)
        micadastrarCliente.setBackground(corMenu);
        micadastrarProduto.setBackground(corMenu);
        miconsultarClientes.setBackground(corMenu);
        miconsultarProdutos.setBackground(corMenu);
        
        setJMenuBar(menubar);

        micadastrarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para lidar com a ação de miRegistro
                dispose();
                CadastrarCliente cadastrarCliente = new CadastrarCliente();
                cadastrarCliente.setVisible(true);
            }
        });

        micadastrarProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para lidar com a ação de miControle
                dispose();
                CadastrarProduto cadastrarProduto = new CadastrarProduto();
                cadastrarProduto.setVisible(true);
            }
        });
        
        miconsultarClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para lidar com a ação de miRegistro
                dispose();
                ConsultarClientes consultarClientes = new ConsultarClientes();
                consultarClientes.setVisible(true);
            }
        });

        miconsultarProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para lidar com a ação de miControle
                dispose();
                ConsultarProdutos consultarProdutos = new ConsultarProdutos();
                //consultarProdutos.setVisible(true);
            }
        });
    }
    
    public static void main(String []args) {
    	PrincipalView principal = new PrincipalView();
    	principal.setVisible(true);
    }
}
