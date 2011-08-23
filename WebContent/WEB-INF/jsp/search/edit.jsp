<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css"><%@include file="../../css/style.css" %></style>
<title>Editar</title>
</head>
<body>
<div id="all">
<div id="content">

<h1>Buscas do Twitter</h1>

<form action="update">
	<fieldset>
		<legend>Editar busca</legend>
		
		<input type="hidden" name="search.id" value="${search.id }">
		
		<label for="word">Palavra:</label>
		<input id="word" type="text" name="search.word" value="${search.word }">
		<button type="submit">Enviar</button>
	</fieldset>
</form>
</div>
</div>
</body>
</html>