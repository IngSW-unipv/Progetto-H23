package it.unipv.ingsfw.model.ristorante;

import java.util.ArrayList;
import java.util.Map;

import it.unipv.ingsfw.model.alimenti.IPiatto;
import it.unipv.ingsfw.model.persone.Cliente;
import it.unipv.ingsfw.model.persone.Dipendente;

public interface IRistorante {
	public final int NUMERO_POSTI= 100;
	public double getConto();
	public String getPassword();
	public Dipendente creaDipendente(String nome);
	public boolean prenotaCliente(Cliente c, int posti);
	public Cliente prenotaClientenoPrenotazione(int posti);
	public ArrayList<String> getArrayNomeePrezzoPiatti();
	public ArrayList<String> getArrayNomePiatti();
	public ArrayList<Integer> getArrayQuantitaPiatti();
	public ArrayList<Double> getArrayPrezzoPiatti();
	public void stampaPrenotazioni();
	public void stampaPiatti();
	public void rimuoviCliente(Cliente c);
	public void addPiatto(IPiatto p);
	public ArrayList<Cliente> getClienti();
	public void stampaClienti();
	public ArrayList<Dipendente> getDipendenti();
	public ArrayList<IPiatto> getPiatti();
	public IPiatto getElementOfPiatti(int i);
	public Map<String, Integer> getPrenotazioni();
	public int getPostiLiberi();
	public void setPostiLiberi(int n);
	public String getNome();
	public Dipendente getDipendenteByNome(String s);
	public int getSizeOfPrenotazioni();
	public void addCliente(Cliente c);
	public boolean containsKeyPrenotazioni(String s);
	public String prenotazioni();
}
