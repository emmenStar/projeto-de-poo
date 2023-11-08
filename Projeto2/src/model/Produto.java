package model;

import java.util.List;
import dao.ProdutoDAO;

public class Produto {
	
	private int codigo;
	private String nomeProduto;
	private int qtddProduto;
	private long dataEntrada;
	private double valorProduto;
	
	public Produto (int codigo, String nomeProduto, int qtddProduto, long dataEntrada, double valorProduto) {
		this.codigo = codigo;
		this.nomeProduto = nomeProduto;
		this.qtddProduto = qtddProduto;
		this.dataEntrada = dataEntrada;
		this.valorProduto = valorProduto;
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

	public long getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(long dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	
	@Override
    public String toString() {
        return "Produto{" + "Codigo= " + codigo + 
        		", Nome do produto=" + nomeProduto + 
        		", Quantidade de produto=" + qtddProduto + 
        		", Data de entrada=" + dataEntrada + 
        		", Valor do produto=" + valorProduto + '}';
    }
    
    public boolean cadastrar(){
        return ProdutoDAO.adicionarProduto(this);
    }
    
    public static List<Produto> listarProdutos(){
        return ProdutoDAO.listarProdutos();
    } 
}
