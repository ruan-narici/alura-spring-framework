package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	private static Integer idKey = 1;
	
	static {
		Usuario user1 = new Usuario();
		user1.setLogin("ruan");
		user1.setSenha("123");
		Usuario user2 = new Usuario();
		user2.setLogin("cinthia");
		user2.setSenha("123");
		
		BancoDeDados.usuarios.add(user1);
		BancoDeDados.usuarios.add(user2);
	}
	
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
	
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}
}
