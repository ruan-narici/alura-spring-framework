package br.com.ruannarici.main;

import java.util.List;

import br.com.ruannarici.modelo.Filme;
import br.com.ruannarici.servico.createHTML;
import br.com.ruannarici.servico.getJsonAndRefactor;

public class Execute {
	
	public static void main(String[] args) throws Exception {
		
		String KeyApi = "k_9synf3in";
		
		getJsonAndRefactor JsonWeb = new getJsonAndRefactor();
		
		String jsonString = JsonWeb.jsonToStringJava(KeyApi);
		Filme[] filmes = JsonWeb.StringJsonToAtributtesJava(jsonString);
		List<List> listaDeFilmes = JsonWeb.filmesToList(filmes);
		System.out.println(listaDeFilmes.get(0).get(0));
		System.out.println(listaDeFilmes.get(1).get(0));
		System.out.println(listaDeFilmes.get(2).get(0));
		System.out.println(listaDeFilmes.get(3).get(0));
		createHTML gerarHTML = new createHTML();
		gerarHTML.createDocHTML(listaDeFilmes);
	}

}
