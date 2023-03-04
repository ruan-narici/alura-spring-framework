package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class novaEmpresa
 */
@WebServlet("/novaEmpresa")
public class novaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DateTimeFormatter format = new DateTimeFormatterBuilder().toFormatter().ofPattern("HH:mm:ss");
		String time = LocalTime.now().format(format);
		PrintWriter escrevaAResposta = response.getWriter();
		String empresa = request.getParameter("nomeDaEmpresa");
		
		escrevaAResposta.println(String.format(
						"""
								<html>
										<body>
												<h1>A empresa %s foi cadastrada com sucesso!</h1>
												<p>Horário: %s</p>
										</body>
								</html>
						""",empresa, time
				));
		System.out.println("Uma nova empresa foi cadastrada no servidor.");
	}

}
