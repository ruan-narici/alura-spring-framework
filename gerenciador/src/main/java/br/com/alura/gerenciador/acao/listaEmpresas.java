package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;

public class listaEmpresas {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Listando empresas");
		
		BancoDeDados banco = new BancoDeDados();
		
		request.setAttribute("empresas", banco.getList());
		RequestDispatcher rd = request.getRequestDispatcher("listaDeEmpresasCadastradas.jsp");
		rd.forward(request, response);
	}
}
