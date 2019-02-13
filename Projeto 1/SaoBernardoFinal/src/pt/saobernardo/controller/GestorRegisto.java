package pt.saobernardo.controller;

import pt.saobernardo.model.ObjetoPerdido;
import pt.saobernardo.model.Registo;
import pt.saobernardo.model.Sala;


public class GestorRegisto {
	
	public static boolean inserirRegisto(String nome, String email, Object sala, String data, String hora, String cor, String estado,String descricao, Object objeto){
		boolean res = true;

		
		Sala s = (Sala) sala;
		ObjetoPerdido op = (ObjetoPerdido) objeto;
		for (Registo r : SaoBernardo.registos) {
			if (r.getNome().equals(nome) && r.getCor().equals(cor)&& r.getEmail().equals(email) && r.getDescricao().equals(descricao)&& r.getData().equals(data) ) {
				res = false;
			}
		}
		
		if (res == true) {
			Registo r = new Registo(getUltimoCodigoRegisto(),nome,email,s,data,hora,cor,estado,descricao,op);
			SaoBernardo.registos.add(r);
		}
		
		
		return res;
		
	}
	
	public static int getUltimoCodigoRegisto(){
		if (SaoBernardo.registos.size() == 0) {
			return 1;
		}
		else
		return SaoBernardo.registos.get(SaoBernardo.registos.size()-1).getCodigo()+1;
	}
	
	public static void entregarObjeto(int codigo){
		
		for (int i = 0; i < SaoBernardo.registos.size(); i++) {
			Registo reg = SaoBernardo.registos.get(i);
			if (reg.getCodigo() == (codigo)) {
				SaoBernardo.registos.remove(reg);
			}
		}
		
	}

}
