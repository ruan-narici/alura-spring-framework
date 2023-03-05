package br.com.ruannarici.servico;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ruannarici.modelo.Filme;

/**
 * Servlet implementation class top250
 */
@WebServlet("/top250")
public class top250_NAOUSAR extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public List<List> pegandoFilmesDaLista() throws Exception{
		String KeyApi = "k_9synf3in";
		
		getJsonAndRefactor JsonWeb = new getJsonAndRefactor();
		
		String jsonString = JsonWeb.jsonToStringJava(KeyApi);
		Filme[] filmes = JsonWeb.StringJsonToAtributtesJava(jsonString);
		List<List> listaDeFilmes = JsonWeb.filmesToList(filmes);
		return listaDeFilmes;
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		writer.println(
				"""
				<html>
					<head>
						<meta charset="UTF=8">
						<title>Top 250 Filmes</title>
					</head>
					<body>
							<h1>TOP 250 Filmes</h1>
							<ul>
				"""
				);
		writer.println(
				"""
						</ul>
					</body>
				</html>	
				"""
				);
		
		List<List> filmes;
		try {
			filmes = pegandoFilmesDaLista();
			System.out.println(filmes.get(0).get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
