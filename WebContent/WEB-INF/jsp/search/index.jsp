<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO 639-1">
<style type="text/css"><%@include file="../../css/style.css" %></style>
<title>Twitter Search Results</title>
</head>
<body>
<div id="all">
<div id="content">
<h1>Buscas do Twitter</h1>

<p> Nesse projeto web voc� pode adicionar palavras que deseja procurar no twitter. Quando acessar o link que cada palavra aparecer� os ultimos tweets contendo essa palavra. </p>
 
<div id="leftcontent">
<table>
	<thead>
		<tr>
			<th>Palavra buscada</th>
			<th>Op��es</th>
		</tr>
		
	</thead>
	<tbody>
		<% 
			int i = 0;
			String type = "";
		%>
		
		<c:forEach items="${searchList}" var="search">
			<% 
				i++;
				if (i%2 == 0) 
					type = "even";
				else
					type = "odd";
			%>
			
			<tr class="<%=type %>">
				<td>
					<a href="search/${search.id}">${search.word }</a>
				</td>
				<td>
					<a href="search/${search.id}/edit">editar</a> 
					<a href="search/remove?id=${search.id}">apagar</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>

</table>	

<a href="search/create">Adicionar busca do Twitter</a>
</div>
<div id="rightcontent">
<div id="rightcontente_inside">
	<h3>Informa��es sobre o projeto</h3>
	<b>Nome:</b> Pedro Morhy Borges Leal <br/>
	<b>Numero USP:</b> 5893830 <br/>
	<b>C�digo fonte do projeto:</b> <a href="https://github.com/pedrombl/engsoft-vraptor-studies/tree/v2.0">github</a> / <a href="arquivos/codigo-pedroleal-engsoft-2.zip">download</a> <br/>
</div>
</div>
</div>
</body>
</html>