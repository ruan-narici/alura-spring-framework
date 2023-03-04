package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

	private static List<Empresa> empresas = new ArrayList<>();
	
	public void addToList(Empresa empresa) {
		BancoDeDados.empresas.add(empresa);
	}
	
	public List<Empresa> getList() {
		return BancoDeDados.empresas;
	}
}
