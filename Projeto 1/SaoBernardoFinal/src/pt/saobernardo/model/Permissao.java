package pt.saobernardo.model;
public class Permissao {

	private String tipoUtilizador;
	private boolean registo;
	private boolean reclamacao;
	private boolean importacao;
	private boolean listagem;
	private boolean doacao;
	private boolean configuracao;
	
	
	public String getTipoUtilizador() {
		return tipoUtilizador;
	}
	public void setTipoUtilizador(String tipoUtilizador) {
		this.tipoUtilizador = tipoUtilizador;
	}
	public boolean isRegisto() {
		return registo;
	}
	public void setRegisto(boolean registo) {
		this.registo = registo;
	}
	public boolean isReclamacao() {
		return reclamacao;
	}
	public void setReclamacao(boolean reclamacao) {
		this.reclamacao = reclamacao;
	}
	public boolean isImportacao() {
		return importacao;
	}
	public void setImportacao(boolean importacao) {
		this.importacao = importacao;
	}
	public boolean isListagem() {
		return listagem;
	}
	public void setListagem(boolean listagem) {
		this.listagem = listagem;
	}
	public boolean isDoacao() {
		return doacao;
	}
	public void setDoacao(boolean doacao) {
		this.doacao = doacao;
	}
	public boolean isConfiguracao() {
		return configuracao;
	}
	public void setConfiguracao(boolean configuracao) {
		this.configuracao = configuracao;
	}
	
	

}
