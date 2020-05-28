<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.ArrayList"%>
<%@ page import="model.Produto"%>
<%@ page import="service.ProdutoService"%>
<!DOCTYPE html>
<html>
<style>
		table, th, td {border: 1px solid black;}
		table{width: 100%;} 
		th {height: 50px; }
		td { text-align: center;}
		tr:nth-child(even) {background-color: #f4f4f4;}
	</style>

<head>
<meta charset="utf-8">
<title> Lista Produtos</title>
</head>
<body>
<body>
  	${requestScope.mensagem}
	
  	<a class="navbar-brand" href="home.jsp">Task Product</a>
  	 <a class="nav-item nav-link" href="adicionarproduto.jsp">Adicionar Produto</a>	

	<table border = "1">
		<tr>
			<th >Código Produto</th>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Valor</th>	
			<th>Estoque</th>
			<th>Alterar</th>
			<th>Excluir</th>
		</tr>

			
		<%
			ArrayList<Produto> listar;
			ProdutoService pds = new ProdutoService();		
			listar = pds.listarProdutos();
			
			for (Produto prod : listar){	
		%>
				
		<tr>
			<td><%=prod.getCodigo() %></td>
			<td><%=prod.getNomeProduto() %></td>
			<td><%= prod.getDescricaoProduto() %></td>
			<td>R$ <%= prod.getValorProduto() %></td>
			<td><%= prod.getEstoqueProduto() %></td>			
			<td><a href="editar.jsp?codigo=<%=prod.getCodigo()%>">Editar</a></td>
			<td><a href="controller.do?command=DeletarProduto&codigo=<%=prod.getCodigo()%>">Excluir</a></td>		
			
		</tr>					
				
		<%}%>			
				
		</table>


</body>
</html>