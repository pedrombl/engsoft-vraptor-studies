<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css"><%@include file="../../css/style.css" %></style>
<title>Resultados</title>
</head>
<body>
<div id="all">
<div id="content">
<h1>Buscas do Twitter</h1>

<h3>${search.word}</h3>
<table>
	<% 
		int i = 0;
		String type = "";
	%>
	<c:forEach items="${search.tweets}" var="tweet">
		<% 
			i++;
			if (i%2 == 0) 
				type = "even";
			else
				type = "odd";
		%>
		<tr class="<%= type %>"><td>${tweet.fromUser }</td><td>${tweet.text }</td></tr>
	</c:forEach>
</table>
<a href="..">Voltar a lista de busca</a>
</div>
</div>
</body>
</html>