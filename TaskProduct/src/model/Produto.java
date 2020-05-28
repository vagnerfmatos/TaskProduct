package model;

public class Produto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nomeProduto;
	private String descricaoProduto;
	private double valorProduto;
	private int estoqueProduto;
	
	public Produto() {}
	
	public Produto(int codigo, String nomeProduto, String descricaoProduto, double valorProduto, int estoqueProduto) {
		super();
		this.codigo = codigo;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.valorProduto = valorProduto;
		this.estoqueProduto = estoqueProduto;
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

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public int getEstoqueProduto() {
		return estoqueProduto;
	}

	public void setEstoqueProduto(int estoqueProduto) {
		this.estoqueProduto = estoqueProduto;
	}
	
	
	
}
