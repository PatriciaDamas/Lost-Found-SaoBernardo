package pt.saobernardo.controller;

import pt.saobernardo.model.Utilizador;

public class GestorUtilizador {

	// código que vai ao array list e verifica se tem uma password para fazer o login
	public static boolean procuraUtilizador(String utilizador, String password) {
		
		boolean res = false;
		for (Utilizador u : SaoBernardo.utilizadores) {
			if (u.getNomeLogin().equals(utilizador) && u.getPassword().equals(password)) {
				res = true;
			}
		}

		return res;
	}
	
	// Adicionar um novo utilizador
	
	public static boolean inserirUtilizador(String utilizador, String password, String nome) {
		boolean res = true;

		for (Utilizador u : SaoBernardo.utilizadores) {
			if (u.getNomeLogin().equals(utilizador)) {
				res = false;
			}
		}

		if (res == true) {
			Utilizador u = new Utilizador(utilizador, password, nome);
			SaoBernardo.utilizadores.add(u);
		}

		return res;
	}
	
	public static boolean removerUtilizador(String utilizador, String nome) {
		boolean res = false;

		for (int i = 0; i < SaoBernardo.utilizadores.size(); i++) {
			if(SaoBernardo.utilizadores.get(i).getNomeLogin().equals(utilizador) && SaoBernardo.utilizadores.get(i).getNome().equals(nome)) {
				SaoBernardo.utilizadores.remove(i);
				res = true;
			}
		}

		return res;
	}
	
	
	
}
