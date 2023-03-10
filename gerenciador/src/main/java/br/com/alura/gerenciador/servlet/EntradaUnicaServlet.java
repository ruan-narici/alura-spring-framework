package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.alteraEmpresa;
import br.com.alura.gerenciador.acao.listaEmpresas;
import br.com.alura.gerenciador.acao.mostraEmpresa;
import br.com.alura.gerenciador.acao.novaEmpresa;
import br.com.alura.gerenciador.acao.removeEmpresa;

@WebServlet("/entrada")
public class EntradaUnicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		if (paramAcao.equals("listaEmpresas")) {
			listaEmpresas acao = new listaEmpresas();
			acao.executa(request, response);
		} else if (paramAcao.equals("novaEmpresa")) {
			novaEmpresa acao = new novaEmpresa();
			acao.executa(request, response);
		} else if (paramAcao.equals("mostraEmpresa")) {
			mostraEmpresa acao = new mostraEmpresa();
			acao.executa(request, response);
		} else if (paramAcao.equals("alteraEmpresa")) {
			alteraEmpresa acao = new alteraEmpresa();
			acao.executa(request, response);
		}	else if (paramAcao.equals("removeEmpresa")) {
			removeEmpresa acao = new removeEmpresa();
			acao.executa(request, response);
		}
	}

}
