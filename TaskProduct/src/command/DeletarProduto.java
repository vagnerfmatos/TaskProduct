package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

public class DeletarProduto implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recebendo os par�metros:
		Produto produto = new Produto();

		int codigoProduto = Integer.parseInt(request.getParameter("codigo"));
		
		// Instanciando e popular um JavaBean de Produto:
		produto.setCodigo(codigoProduto);
		
		// Intanciando uma Service de Produto:
		ProdutoService produtoService = new ProdutoService();
		
		// Solicitando � service que Delete o produto no banco:
		produtoService.deletarProduto(produto);
		
		// Antes de despachar o usu�rio, adicionar um atributo � requisi��o:
		request.setAttribute("mensagem", "O produto foi excluido com sucesso!");
		
		// Despachar o usu�rio � parte de vis�o (apresenta��o - view):
		RequestDispatcher view = request.getRequestDispatcher("listaproduto.jsp");
		view.forward(request, response);

	}

}
