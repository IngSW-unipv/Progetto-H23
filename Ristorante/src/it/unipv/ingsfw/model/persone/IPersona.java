package it.unipv.ingsfw.model.persone;

import java.util.ArrayList;

import it.unipv.ingsfw.model.ordine.IOrdine;
import it.unipv.ingsfw.model.ordine.Ordine;

public interface IPersona {
	public boolean identificati();
	public String getNome();
	public ArrayList<IOrdine> getOrdini();
	public void stampaOrdini();
}
