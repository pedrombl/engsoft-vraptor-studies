<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO 639-1">
<title>Twitter Search Results</title>
</head>
<body>
	Buscas do Twitter
	
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
					<a href="/twitter-search-results/search/${search.id}">${search.word }</a>
				</td>
				<td>
					<a href="/twitter-search-results/search/${search.id}/edit">editar</a> 
					<a href="/twitter-search-results/search/remove?id=${search.id}">apagar</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>	
<a href="/twitter-search-results/search/create">Adicionar busca do Twitter</a>
</body>
</html>