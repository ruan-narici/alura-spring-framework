package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;


@WebServlet("/entrada")
public class EntradaUnicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		HttpSession sessao = request.getSession();
		
		
		boolean naoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
		boolean naoEstaProtegida = (paramAcao.equals("login") || paramAcao.equals("formLogin"));
		
		if (naoEstaLogado && !naoEstaProtegida) {
			response.sendRedirect("entrada?acao=login");
			return;
		}
		
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		String nome = null;
		
//		paramAcao.executa(request, response);
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		String[] tipoENome = nome.split(":");
		
		if (tipoENome[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoENome[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoENome[1]);
		}
		
		
//		if (paramAcao.equals("listaEmpresas")) {
//			listaEmpresas acao = new listaEmpresas();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("novaEmpresa")) {
//			novaEmpresa acao = new novaEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("mostraEmpresa")) {
//			mostraEmpresa acao = new mostraEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("alteraEmpresa")) {
//			alteraEmpresa acao = new alteraEmpresa();
//			nome = acao.executa(request, response);
//		}	else if (paramAcao.equals("removeEmpresa")) {
//			removeEmpresa acao = new removeEmpresa();
//			nome = acao.executa(request, response);
//		} else if (paramAcao.equals("novaEmpresaForm")) {
//			novaEmpresaForm acao = new novaEmpresaForm();
//			nome = acao.executa(request, response);
//		}
		
	}

}
