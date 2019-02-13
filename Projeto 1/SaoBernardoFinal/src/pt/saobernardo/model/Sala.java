package pt.saobernardo.model;
public class Sala {

	private String sala;
	
	
	public Sala(String sala) {
		super();
		this.sala = sala;
		
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	@Override
	public String toString() {
		return this.sala;
	}
	
	
}
