<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="NovaEmpresa"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Boas Vindas</title>
	</head>
	<body>
		<h1>Seja bem-vindo ao site de cadastro de empresa!</h1>
		<form action="${NovaEmpresa}" method="get">
			<input type="submit" value="Cadastrar"/>
			<input type="hidden" name="acao" value="novaEmpresaForm"/>
		</form>
	</body>
</html>