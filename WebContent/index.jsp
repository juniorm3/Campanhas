<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Campanhas</title>
</head>
<body>
<table width="100%" border="1">
	<tr>
		<td colspan="3" align="center"><h1>Campanhas</h1></td>		
	</tr>
	<tr>
		<c:url var="administrarUrl" value="/ListarCampanha"/>
		<td align="center"><a href="${administrarUrl}"><h2>Administrar Campanhas</h2></a></td>
		
		<c:url var="usuarioUrl" value="/ListarUsuario"/>
		<td align="center"><a href="${usuarioUrl}"><h2>Gerenciar Usuários</h2></a></td>
		
		<c:url var="participarUrl" value="" />
		<td align="center"><a href="${participarUrl}"><h2>Participar de Campanha</h2></a></td>

	</tr>
</table>
</body>
</html>