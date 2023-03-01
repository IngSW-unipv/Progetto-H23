package it.unipv.ingsfw.jdbc.bean;

public class DBDipendente {

	private String nome;

	public DBDipendente (String nome) {
		super();
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
