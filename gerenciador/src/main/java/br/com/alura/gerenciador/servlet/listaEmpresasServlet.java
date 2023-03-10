package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;
import br.com.alura.gerenciador.modelo.Empresa;


//@WebServlet("/listaEmpresas")
public class listaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Registrando itens do banco de dados na lista
		List<Empresa> lista = new BancoDeDados().getList();
		
		//Chamando a lista JSP
		RequestDispatcher rd = request.getRequestDispatcher("/listaDeEmpresasCadastradas.jsp");
		request.setAttribute("empresas", lista);
		rd.forward(request, response);
		
		
//		BancoDeDados bdd = new BancoDeDados();
//		
//		PrintWriter escrevaResposta = response.getWriter();
//		escrevaResposta.println("<html>");
//		escrevaResposta.println("<body>");
//		escrevaResposta.println("<h1>Lista de empresas cadastradas:</h1>");
//		escrevaResposta.println("<ul>");
//		
//		
//		for (Empresa empresa : bdd.getList()) {
//			escrevaResposta.println("<li>" + empresa.getNome() + "</li>");
//		}
//		
//		escrevaResposta.println("</ul>");
//		escrevaResposta.println("</body>");
//		escrevaResposta.println("</html>");
		
		
	}

}
