package control;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteController {
    
    public boolean adicionarCliente(int codigo, String nomeCliente, String nomeProduto, int data, double valor){       
        Cliente cliente = new Cliente(codigo, nomeCliente, nomeProduto, data, valor);
        return cliente.cadastrar();
    }
    
    public List<String[]> listarClientes(){
        List<String[]> dadosClientes = new ArrayList<>();
        List<Cliente> clientes = Cliente.listarCliente();        
        for (Cliente cliente : clientes){
            String[] dadosCliente = new String[4];
            dadosCliente[0] = String.valueOf(cliente.getCodigo());
            dadosCliente[1] = cliente.getNomeCliente();
            dadosCliente[2] = cliente.getNomeProduto();
            dadosCliente[3] = String.valueOf(cliente.getData());
            dadosCliente[4] = String.valueOf(cliente.getValor());
            dadosClientes.add(dadosCliente);
        }        
        return dadosClientes;
    }
    
    public List<String[]> listarClientesPorNome(String nomeCliente){
        List<String[]> dadosClientes = new ArrayList<>();
        List<Cliente> clientes = Cliente.listarClientesPorNome(nomeCliente);        
        for (Cliente cliente : clientes){
            String[] dadosCliente = new String[4];
            dadosCliente[0] = String.valueOf(cliente.getCodigo());
            dadosCliente[1] = cliente.getNomeCliente();
            dadosCliente[2] = cliente.getNomeProduto();
            dadosCliente[3] = String.valueOf(cliente.getData());
            dadosCliente[4] = String.valueOf(cliente.getValor());
            dadosClientes.add(dadosCliente);
        }        
        return dadosClientes;
    }    
}