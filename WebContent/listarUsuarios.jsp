<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
	<c:url var="novoUsuarioUrl" value="/EditarUsuario" />
	<A href="${novoUsuarioUrl}">Cadastrar Usuário</A><BR><BR>
	<table width="100%" border="1">
		<tr>
			<td align="center"><strong>Usuário</strong></td>
			<td align="center"><strong>E-Mail</strong></td>
			<td align="center"><strong>Dt Nascimento</strong></td>
			<td align="center"><strong>Time do Coração</strong></td>
			<td></td>
		</tr>
		
		<c:choose>
			<c:when test="${empty(usuarios)}">
				<td colspan="4" align="center">Nenhuma campanha cadastrada</td>
			</c:when>
			<c:otherwise>
				<c:forEach var="c" items="${usuarios}">
					<tr>
						<c:url var="editarUsuarioUrl" value="/EditarUsuario" >
							<c:param name="id">${c.id}</c:param>
						</c:url>
						
						<c:url var="excluirUsuarioUrl" value="/ExcluirUsuario" >
							<c:param name="id">${c.id}</c:param>
						</c:url>
						
						<td align="center"><A href="${editarUsuarioUrl}">${c.nome}</A></td>
						<td align="center">${c.email}</td>
						<td align="center"><fmt:formatDate type="date" value="${c.nascimento}"/></td>
						<td align="center">${c.time }</td>
						<td align="center"><A href="${excluirUsuarioUrl}">Excluir</A></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>