package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAO {
    public static boolean adicionarCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nomeCliente, nomeProduto, dataCompra, valorProduto) VALUES (?, ?, ?, ?)";
        try (Connection conexao = FabricaDeConexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getNomeProduto());
            stmt.setLong(3, cliente.getDataCompra());
            stmt.setDouble(4, cliente.getValorProduto());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    // Implemente os métodos para atualizar, deletar, listar por atributos aqui

    public static List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT codigo, nomeCliente, nomeProduto, dataCompra, valorProduto FROM Cliente";
        try (Connection conexao = FabricaDeConexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nomeCliente = rs.getString("nomeCliente");
                String nomeProduto = rs.getString("nomeProduto");
                long dataCompra = rs.getLong("dataCompra");
                double valorProduto = rs.getDouble("valorProduto");
                Cliente cliente = new Cliente(codigo, nomeCliente, nomeProduto, dataCompra, valorProduto);
                clientes.add(cliente);
                System.out.println(cliente.toString());
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return clientes;
    }
}
