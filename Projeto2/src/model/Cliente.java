package model;

public class Cliente {
	
	private String nomeCliente;
	private String nomeProduto;
	private int data;
	private double valor;
	
	public Cliente (String nomeCliente, String nomeProduto, int data, double valor) {
		this.nomeCliente = nomeCliente;
		this.nomeProduto = nomeProduto;
		this.data = data;
		this.valor = valor;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getDescricaoProduto() {
		return nomeProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.nomeProduto = descricaoProduto;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}