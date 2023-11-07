package model;

import java.util.List;
import dao.ProdutoDAO;

public class Produto {
	
	private int codigo;
	private String nomeProduto;
	private int qtddProduto;
	private int dataEntrada;
	private double valor;
	
	public Produto (int codigo, String nomeProduto, int qtddProduto, int dataEntrada, double valor) {
		this.codigo = codigo;
		this.nomeProduto = nomeProduto;
		this.qtddProduto = qtddProduto;
		this.dataEntrada = dataEntrada;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getQtddProduto() {
		return qtddProduto;
	}

	public void setQtddProduto(int qtddProduto) {
		this.qtddProduto = qtddProduto;
	}

	public int getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(int dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@Override
    public String toString() {
        return "Produto{" + "Codigo= " + codigo + ", Nome do produto=" + nomeProduto + ", Quantidade de produto=" + qtddProduto + ", Data de entrada=" + dataEntrada + ", Valor do produto=" + valor + '}';
    }
    
    public boolean cadastrar(){
        return ProdutoDAO.adicionarProduto(this);
    }
    
    public static List<Produto> listarProdutos(){
        return ProdutoDAO.listarProdutos();
    }

    public static List<Produto> listarProdutosPorNome(String nome){
        return ProdutoDAO.listarProdutosPorNome(nome);
    }  
}