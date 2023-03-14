package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;
import br.com.alura.gerenciador.modelo.Usuario;

public class login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		BancoDeDados banco = new BancoDeDados();
		for (Usuario user : banco.getUsuarios()) {
			if (user.autenticar(login, senha)) {
				return "redirect:entrada?acao=listaEmpresas";
			}
		}
		
		return "redirect:entrada?acao=formLogin";
		
	}

}
