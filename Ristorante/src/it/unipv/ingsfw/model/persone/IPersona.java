package it.unipv.ingsfw.model.persone;

import java.util.ArrayList;

import it.unipv.ingsfw.model.ordine.IOrdine;

public interface IPersona {

	public String getNome();
	public void setNome(String nome);
	public ArrayList<IOrdine> getOrdini();
	public void stampaOrdini();
	public void setIdentificato(boolean b);
	int getSizeOfOrdini();
}
