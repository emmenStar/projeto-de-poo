package control;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteController {
    
    public boolean adicionarCliente(int codigo, String nomeCliente, String nomeProduto, long dataCompra, double valorProduto){       
        Cliente cliente = new Cliente(codigo, nomeCliente, nomeProduto, dataCompra, valorProduto);
        return cliente.cadastrar();
    }
    
    public List<String[]> listarClientes(){
        List<String[]> dadosClientes = new ArrayList<>();
        List<Cliente> clientes = Cliente.listarClientes();        
        for (Cliente cliente : clientes){
            String[] dadosCliente = new String[4];
            dadosCliente[0] = String.valueOf(cliente.getCodigo());
            dadosCliente[1] = cliente.getNomeCliente();
            dadosCliente[2] = cliente.getNomeProduto();
            dadosCliente[3] = String.valueOf(cliente.getDataCompra());
            dadosCliente[4] = String.valueOf(cliente.getValorProduto());
            dadosClientes.add(dadosCliente);
        }        
        return dadosClientes;
    } 
}
