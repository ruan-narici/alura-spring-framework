package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/novaEmpresa")
public class novaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String empresa = request.getParameter("nomeDaEmpresa");
		
		BancoDeDados bdd = new BancoDeDados();
		Empresa empresaSave = new Empresa();
		
		//Definindo o nome e a data de cadastro da empresa.
		empresaSave.setNome(empresa);
		Date data;
		try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			data = formato.parse(request.getParameter("dataCadastro"));
			empresaSave.setDataCadastro(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		//Registrando no banco de dados.
		bdd.addToList(empresaSave);
		
		//Exibindo o status do cadastro.
//		escrevaAResposta.println(String.format(
//						"""
//								<html>
//										<body>
//											<h1>A empresa %s foi cadastrada com sucesso!</h1>
//											<p>Horário: %s</p>
//											<form action="/gerenciador/formNovaEmpresa.html" method="get">
//													<input type="submit" value="Novo cadastro"/>
//											</form>
//											<form action="/gerenciador/listaEmpresas" method="get">
//													<input type="submit" value="Lista de empresas"/>
//											</form>
//										</body>
//										
//								</html>
//						""",empresa, time
//				));
		
		//Enviando atributos para o arquivo JSP e chamando ele.
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCadastrada.jsp");
		request.setAttribute("empresa", empresaSave.getNome());
		rd.forward(request, response);
		
		//Notificando no console o status do cadastro.
		System.out.println("Uma nova empresa foi cadastrada no servidor.");
	}

}
