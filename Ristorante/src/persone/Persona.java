package persone;

public abstract class Persona {
	private String nome;

	public Persona(String nome) {
		super();
		this.nome = nome;
	}
	
	public abstract boolean identificati();
	
	public String getNome() {
		return nome;
	}
}
