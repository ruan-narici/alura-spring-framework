package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;

public class removeEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("Removendo empresa");
		
		String idKeyS = request.getParameter("id");
		Integer idKey = Integer.valueOf(idKeyS);
		
		BancoDeDados banco = new BancoDeDados();
		
		for (int i = 0; i < banco.getList().size(); i++) {
			if (banco.getList().get(i).getId() == idKey) {
				banco.removeEmpresa(banco.getList().get(i));
			}
		}

		return "redirect:entrada?acao=listaEmpresas";
	}
}
