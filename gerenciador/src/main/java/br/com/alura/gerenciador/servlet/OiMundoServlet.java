package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
		PrintWriter escreverResposta = resp.getWriter();
		escreverResposta.print("<html>");
		escreverResposta.print("<body>");
		escreverResposta.print("<h1>Parabéns! Você conseguiu concluir esta etapa!</h1>");
		escreverResposta.print("</body>");
		escreverResposta.print("</html>");
		
		System.out.println("A class OiMundo foi chamada!");
	}

}
