package pt.saobernardo.controller;



import pt.saobernardo.model.InstituicaoSolidariedade;



public class GestorIS {
	public static boolean inserirIS(String instituicao) {
		boolean res = true;

		for (InstituicaoSolidariedade is : SaoBernardo.instituicoes) {
			if (is.getNomeIs().equals(instituicao)) {
				res = false;
			}
		}

		if (res == true) {
			InstituicaoSolidariedade i = new InstituicaoSolidariedade(getUltimoCodigoIs(),instituicao);
			SaoBernardo.instituicoes.add(i);
		}

		return res;
	}
	
	public static boolean removerIS(String instituicao) {
		boolean res = false;
		
		for (int i = 0; i < SaoBernardo.instituicoes.size(); i++) {
			if(SaoBernardo.instituicoes.get(i).getNomeIs().equals(instituicao)) {
				SaoBernardo.instituicoes.remove(i);
				res = true;
			}
		}

		return res;
	}
	
	public static boolean alterarIS(String instituicao, String novaInstituicao) {
		boolean res = false;
		
		for (int i = 0; i < SaoBernardo.instituicoes.size(); i++) {
			if(SaoBernardo.instituicoes.get(i).getNomeIs().equals(instituicao)) {
				InstituicaoSolidariedade is = SaoBernardo.instituicoes.get(i);
				if(isInstituicao(novaInstituicao) == true){
				res = false;
				}
				else{
					is.setNomeIs(novaInstituicao);
					res = true;
				}
				
			}
		}
		
		return res;
	}
	
	public static boolean isInstituicao(String instituicao) {
		boolean res = false;
		
		for (int i = 0; i < SaoBernardo.instituicoes.size(); i++) {
			if (SaoBernardo.instituicoes.get(i).getNomeIs().equals(instituicao)) {
				res = true;
			}
		}
		
		
		return res;
		
	}
	// Gerar códigos para as Instituições
	
	public static int getUltimoCodigoIs(){
		return SaoBernardo.instituicoes.get(SaoBernardo.instituicoes.size()-1).getCodigoIs()+1;
	}
}
