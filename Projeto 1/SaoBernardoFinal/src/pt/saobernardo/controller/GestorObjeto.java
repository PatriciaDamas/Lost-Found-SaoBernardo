package pt.saobernardo.controller;

import pt.saobernardo.model.InstituicaoSolidariedade;
import pt.saobernardo.model.ObjetoPerdido;


public class GestorObjeto {

	// Inserir um objeto nas configurações
	// Escolher a is que se pretende doar o objeto
	public static boolean inserirObjeto(String objeto, Object is) {
		boolean res = true;
		InstituicaoSolidariedade inst = (InstituicaoSolidariedade) is;
		//InstituicaoSolidariedade inst = new InstituicaoSolidariedade(GestorIS.getUltimoCodigoIs(),is);
		
		for (ObjetoPerdido op : SaoBernardo.objetos) {
			if (op.getObjetoTipo().equals(objeto)) {
				res = false;
			}

		}

		if (res == true) {
			ObjetoPerdido op = new ObjetoPerdido(getUltimoCodigo(),objeto, inst);
			SaoBernardo.objetos.add(op);

		}

		return res;
	}

	// Remover Objeto
	public static boolean removerObjeto(String objeto) {
		boolean res = false;

		for (int i = 0; i < SaoBernardo.objetos.size(); i++) {
			if (SaoBernardo.objetos.get(i).getObjetoTipo().equals(objeto)) {
				SaoBernardo.objetos.remove(i);
				res = true;
			}
		}

		return res;
	}

	// Metodo que vai permitir alterar o tipo de objetos e a respetiva
	// instituição
	public static boolean alterarObjeto(String objeto, String novoObjeto,
			Object novaInstituicao) {
		boolean res = false;
		InstituicaoSolidariedade ins = (InstituicaoSolidariedade) novaInstituicao;
		for (int i = 0; i < SaoBernardo.objetos.size(); i++) {
			if (SaoBernardo.objetos.get(i).getObjetoTipo().equals(objeto)) {
				ObjetoPerdido op = SaoBernardo.objetos.get(i);
				if (isObjeto(novoObjeto) == true) {
					res = false;
					if (res == false) {//Quando entra neste ciclo altera apenas a is em relação ao objeto
						op.setIs(ins);
					}
				} else {
					op.setObjetoTipo(novoObjeto);
					op.setIs(ins);
					res = true;
				}

			}
		}

		return res;
		
	}

	// Verificar se o objeto existe
	public static boolean isObjeto(String objeto) {
		boolean res = false;

		for (int i = 0; i < SaoBernardo.objetos.size(); i++) {
			if (SaoBernardo.objetos.get(i).getObjetoTipo().equals(objeto)) {
				res = true;
			}
		}

		return res;

	}

	// Gerar códigos para a lista de Objetos
	
	public static int getUltimoCodigo(){
		return SaoBernardo.objetos.get(SaoBernardo.objetos.size()-1).getCodigoTipo() + 1;
	}

}
