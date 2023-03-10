<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="listaEmpresas"/>
<c:url value="/formNovaEmpresa.jsp" var="htmlNovaEmpresa"/>

<html>
		<body>
			<h1>A empresa ${empresa.getNome()} foi cadastrada com sucesso!</h1>
			<form action="${htmlNovaEmpresa}" method="get">
					<input type="submit" value="novoCadastro"/>
			</form>
			<form action="${listaEmpresas}" method="get">
					<input type="submit" name="acao" value="listaEmpresas"/>
			</form>
		</body>
</html>