package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAO {
    public static boolean adicionarCliente(Cliente cliente){
        String sql = "INSERT INTO Cliente (nomeCliente, nomeProduto, data, valor) VALUES(?, ?, ?, ?)";
        try{
            Connection conexao = FabricaDeConexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getNomeProduto());
            stmt.setInt(3, cliente.getData());
            stmt.setDouble(4, cliente.getValor());
            stmt.execute();
            conexao.close();
            return true;
        }catch (SQLException ex){
            System.out.println(ex.toString());            
        }
        return false;
    }

    // Criar os métodos para atualizar, deletar, listar por atributos

    public static List<Cliente> listarClientes(){
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT codigo, nomeCliente, nomeProduto, data, valor "
                + "FROM Cliente";
        try{
            Connection conexao = FabricaDeConexao.getConexao();
            if (conexao == null){
                System.println("Sem conexao");
                System.exit(0);
            }
            Statement stmt = conexao.createStatement();
            System.out.println("Statement criada!");
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Query executada!");
            while (rs.next()){
                int codigo = rs.getInt("codigo");
                String nomeCliente = rs.getString("nomeCliente");
                String nomeProduto = rs.getString("nomeProduto");
                int data = rs.getInt("data");
                double valor = rs.getDouble("valor");
                Cliente cliente = new Cliente(codigo, nomeCliente, nomeProduto, data, valor);
                clientes.add(cliente);
                System.out.println(cliente.toString());
            }
            conexao.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return clientes;
    }
    
    public static List<Cliente> listarClientesPorNome(String nomeDePesquisa){
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT codigo, nomeCliente, nomeProduto, data, valor "
                + "FROM Cliente "
                + "WHERE nomeCliente like CONCAT(?,'%')";
        try{
            Connection conexao = FabricaDeConexao.getConexao();
            if (conexao == null){
                System.out.println("Sem conexao");
                System.exit(0);
            }
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeDePesquisa);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("codigo");
                String nomeCliente = rs.getString("nomeCliente");
                String nomeProduto = rs.getString("nomeProduto");
                int data = rs.getInt("data");
                double valor = rs.getDouble("valor");
                Cliente cliente = new Cliente(codigo, nomeCliente, nomeProduto, data, valor);
                clientes.add(cliente);
            }
            conexao.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return clientes;
    }       
    
}