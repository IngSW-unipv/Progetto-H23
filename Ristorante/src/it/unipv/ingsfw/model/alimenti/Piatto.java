package it.unipv.ingsfw.model.alimenti;

public abstract class Piatto implements IPiatto{
	private double prezzo;
	private String nome;
	private int quantita;
	protected TipoPiatto tipo;


	public Piatto(double prezzo, String nome, int quantita) {
		super();
		this.prezzo = prezzo;
		this.nome = nome;
		this.quantita = quantita;
	}
	public TipoPiatto getTipo() {
		return tipo;
	}

	@Override
	public int getQuantita() {
		return quantita;
	}
	@Override
	public void setQuantita(int quantita) {
		this.quantita=quantita;
	}
	@Override
	public void incrementaQuantita(int quantita) {
		int q=this.getQuantita();
		this.setQuantita(q+quantita);
	}
	@Override
	public double getPrezzo() {
		return prezzo;
	}
	@Override
	public String getNome() {
		return nome;
	}
	@ Override
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	@ Override
	public void setNome(String nome) {
		this.nome = nome;
	}

}
