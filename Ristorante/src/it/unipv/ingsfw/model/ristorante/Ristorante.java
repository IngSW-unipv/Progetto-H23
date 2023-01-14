package it.unipv.ingsfw.model.ristorante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.unipv.ingsfw.model.eccezioni.NoPostiException;
import it.unipv.ingsfw.model.persone.*;

public class Ristorante {
	public final int NUMERO_POSTI=500;
	private int postiLiberi;
	private ArrayList<Cliente> clienti;
	private ArrayList<Dipendente> dipendenti;
	private String nome,password;
	private Map<String,Integer> prenotazioni;
	
	public Ristorante(String nome, String password) {
		super();
		this.dipendenti = new ArrayList<>();
		this.clienti = new ArrayList<>();
		this.nome = nome;
		this.password = password;
		prenotazioni=new HashMap<String,Integer>();
		postiLiberi=NUMERO_POSTI;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void creaDipendente(String nome) {
		Dipendente d=new Dipendente(nome, this);
		dipendenti.add(d);
	}
	
	/* 
	 * Questo metodo effettua la prenotazione fornendo il nome e il numero di clienti
	 */
	public boolean prenotaCliente(Cliente c, int posti) {		
		try {
			prenotazioni.put(c.getNome(), posti);
			
			if(postiLiberi-posti<0) {
				throw new NoPostiException();
			}
			
			postiLiberi=postiLiberi-posti;
			clienti.add(c);
			return true;
		}
		catch(NoPostiException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public ArrayList<Cliente> getClienti () {
		return clienti;
	}

	public ArrayList<Dipendente> getDipendenti() {
		return dipendenti;
	}

	public Map<String, Integer> getPrenotazioni() {
		return prenotazioni;
	}

	public int getPostiLiberi() {
		return postiLiberi;
	}

	public String getNome() {
		return nome;
	}
	
}
