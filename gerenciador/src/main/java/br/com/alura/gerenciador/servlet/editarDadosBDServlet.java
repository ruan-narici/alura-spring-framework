package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;


//@WebServlet("/editarDadosBD")
public class editarDadosBDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String nome = request.getParameter("nomeDaEmpresa");
	Date data;
	try {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		data = formato.parse(request.getParameter("dataCadastro"));
	} catch (ParseException e) {
		throw new ServletException(e);
	}
	
	String idParam = request.getParameter("id");
	Integer id = Integer.valueOf(idParam);
	
	
	BancoDeDados banco = new BancoDeDados();
	
	banco.buscaEmpresaId(id).setNome(nome);
	banco.buscaEmpresaId(id).setDataCadastro(data);
	
	response.sendRedirect("listaEmpresas");
	
	}

}
