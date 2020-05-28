package service;

import java.util.ArrayList;


import dao.ProdutoDAO;
import model.Produto;

public class ProdutoService {
	
private ProdutoDAO produtoDao = new ProdutoDAO();
	
	
	public void cadastrar(Produto produto) {
		produtoDao.cadastrar(produto);
	}

	
	public Produto buscarProduto(int codigo) {
		
		return produtoDao.buscar(codigo);	
	}

	
	public void atualizarProduto(Produto produto) {
		produtoDao.alterar(produto);
	}

	
	public void deletarProduto(Produto produto) {
		produtoDao.excluir(produto);
	}
	
	
	public ArrayList<Produto> listarProdutos() {
		
		return produtoDao.listarProdutos();	
	}


	

}
