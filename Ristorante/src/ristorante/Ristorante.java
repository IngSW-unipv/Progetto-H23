package ristorante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import eccezioni.NoPostiException;
import persone.*;

public class Ristorante {
	public final int NUMERO_POSTI=500;
	private int postiLiberi;
	private ArrayList<Dipendente> dipendenti;
	private String nome,password;
	private Map<String,Integer> prenotazioni;
	
	public Ristorante(String nome, String password) {
		super();
		this.dipendenti = new ArrayList<>();
		this.nome = nome;
		this.password = password;
		prenotazioni=new HashMap<String,Integer>();
		postiLiberi=NUMERO_POSTI;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void creaDipendente(String nome) {
		Dipendente d=new Dipendente(nome);
		dipendenti.add(d);
	}
	
	public boolean prenotaCliente(Cliente c, int posti) {
		try {
			prenotazioni.put(c.getNome(), posti);
			
			if(postiLiberi-posti<0) {
				throw new NoPostiException();
			}
			
			postiLiberi=postiLiberi-posti;
			return true;
		}
		catch(NoPostiException e) {
			postiLiberi=0;
			e.stampaErrore();
			return false;
		}
	}
}
