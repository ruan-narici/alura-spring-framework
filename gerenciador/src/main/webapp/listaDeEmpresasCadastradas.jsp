<%@page import="br.com.alura.gerenciador.servlet.Empresa"%>
<%@page import="br.com.alura.gerenciador.servlet.BancoDeDados"%>
<%@page import="java.util.List" %>
<%
List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas");
%>

<html>
<body>
<h1>Lista de empresas cadastradas:</h1>
<ul>

<% 
for (Empresa empresa : lista) {
	out.println(String.format("<li>%s</li>", empresa.getNome().toString()));
}
%>

</ul>
</body>
</html>