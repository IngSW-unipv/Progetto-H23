package it.unipv.ingsfw.model.alimenti;

public interface IPiatto {

	public int getQuantita();
	public void setQuantita(int quantita);
	public void incrementaQuantita(int quantita);
	public double getPrezzo();
	public String getNome();
	public void setPrezzo(double prezzo);
	public void setNome(String nome);
	public TipoPiatto getTipo();
}
