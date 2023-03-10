package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;
import br.com.alura.gerenciador.modelo.Empresa;

public class mostraEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Exibindo empresa");
		
		String id = request.getParameter("id");
		Integer idKey = Integer.valueOf(id);
		
		BancoDeDados banco = new BancoDeDados();
		Empresa emp = null;
		
		for (Empresa empresa : banco.getList()) {
			if (empresa.getId() == idKey) {
				emp = empresa;
			}
		}
		
		request.setAttribute("empresa", emp);
		RequestDispatcher rd = request.getRequestDispatcher("formEditaEmpresa.jsp");
		rd.forward(request, response);
	}
}
