<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/editarDadosBD" var="listaEmpresas"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Editar empresa</title>
	</head>
	<body>
		<form action="${listaEmpresas}" method="post">
			<label for="nomeEmpresa">Nome da empresa: </label>
			<input type="text" name="nomeDaEmpresa" id="nomeEmpresa" value="${empresa.getNome()}"/>
			<label for="dataDoCadastro">Data do cadastro: </label>
			<input type="date" name="dataCadastro" id="DataDoCadastro" value="<fmt:formatDate value="${empresa.getDataCadastro()}" pattern="yyyy-MM-dd"/>" />
			<input type="hidden" name="id" value="${empresa.getId()}">
			<input type="submit"/>
		</form>
	</body>
</html>