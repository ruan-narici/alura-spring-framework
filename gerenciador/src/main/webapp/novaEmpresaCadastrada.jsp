<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/listaEmpresas" var="listaEmpresas"/>
<c:url value="/formNovaEmpresa.jsp" var="htmlNovaEmpresa"/>

<html>
		<body>
			<c:if test="${not empty empresa}">
				<h1>A empresa ${empresa.getNome()} foi cadastrada com sucesso!</h1>
			</c:if>
			<c:if test="${empty empresa}">
				<h1>Você deve efetuar um novo cadastro.</h1>
			</c:if>
			<form action="${htmlNovaEmpresa}" method="get">
					<input type="submit" value="Novo cadastro"/>
			</form>
			<form action="${listaEmpresas}" method="get">
					<input type="submit" value="Lista de empresas"/>
			</form>
		</body>
</html>