package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoDAO {
    public static boolean adicionarProduto(Produto produto) {
        String sql = "INSERT INTO Produto (nomeProduto, qtddProduto, dataEntrada, valorProduto) VALUES (?, ?, ?, ?)";
        try (Connection conexao = FabricaDeConexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNomeProduto());
            stmt.setInt(2, produto.getQtddProduto());
            stmt.setLong(3, produto.getDataEntrada()); // Assume que dataEntrada é uma java.util.Date
            stmt.setDouble(4, produto.getValorProduto());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar produto: " + ex.toString());
            return false;
        }
    }

    // Implemente os métodos para atualizar, deletar, listar por atributos aqui

    public static List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT codigo, nomeProduto, qtddProduto, dataEntrada, valor FROM Produto";
        try (Connection conexao = FabricaDeConexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nomeProduto = rs.getString("nomeProduto");
                int qtddProduto = rs.getInt("qtddProduto");
                long dataEntrada = rs.getLong("dataEntrada");
                double valorProduto = rs.getDouble("valorProduto");
                Produto produto = new Produto(codigo, nomeProduto, qtddProduto, dataEntrada, valorProduto);
                produtos.add(produto);
                System.out.println(produto.toString());
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar produtos: " + ex.toString());
        }
        return produtos;
    }
}
