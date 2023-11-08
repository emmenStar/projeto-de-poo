package view;

import javax.swing.*;

import control.ClienteController;
import control.ProdutoController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarCliente extends JFrame implements ActionListener {

    private JLabel lblnomeCliente, lblnomeProduto, lbldataCompra, lblvalorProduto;
    private JTextField txtnomeCliente, txtnomeProduto, txtdataCompra, txtvalorProduto;
    private JPanel painelCenter, painelBotao;
    private JButton btnVoltar, btnCadastrar, btnCancelar;

    private BorderLayout layoutPai;
    private FlowLayout layoutBotao;

    public CadastrarCliente() {

        setTitle("Cadastrar Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container c = getContentPane();
        
        layoutPai = new BorderLayout();
        c.setLayout(layoutPai);

        painelCenter = new JPanel();
        painelCenter.setLayout(null);
        
        Color corDeFundo = new Color(243, 215, 241);
        painelCenter.setBackground(corDeFundo);

        painelBotao = new JPanel();
        layoutBotao = new FlowLayout(FlowLayout.CENTER, 25, 15);
        painelBotao.setLayout(layoutBotao);

        c.add(painelCenter, BorderLayout.CENTER);
        c.add(painelBotao, BorderLayout.SOUTH);

        lblnomeCliente = new JLabel("Cliente:");
        lblnomeCliente.setBounds(15, 15, 100, 30);
        txtnomeCliente = new JTextField();
        txtnomeCliente.setBounds(115, 15, 250, 30);

        lblnomeProduto = new JLabel("Produto:");
        lblnomeProduto.setBounds(15, 60, 150, 30);
        txtnomeProduto = new JTextField();
        txtnomeProduto.setBounds(115, 60, 250, 30);

        lbldataCompra = new JLabel("Data de Compra:");
        lbldataCompra.setBounds(15, 105, 100, 30);
        txtdataCompra = new JTextField();
        txtdataCompra.setBounds(115, 105, 250, 30);

        lblvalorProduto = new JLabel("Valor:");
        lblvalorProduto.setBounds(15, 150, 120, 30);
        txtvalorProduto = new JTextField();
        txtvalorProduto.setBounds(115, 150, 250, 30);
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(this);
        
        Color corbtnVoltar = new Color(243, 215, 241);
        btnVoltar.setBackground(corbtnVoltar);
        
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(this);
        
        Color corbtnCadastrar = new Color(60, 179, 113);
        btnCadastrar.setBackground(corbtnCadastrar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        
        Color corbtnCancelar = new Color(165, 42, 42);
        btnCancelar.setBackground(corbtnCancelar);
        
        painelBotao.add(btnVoltar);
        painelBotao.add(btnCadastrar);
        painelBotao.add(btnCancelar);
        painelBotao.setBackground(new Color(224,255,255));

        painelCenter.add(lblnomeCliente);
        painelCenter.add(txtnomeCliente);
        painelCenter.add(lblnomeProduto);
        painelCenter.add(txtnomeProduto);
        painelCenter.add(lbldataCompra);
        painelCenter.add(txtdataCompra);
        painelCenter.add(lblvalorProduto);
        painelCenter.add(txtvalorProduto);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCadastrar) {
            cadastrarCliente();
            listarCliente();
        } else if (e.getSource() == btnCancelar) {
            dispose();
        } /*else if (e.getSource() == btnVoltar) {
            dispose(); // Fecha a janela atual
            btnVoltar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Código para lidar com a ação de miControle
                    dispose();
                    PrincipalView principal = new PrincipalView();
                    principal.setVisible(true);// Abra a nova tela ou execute a ação desejada para voltar
                });
        }*/
    }

    public void cadastrarCliente() {
        String nomeCliente = txtnomeCliente.getText();
        String nomeProduto = txtnomeProduto.getText();
        long dataCompra = Long.parseLong(txtdataCompra.getText());
        double valorProduto = Double.parseDouble(txtvalorProduto.getText());
        ClienteController clienteController = new ClienteController();
        boolean resultado = clienteController.adicionarCliente(nomeCliente, nomeProduto, dataCompra, valorProduto);
    }

    private void listarCliente() {
        ClienteController clienteController = new ClienteController();
        java.util.List<String[]> clientesDados = clienteController.listarClientes();
        for (String[] dados : clientesDados) {
            System.out.println(dados[0] + "\t" + dados[1] + "\t" + dados[2] + "\t" + dados[3]);
        }
    }

    public static void main(String[] args) {
        CadastrarCliente cadastrarCliente = new CadastrarCliente();
        cadastrarCliente.setVisible(true);
    }
}
