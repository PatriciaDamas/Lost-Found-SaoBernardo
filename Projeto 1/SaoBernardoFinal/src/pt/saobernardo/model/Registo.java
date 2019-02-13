package pt.saobernardo.model;

public class Registo {
	
	
	private int codigo;// codigo ordem do objeto inserido
	private String nome;
	private String cor;
	private String email;
	private String descricao;
	private String estado;
	private String data;
	private String hora;
	private Sala s;
	private ObjetoPerdido o;
	

	public Registo(int codigo,String nome, String email, Sala sala,  String data, String hora, String cor, String estado,
			String descricao, 
			ObjetoPerdido objeto) {
		super();
		
		this.codigo = codigo;
		this.nome = nome;
		this.cor = cor;
		this.email = email;
		this.descricao = descricao;
		this.estado = estado;
		this.data = data;
		this.hora = hora;
		this.s = sala;
		this.o = objeto;
				
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

	public Sala getS() {
		return s;
	}

	public void setS(Sala s) {
		this.s = s;
	}

	public ObjetoPerdido getO() {
		return o;
	}

	public void setO(ObjetoPerdido o) {
		this.o = o;
	}


	@Override
	public String toString() {
		return "Registo [codigo=" + codigo + ", nome=" + nome + ", cor=" + cor
				+ ", email=" + email + ", descricao=" + descricao + ", estado="
				+ estado + ", data=" + data + ", hora=" + hora + ", s=" + s
				+ ", o=" + o + "]";
	}

	
	
	
	
	
	
	

}
