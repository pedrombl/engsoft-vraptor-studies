<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO 639-1">
<title>Twitter Search Results</title>
</head>
<body>

<h1>Buscas do Twitter</h1>

<p> Nesse projeto web você pode adicionar palavras que deseja procurar no twitter. Quando acessar o link que cada palavra aparecerá os ultimos tweets contendo essa palavra. </p> 
	
<table>
	<thead>
		<tr>
			<th>Palavra buscada</th>
			<th>Resultados</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${searchList}" var="search">
			<tr>
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
<hr/>
<h3>Informações sobre o projeto</h3>
<b>Nome:</b> Pedro Morhy Borges Leal </br>
<b>Numero USP:</b> 5893830 </br>
<b>Código fonte do projeto:</b> <a href="https://github.com/pedrombl/engsoft-vraptor-studies">github</a> / <a href="arquivos/codigo-pedroleal-engsoft.zip">download</a> </br>
</body>
</html>