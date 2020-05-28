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
		// Recebendo os parâmetros:
		Produto produto = new Produto();

		int codigoProduto = Integer.parseInt(request.getParameter("codigo"));
		
		// Instanciando e popular um JavaBean de Produto:
		produto.setCodigo(codigoProduto);
		
		// Intanciando uma Service de Produto:
		ProdutoService produtoService = new ProdutoService();
		
		// Solicitando à service que Delete o produto no banco:
		produtoService.deletarProduto(produto);
		
		// Antes de despachar o usuário, adicionar um atributo à requisição:
		request.setAttribute("mensagem", "O produto foi excluido com sucesso!");
		
		// Despachar o usuário à parte de visão (apresentação - view):
		RequestDispatcher view = request.getRequestDispatcher("listaproduto.jsp");
		view.forward(request, response);

	}

}
