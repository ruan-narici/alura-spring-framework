<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="novaEmpresa"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastro de empresa</title>
	</head>
	<body>
		<form action="${novaEmpresa}" method="post">
			<label for="nomeEmpresa">Nome da empresa: </label>
			<input type="text" name="nomeDaEmpresa" id="nomeEmpresa"/>
			<label for="dataDoCadastro">Data do cadastro: </label>
			<input type="date" name="dataCadastro" id="DataDoCadastro"/>
			<input type="hidden" name="acao" value="novaEmpresa"/>
			<input type="submit"/>
		</form>
	</body>
</html>