package it.unipv.ingsfw.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.unipv.ingsfw.jdbc.bean.DBDipendente;
import it.unipv.ingsfw.jdbc.bean.DBPiatto;
import it.unipv.ingsfw.jdbc.bean.DipendenteDAO;
import it.unipv.ingsfw.jdbc.bean.IPiattoDAO;
import it.unipv.ingsfw.jdbc.bean.IPrenotazioneDAO;
import it.unipv.ingsfw.jdbc.bean.PiattoDAO;
import it.unipv.ingsfw.jdbc.bean.PrenotazioneDAO;
import it.unipv.ingsfw.model.alimenti.Antipasto;
import it.unipv.ingsfw.model.alimenti.Bibita;
import it.unipv.ingsfw.model.alimenti.Dolce;
import it.unipv.ingsfw.model.alimenti.IPiatto;
import it.unipv.ingsfw.model.alimenti.Primo;
import it.unipv.ingsfw.model.alimenti.Secondo;
import it.unipv.ingsfw.model.persone.Dipendente;
import it.unipv.ingsfw.model.ristorante.Ristorante;

public class RistoranteSingleton {

	private static RistoranteSingleton rs;
	private IPiattoDAO p;
	private IPrenotazioneDAO pr;
	private DipendenteDAO d;
	private Ristorante r;

	private RistoranteSingleton() {
		super();
		this.r= new Ristorante("NOME", "PASS");
		p= new PiattoDAO();
		pr= new PrenotazioneDAO();
		d = new DipendenteDAO();

		riempiPiatti();
		riempiPrenotazioni();
		riempiDipendenti();
	}

	public static RistoranteSingleton getSingleton() {
		if(rs==null)
		{
			rs= new RistoranteSingleton();
		}
		return rs;
	}
	
	private void riempiDipendenti() {

		ArrayList<DBDipendente> tmp = new ArrayList<>();

		tmp=d.selectAllDipendenti();
		
		for (DBDipendente d: tmp) {
			r.getDipendenti().add(new Dipendente(d.getNome()));
		}
		
		}

	private void riempiPiatti() {

		ArrayList<DBPiatto> tmp = new ArrayList<>();

		tmp=p.selectAllAntipasti();
		for(DBPiatto d:tmp) {
			IPiatto p = new Antipasto(d.getPrezzo(), d.getNome(), d.getQuantita());
			//r.getPiatti().add(new Antipasto(d.getPrezzo(), d.getNome(), d.getQuantita()));
			r.getPiatti().add(p);
		}

		tmp.clear();
		tmp=p.selectAllBibite();
		for(DBPiatto d:tmp) {
			r.getPiatti().add(new Bibita(d.getPrezzo(), d.getNome(), d.getQuantita()));
		}

		tmp.clear();
		tmp=p.selectAllDolci();
		for(DBPiatto d:tmp) {
			r.getPiatti().add(new Dolce(d.getPrezzo(), d.getNome(), d.getQuantita()));
		}

		tmp.clear();
		tmp=p.selectAllPrimi();
		for(DBPiatto d:tmp) {
			r.getPiatti().add(new Primo(d.getPrezzo(), d.getNome(), d.getQuantita()));
		}

		tmp.clear();
		tmp=p.selectAllSecondi();
		for(DBPiatto d:tmp) {
			r.getPiatti().add(new Secondo(d.getPrezzo(), d.getNome(), d.getQuantita()));
		}
	}
	


	private void riempiPrenotazioni() {
		Map<String, Integer> tmp=new HashMap<>();
		tmp=pr.selectAllPrenotazioni();
		int posti = 0;
		r.getPrenotazioni().putAll(tmp);
		for (int i : r.getPrenotazioni().values()) {
			posti = posti + i;
		}
		r.setPostiLiberi(r.getPostiLiberi() - posti);

	}

	public void cancellaPrenotazione (String nome) {
		pr.deletePrenotazione(nome);

	}


	public ArrayList<String> selezionaNomi() {
		return pr.selectAllNomiPrenotazioni();
	}
	
	public void diminuisciQuantita(IPiatto piatto, int quantita) {
		p.updateQuantita(piatto, piatto.getQuantita()- quantita);
	
		
	}
	public void aggiungiQuantita(IPiatto piatto, int quantita) {
		p.updateQuantita(piatto, quantita);
	
		
	}
	public void inserisciCliente(String nome, int posti) {
		pr.insertPrenotazione(nome, posti);
	}

	public Ristorante getRistorante() {
		return r;
	}
	

}
