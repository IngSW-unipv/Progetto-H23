package it.unipv.ingsfw.jdbc.bean;

public class DBPiatto {
	private String nome;
	int quantita;
	double prezzo;
	
	public DBPiatto(String nome, int quantita, double prezzo) {
		super();
		this.nome = nome;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		return "Piatto ("+nome+", "+quantita+", "+prezzo+")";
	}
}
