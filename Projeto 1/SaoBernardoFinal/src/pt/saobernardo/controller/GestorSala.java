package pt.saobernardo.controller;

import pt.saobernardo.model.Sala;

public class GestorSala {

	/**
	 * Método que vai permitir fazer a inserção de uma nova sala
	 * @param sala - Sala a ser inserida          
	 * @return True se a sala for inserida e false se a sala não for inserida
	 */

	public static boolean inserirSala(String sala) {
		boolean res = true;

		for (Sala s : SaoBernardo.salas) {
			if (s.getSala().equals(sala)) {
				res = false;
			}
		}

		if (res == true) {
			Sala s = new Sala(sala);
			SaoBernardo.salas.add(s);
		}

		return res;
	}
	
	public static boolean removerSala(String sala) {
		boolean res = false;
		
		for (int i = 0; i < SaoBernardo.salas.size(); i++) {
			if(SaoBernardo.salas.get(i).getSala().equals(sala)) {
				SaoBernardo.salas.remove(i);
				res = true;
			}
		}

		return res;
	}
	public static boolean alterarSala(String sala, String novaSala) {
		boolean res = false;
		
		for (int i = 0; i < SaoBernardo.salas.size(); i++) {
			if(SaoBernardo.salas.get(i).getSala().equals(sala)) {
				Sala s = SaoBernardo.salas.get(i);
				if(isSala(novaSala) == true){
					res = false;
				}
				else{
					s.setSala(novaSala);
					res = true;
				}
				
			}
		}
		
		return res;
	}

	//Verificar se a sala existe
	public static boolean isSala(String sala) {
		boolean res = false;
		
		for (int i = 0; i < SaoBernardo.salas.size(); i++) {
			if (SaoBernardo.salas.get(i).getSala().equals(sala)) {
				res = true;
			}
		}
		
		
		return res;
		
	}
	
	
	
	
}
