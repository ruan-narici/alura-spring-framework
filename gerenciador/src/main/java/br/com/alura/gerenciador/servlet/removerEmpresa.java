package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;


@WebServlet("/removerEmpresa")
public class removerEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idKeyS = request.getParameter("id");
		Integer idKey = Integer.valueOf(idKeyS);
		
		BancoDeDados banco = new BancoDeDados();
		
		for (int i = 0; i < banco.getList().size(); i++) {
			if (banco.getList().get(i).getId() == idKey) {
				banco.removeEmpresa(banco.getList().get(i));
			}
		}
		
		response.sendRedirect("listaEmpresas");
	}

}
