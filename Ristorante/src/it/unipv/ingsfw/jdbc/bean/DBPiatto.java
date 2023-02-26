package it.unipv.ingsfw.jdbc.bean;

import it.unipv.ingsfw.model.alimenti.TipoPiatto;

public class DBPiatto {
	private String nome;
	int quantita;
	double prezzo;
	private TipoPiatto tp;
	
	public DBPiatto(String nome, int quantita, double prezzo) {
		super();
		this.nome = nome;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}

	public TipoPiatto getTp() {
		return tp;
	}

	public void setTp(TipoPiatto tp) {
		this.tp = tp;
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
