package control;

import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoController {
    
    public boolean adicionarProduto(int codigo, String nomeProduto, int qtddProduto, long dataEntrada, double valor){       
        Produto produto = new Produto(codigo, nomeProduto, qtddProduto, dataEntrada, valor);
        return produto.cadastrar();
    }
    
    public List<String[]> listarProdutos(){
        List<String[]> dadosProdutos = new ArrayList<>();
        List<Produto> produtos = Produto.listarProdutos();        
        for (Produto produto : produtos){
            String[] dadosProduto = new String[5];
            dadosProduto[0] = String.valueOf(produto.getCodigo());
            dadosProduto[1] = produto.getNomeProduto();
            dadosProduto[2] = String.valueOf(produto.getQtddProduto());
            dadosProduto[3] = String.valueOf(produto.getDataEntrada());
            dadosProduto[4] = String.valueOf(produto.getValorProduto());
            dadosProdutos.add(dadosProduto);
        }        
        return dadosProdutos;
    }  
}
