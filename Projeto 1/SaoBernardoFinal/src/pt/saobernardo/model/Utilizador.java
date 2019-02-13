package pt.saobernardo.model;

public class Utilizador {

	
	private String nomeLogin; // nome para o login
	private String password;
	private String nome; //nome para o qual pertence a conta 
	private Permissao u;
	
	
	public Utilizador(String nomeLogin, String password, String nome)
			 {
		super();
		this.password = password;
		this.nomeLogin = nomeLogin;
		this.nome = nome;
		
	}
	
	
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNomeLogin() {
		return nomeLogin;
	}
	public void setNomeLogin(String nomeLogin) {
		this.nomeLogin = nomeLogin;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Permissao getU() {
		return u;
	}
	public void setU(Permissao u) {
		this.u = u;
	}
	

}
