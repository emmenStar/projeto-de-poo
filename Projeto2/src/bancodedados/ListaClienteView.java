package exemplobancodedados;

import control.ClienteController;
import model.ListaClienteTableModel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class ListaClienteView extends JFrame implements ActionListener, KeyListener{
    
    private JLabel lblnomeCliente;
    private JTextField txtnomeCliente;
    private JButton btnPesquisar;    
    private JTable tblClientes;
    private JPanel painelSuperior;
    
    public ListaClienteView(){
        setTitle("Consulta de Clientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializaComponentes();
        pack();
    }
    
    private void inicializaComponentes(){
        painelSuperior = new JPanel();
        painelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
        
        lblnomeCliente = new JLabel("Nome: ");
        txtnomeCliente = new JTextField(30);
        txtnomeCliente.setToolTipText("Digite o nome do cliente que deseja pesquisar.");
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(this);
        painelSuperior.add(lblnomeCliente);
        painelSuperior.add(txtnomeCliente);
        painelSuperior.add(btnPesquisar);
        
        getContentPane().add(painelSuperior, BorderLayout.NORTH);

        tblClientes = new JTable(new ListaClienteTableModel());
        JScrollPane scrollTable = new JScrollPane(tblClientes);
                
        getContentPane().add(scrollTable, BorderLayout.CENTER);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeCliente = txtnomeCliente.getText();
        List<String[]> dadosClientes = new ClienteController().listarClientes(nomeCliente);
        tblClientes.setModel(new ListaClienteTableModel(dadosClientes));
    }    
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
