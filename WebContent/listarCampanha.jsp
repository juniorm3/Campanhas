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
	
	<c:url var="novaCampanhaUrl" value="/EditarCampanha" />
	<A href="${novaCampanhaUrl}">Criar Campanha</A><BR><BR>
	<table width="100%" border="1">
		<tr>
			<td align="center"><strong>Campanha</strong></td>
			<td align="center"><strong>Dt Inicio</strong></td>
			<td align="center"><strong>Dt Fim</strong></td>
			<td align="center"><strong>Time do Coração</strong></td>
			<td></td>
		</tr>
		
		<c:choose>
			<c:when test="${empty(campanhas)}">
				<td colspan="4" align="center">Nenhuma campanha cadastrada</td>
			</c:when>
			<c:otherwise>
				<c:forEach var="c" items="${campanhas}">
					<tr>
						<c:url var="editarCampanhaUrl" value="/EditarCampanha" >
							<c:param name="id">${c.id}</c:param>
						</c:url>
						
						<c:url var="excluirCampanhaUrl" value="/ExcluirCampanha" >
							<c:param name="id">${c.id}</c:param>
						</c:url>
						
						<td align="center"><A href="${editarCampanhaUrl}">${c.nomeCampanha}</A></td>
						<td align="center">${c.inicio}</td>
						<td align="center">${c.fim}</td>
						<td align="center">${c.idTimeCoracao }</td>
						<td align="center"><A href="${excluirCampanhaUrl}">Excluir</A></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>

</body>
</html>