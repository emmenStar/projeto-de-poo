package model;

import java.util.List;
import dao.ClienteDAO;

public class Cliente {
	
	private int codigo;
	private String nomeCliente;
	private String nomeProduto;
	private long dataCompra;
	private double valorProduto;
	
	public Cliente (int codigo, String nomeCliente, String nomeProduto, long dataCompra, double valorProduto) {
		this.codigo = codigo;
		this.nomeCliente = nomeCliente;
		this.nomeProduto = nomeProduto;
		this.dataCompra = dataCompra;
		this.valorProduto = valorProduto;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public long getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(long dataCompra) {
		this.dataCompra = dataCompra;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	
	@Override
    public String toString() {
        return "Cliente{" + "Codigo= " + codigo + 
        		", Nome do cliente=" + nomeCliente +
        		",Produto=" + nomeProduto + 
        		", Data de compra=" + dataCompra + 
        		", Valor do produto=" + valorProduto + '}';
    }
    
    public boolean cadastrar(){
        return ClienteDAO.adicionarCliente(this);
    }

	public static List<Cliente> listarClientes() {
		return ClienteDAO.listarClientes();
	}
}
