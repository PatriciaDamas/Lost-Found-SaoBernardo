package pt.saobernardo.model;
public class InstituicaoSolidariedade {

	
	private int codigoIs; // Código Instituicao de Solidariedade
	private String nomeIs; // Instituicao de Solidariedade
	
	
	public InstituicaoSolidariedade(int codigoIs, String nomeIs) {
		
		this.codigoIs = codigoIs;
		this.nomeIs = nomeIs;
	}
	public int getCodigoIs() {
		return codigoIs;
	}
	public void setCodigoIs(int codigoIs) {
		this.codigoIs = codigoIs;
	}
	public String getNomeIs() {
		return nomeIs;
	}
	public void setNomeIs(String nomeIs) {
		this.nomeIs = nomeIs;
	}
	@Override
	public String toString() {
		return  this.nomeIs;
	}

	
}
