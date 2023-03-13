<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="entradaUnica"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastro de empresa</title>
	</head>
	<body>
		<h1>Lista de empresas cadastradas:</h1>
		<c:if test="${not empty empresas}">
			<ul>
				<c:forEach items="${empresas}" var="empresa">
					<li>${empresa.getNome()} - <fmt:formatDate value="${empresa.getDataCadastro()}" pattern="dd/MM/yyyy"/>
					<a href="${entradaUnica}?acao=mostraEmpresa&id=${empresa.getId()}">editar</a>
					<a href="${entradaUnica}?acao=removeEmpresa&id=${empresa.getId()}">remover</a>
					</li>
				</c:forEach>
			</ul>
		</c:if>
		<c:if test="${empty empresas}">
			<p>Lista vazia.</p>
		</c:if>
	</body>
</html>