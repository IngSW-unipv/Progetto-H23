package it.unipv.ingsfw.model.persone;

import java.io.IOException;
import java.util.ArrayList;

import it.unipv.ingsfw.model.ordine.IOrdine;
import it.unipv.ingsfw.model.ordine.Ordine;
import it.unipv.ingsfw.model.ristorante.Ristorante;

public interface IPersona {
	
	public String getNome();
	public void setNome(String nome);
	public ArrayList<IOrdine> getOrdini();
	public void stampaOrdini();
	public void setIdentificato(boolean b);
	int getSizeOfOrdini();
}
