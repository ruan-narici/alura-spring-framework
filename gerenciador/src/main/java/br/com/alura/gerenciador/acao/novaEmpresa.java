package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;
import br.com.alura.gerenciador.modelo.Empresa;

public class novaEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String empresa = request.getParameter("nomeDaEmpresa");
		
		BancoDeDados bdd = new BancoDeDados();
		Empresa empresaSave = new Empresa();
		
		empresaSave.setNome(empresa);
		Date data;
		try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			data = formato.parse(request.getParameter("dataCadastro"));
			empresaSave.setDataCadastro(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		bdd.addToList(empresaSave);
		
		request.setAttribute("empresa", empresaSave);
		
		System.out.println("Uma nova empresa foi cadastrada no servidor.");

		return "forward:novaEmpresaCadastrada.jsp";
	}

}
