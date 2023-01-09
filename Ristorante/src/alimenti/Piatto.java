package alimenti;

public abstract class Piatto {
	private double prezzo;
	private String nome;
	private int quantita;
	
	public Piatto(double prezzo, String nome, int quantita) {
		super();
		this.prezzo = prezzo;
		this.nome = nome;
		this.quantita = quantita;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setQuantita(int quantita) {
		this.quantita=quantita;
	}
	
	public void incrementaQuantita(int quantita) {
		int q=this.getQuantita();
		this.setQuantita(q+quantita);
	}
	
	public double getPrezzo() {
		return prezzo;
	}
}
