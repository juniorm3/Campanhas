<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Campanha</title>
</head>
<body>
	<c:if test="${mensagens.existeErros}">
		<div id="erro">
			<ul>
				<strong>Warning!</strong>
					<c:forEach var="erro" items="${mensagens.erros}">
						<li> ${erro} </li>
					</c:forEach>
			</ul>
		</div>
	</c:if>
	<form action="SalvarCampanha" method="post">
		<c:if test="${campanha.id != null }">
			<input type="hidden" name="id" value="${campanha.id }">
		</c:if>
		<table>
			<tr>
				<td colspan="4" align="center"><h2>Iserir ou Editar Campanha</h2></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome" value="${campanha.nomeCampanha }"></td>
			</tr>
			<tr>
				<td>Dt Inicio:</td>
				<td><input type="text" name="inicio" id="inicio" placeholder="Ex.: dd/mm/aaaa" maxlength="10" value="${campanha.inicio }" onKeyPress="DataHora(event, this)"></td>				
			</tr>
			<tr>
				<td>Dt Fim:</td>
				<td><input type="text" name="fim" id="fim" placeholder="Ex.: dd/mm/aaaa" maxlength="10" value="${campanha.fim }" onKeyPress="DataHora(event, this)"></td>
			</tr>
			<tr>
				<td>Time do Coração:</td>
				<td><input type="text" name="time" value="${campanha.idTimeCoracao }"></td>
			</tr>
			<tr>
				<td colspan="4" align="right"><input type="submit"	value="Salvar"></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">		
	function DataHora(evento, objeto){
		var keypress=(window.event)?event.keyCode:evento.which;
		campo = eval (objeto);
		if (campo.value == '00/00/0000')
		{
			campo.value=""
		}
	 
		caracteres = '0123456789';
		separacao1 = '/';
		separacao2 = ' ';
		separacao3 = ':';
		conjunto1 = 2;
		conjunto2 = 5;
		conjunto3 = 10;
		conjunto4 = 13;
		conjunto5 = 16;
		if ((caracteres.search(String.fromCharCode (keypress))!=-1) && campo.value.length < (10))
		{
			if (campo.value.length == conjunto1 )
			campo.value = campo.value + separacao1;
			else if (campo.value.length == conjunto2)
			campo.value = campo.value + separacao1;
			else if (campo.value.length == conjunto3)
			campo.value = campo.value + separacao2;
			else if (campo.value.length == conjunto4)
			campo.value = campo.value + separacao3;
			else if (campo.value.length == conjunto5)
			campo.value = campo.value + separacao3;
		}
		else
			event.returnValue = false;
	}
	</script>
</body>
</html>