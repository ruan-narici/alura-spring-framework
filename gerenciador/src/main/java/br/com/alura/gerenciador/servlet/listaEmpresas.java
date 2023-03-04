package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class listaEmpresas
 */
@WebServlet("/listaEmpresas")
public class listaEmpresas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BancoDeDados bdd = new BancoDeDados();
		
		PrintWriter escrevaResposta = response.getWriter();
		escrevaResposta.println("<html>");
		escrevaResposta.println("<body>");
		escrevaResposta.println("<h1>Lista de empresas cadastradas:</h1>");
		escrevaResposta.println("<ul>");
		
		
		for (Empresa empresa : bdd.getList()) {
			escrevaResposta.println("<li>" + empresa.getNome() + "</li>");
		}
		
		escrevaResposta.println("</ul>");
		escrevaResposta.println("</body>");
		escrevaResposta.println("</html>");
	}

}
