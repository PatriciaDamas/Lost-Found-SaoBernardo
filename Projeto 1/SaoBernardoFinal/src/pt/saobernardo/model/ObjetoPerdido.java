package pt.saobernardo.model;

public class ObjetoPerdido {

	
	private int codigoTipo;
	private String objetoTipo;
	private InstituicaoSolidariedade is;
	
	
	public ObjetoPerdido(int codigoTipo, String objetoTipo, InstituicaoSolidariedade is) {
		super();
		
		this.codigoTipo = codigoTipo;
		this.objetoTipo = objetoTipo;
		this.is = is;
	}

	public int getCodigoTipo() {
		return codigoTipo;
	}

	public void setCodigoTipo(int codigoTipo) {
		this.codigoTipo = codigoTipo;
	}

	public String getObjetoTipo() {
		return objetoTipo;
	}

	public void setObjetoTipo(String objetoTipo) {
		this.objetoTipo = objetoTipo;
	}

	public InstituicaoSolidariedade getIs() {
		return is;
	}

	public void setIs(InstituicaoSolidariedade is) {
		this.is = is;
	}

	@Override
	public String toString() {
		return this.objetoTipo;
	}
	
	

	
}
