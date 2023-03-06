<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.format.DateTimeFormatterBuilder"%>
<%@page import="java.time.LocalTime"%>
<% String empresa = request.getAttribute("empresa").toString(); 
	LocalTime hora = LocalTime.now();
	DateTimeFormatter formatador = new DateTimeFormatterBuilder().toFormatter().ofPattern("HH:mm");
	String horaFormatada = hora.format(formatador);
%>

<html>
		<body>
			<h1>A empresa <%= empresa %>  foi cadastrada com sucesso!</h1>
			<p>Horário: <%= horaFormatada %></p>
			<form action="/gerenciador/formNovaEmpresa.html" method="get">
					<input type="submit" value="Novo cadastro"/>
			</form>
			<form action="/gerenciador/listaEmpresas" method="get">
					<input type="submit" value="Lista de empresas"/>
			</form>
		</body>
		
</html>