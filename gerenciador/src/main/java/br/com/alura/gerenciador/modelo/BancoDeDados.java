package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

	private static List<Empresa> empresas = new ArrayList<>();
	private static Integer idKey = 1;
	
	public void addToList(Empresa empresa) {
		empresa.setId(BancoDeDados.idKey);
		BancoDeDados.empresas.add(empresa);
		BancoDeDados.idKey++;
	}
	
	public List<Empresa> getList() {
		return BancoDeDados.empresas;
	}
	
	public void removeEmpresa(Empresa emp) {
		BancoDeDados.empresas.remove(emp);
	}
	
	public Empresa buscaEmpresaId(Integer id) {
		
		for (Empresa empresa : BancoDeDados.empresas) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
}
