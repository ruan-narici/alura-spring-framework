package br.com.ruannarici.servico;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class createHTML {
	
	public void createDocHTML(List<List> listaDeFilmes) throws IOException {
		FileOutputStream fos = new FileOutputStream("./src/main/webapp/index.html");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write("""
			<html>
				<head>
					<meta charset="UTF-8">
					<title>TOP 250 Filmes</title>
					<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
				</head>
				<body>
					<h1 class="d-flex justify-content-center">TOP 250 Filmes</h1>
					<div class="d-flex flex-wrap justify-content-center">
					
			""");
		for (int i = 0; i < listaDeFilmes.get(0).size(); i++) {
		bw.write(String.format(
				"""
					<div class="card m-3 p-2" style="width: 18rem;">
							<h5 class="card-title border-bottom ">%s</h5>	
							<img class="card-img-top" src="%s">
							<p class="card-text m-2">Nota: %s - Ano: %s</p>
					</div>
				"""
				,listaDeFilmes.get(0).get(i), listaDeFilmes.get(1).get(i), listaDeFilmes.get(2).get(i), listaDeFilmes.get(3).get(i)));
		}
		bw.write("""
				</div>
				</body>
			</html>
			""");
		
		bw.close();
	}

}
