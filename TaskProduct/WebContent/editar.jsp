<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ page import="model.Produto"%>
<%@ page import="service.ProdutoService"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Produto</title>
</head>
<body>

  	<a href="listaproduto.jsp">Task Product</a>
  	 <a href="adicionarproduto.jsp">Cadastrar Produto</a>
	
	
	<%
	Produto prod = new Produto();
	ProdutoService produtoService = new ProdutoService(); 
	int codigo = Integer.parseInt(request.getParameter("codigo"));	
	prod = produtoService.buscarProduto(codigo);	
	%>

<form action="controller.do" method="post">
	
  	${requestScope.mensagem}

	<input type="hidden" name="command" value="EditarProduto"> 
  
     <label>Id Produto</label>
      <input class="form-control" type="number"  name="codigo" placeholder="Código"  value= <%= prod.getCodigo() %>>
   
    
     <label>Nome Produto</label>
      <input type="text" class="form-control" name="nome" placeholder="nome"  value= <%= prod.getNomeProduto() %>>
  
      <label>Descrição do Produto</label>
      <input type="text" class="form-control" name="descricao" placeholder="Descrição"  value= <%= prod.getDescricaoProduto() %>>
    
      <label>Valor do Produto</label>
      <input type="number" class="form-control"  step="0.1" name="valor"  placeholder="Valor"  value= <%= prod.getValorProduto() %>>
   
      <label>Quantidade do Produto</label>
      <input type="text" class="form-control"  name="estoque" placeholder="Quantidade"  value= <%= prod.getEstoqueProduto() %>>
   
    
   <button class="btn btn-primary btn-block" type="submit">Editar</button>
    

</form>


</body>
</html>