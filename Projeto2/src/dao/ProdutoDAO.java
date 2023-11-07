package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO {
    public static boolean adicionarProduto(Produto produto){
        String sql = "INSERT INTO Produto (nomeProduto, qtddProduto, dataEntrada, valor) VALUES (?, ?, ?, ?)";
        try{
            Connection conexao = FabricaDeConexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setInt(2, produto.getQtddProduto());
            stmt.setInt(3, produto.getDataEntrada());
            stmt.setDouble(4, produto.getValor());
            stmt.execute();
            conexao.close();
            return true;
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return false;
    }

    // Crie métodos para atualizar, deletar, listar por atributos

    public static List<Produto> listarProdutos(){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT codigo, nomeProduto, qtddProduto, dataEntrada, valor FROM Produto";
        try{
            Connection conexao = FabricaDeConexao.getConexao();
            if (conexao == null){
                System.out.println("Sem conexao");
                System.exit(0);
            }
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                int codigo = rs.getInt("codigo");
                String nomeProduto = rs.getString("nomeProduto");
                int qtddProduto = rs.getInt("qtddProduto");
                int dataEntrada = rs.getInt("dataEntrada");
                double valor = rs.getDouble("valor");
                Produto produto = new Produto(codigo, nomeProduto, qtddProduto, dataEntrada, valor);
                produtos.add(produto);
            }
            conexao.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return produtos;
    }
    
    public static List<Produto> listarProdutosPorNome(String nomeDePesquisa){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT codigo, nomeProduto, qtddProduto, dataEntrada, valor "
                + "FROM Produto "
                + "WHERE nomeProduto LIKE CONCAT(?, '%')";
        try{
            Connection conexao = FabricaDeConexao.getConexao();
            if (conexao == null){
                System.println("Sem conexao");
                System.exit(0);
            }
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeDePesquisa);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("codigo");
                String nomeProduto = rs.getString("nomeProduto");
                int qtddProduto = rs.getInt("qtddProduto");
                int dataEntrada = rs.getInt("dataEntrada");
                double valor = rs.getDouble("valor");
                Produto produto = new Produto(codigo, nomeProduto, qtddProduto, dataEntrada, valor);
                produtos.add(produto);
            }
            conexao.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return produtos;
    }
}