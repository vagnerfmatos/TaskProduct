<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar Produto</title>
</head>
<body>

  	<a  href="listaproduto.jsp">Task Product</a>

${requestScope.mensagem}
<h1>Adicionar Produto</h1>
<form action="controller.do" method="post">
	
  	
	
	<input type="hidden" name="command" value="AdicionarProduto"> 

     <label>Id Produto</label>
      <input class="form-control" type="number"  name="codigo" placeholder="Código">
      
	  <label>Nome Produto</label>
	  
      <input type="text" class="form-control" name="nome" placeholder="nome">
   
      <label>Descrição do Produto</label>
      <input type="text" class="form-control" name="descricao" placeholder="Descrição">
    
      <label>Valor do Produto</label>
      <input type="number" class="form-control"  step="0.1" name="valor"  placeholder="Valor">
    
      <label>Quantidade do Produto</label>
      <input type="text" class="form-control"  name="estoque" placeholder="Quantidade">
   
    
   <button class="btn btn-primary btn-block" type="submit">Cadastrar</button>
  
</form>


</body>
</html>