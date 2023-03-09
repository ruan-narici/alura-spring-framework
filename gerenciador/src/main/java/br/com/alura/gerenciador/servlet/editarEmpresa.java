package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/editarEmpresa")
public class editarEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
