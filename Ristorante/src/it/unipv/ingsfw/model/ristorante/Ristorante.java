package it.unipv.ingsfw.model.ristorante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.unipv.ingsfw.model.alimenti.IPiatto;
import it.unipv.ingsfw.model.eccezioni.NameAlreadyExistsException;
import it.unipv.ingsfw.model.eccezioni.NoPostiException;
import it.unipv.ingsfw.model.persone.*;

public class Ristorante implements IRistorante{
	public final int NUMERO_POSTI= 100;
	private int postiLiberi;
	private int progressivo;
	private ArrayList<Cliente> clienti;
	private ArrayList<Dipendente> dipendenti;
	private ArrayList<IPiatto> tuttiPiatti;
	private String nome,password;
	private Map<String,Integer> prenotazioni;
	private double conto;

	public Ristorante(String nome, String password) {
		super();
		this.dipendenti = new ArrayList<>();
		this.clienti = new ArrayList<>();
		this.tuttiPiatti = new ArrayList<>();
		this.nome = nome;
		this.password = password;
		prenotazioni=new HashMap<String,Integer>();
		postiLiberi=NUMERO_POSTI;
		conto = 22.90;
		progressivo = 1;
	}
	@Override
	public double getConto() {
		return conto;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public Dipendente creaDipendente(String nome) {
		Dipendente d=new Dipendente(nome);
		dipendenti.add(d);
		return d;
	}

	/* 
	 * Questo metodo effettua la prenotazione fornendo il nome e il numero di clienti
	 */
	@Override
	public boolean prenotaCliente(Cliente c, int posti) {		
		try {
			//if(posti<1) 
			//throw new
			if(postiLiberi-posti<0) {
				throw new NoPostiException();
			}
			if(prenotazioni.containsKey(c.getNome())) {
				throw new NameAlreadyExistsException();
			}
			
			prenotazioni.put(c.getNome(), posti);

			postiLiberi=postiLiberi-posti;
			clienti.add(c);
			return true;
		}
		catch(NoPostiException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		catch(NameAlreadyExistsException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	@Override
	public Cliente prenotaClientenoPrenotazione (int posti) {
		Cliente c = null;
		try {

			if(postiLiberi-posti<0) {
				throw new NoPostiException();
			}
			c = new Cliente("Tavolo " + progressivo);
			progressivo++;
			c.setIdentificato(true);
			postiLiberi=postiLiberi-posti;
			prenotazioni.put(c.getNome(), posti);
			clienti.add(c);
		}
		catch(NoPostiException e) {
			System.out.println(e.getMessage());
		}
		return c;
	}
	
	@Override
	public ArrayList<String> getArrayNomeePrezzoPiatti(){
		ArrayList<String> tmp=new ArrayList();
		for(IPiatto p: tuttiPiatti)
		{
			tmp.add(p.getNome()+ "  " + p.getPrezzo()+"€");
		}
		return tmp;
	}

	@Override
	public ArrayList<String> getArrayNomePiatti(){
		ArrayList<String> tmp=new ArrayList();
		for(IPiatto p: tuttiPiatti)
		{
			tmp.add("Nome: "+p.getNome());
		}
		return tmp;
	}
	@Override
	public ArrayList<Integer> getArrayQuantitaPiatti(){
		ArrayList<Integer> tmp=new ArrayList();
		for(IPiatto p: tuttiPiatti)
		{
			tmp.add(p.getQuantita());
		}
		return tmp;
	}
	@Override
	public ArrayList<Double> getArrayPrezzoPiatti(){
		ArrayList<Double> tmp=new ArrayList<>();
		for(IPiatto p: tuttiPiatti)
		{
			tmp.add(p.getPrezzo());
		}
		return tmp;
	}
	@Override
	public void stampaPrenotazioni() {

		for (Map.Entry <String,Integer> entry : prenotazioni.entrySet()) {
			  String key = entry.getKey();
			  int value = entry.getValue();
			  System.out.println(key+" "+value);
			}
	}
	@Override
	public void stampaPiatti() {
		for(IPiatto p:tuttiPiatti) {
			System.out.println(p.getNome()+" "+p.getPrezzo()+" "+p.getQuantita());
		}
	}
	@Override
	public void rimuoviCliente(Cliente c) {
		setPostiLiberi(prenotazioni.get(c.getNome()) + postiLiberi);
		prenotazioni.remove(c.getNome());
		clienti.remove(c);
		c.setIdentificato(false);
	}
	@Override
	public void addPiatto(IPiatto p) {
		tuttiPiatti.add(p);
	}
	@Override
	public ArrayList<Cliente> getClienti () {
		return clienti;
	}
	@Override
	public void stampaClienti () {
		for (Cliente c: clienti) {
			System.out.println(c.getNome());
		}
	}
	@Override
	public ArrayList<Dipendente> getDipendenti() {
		return dipendenti;
	}
	@Override
	public ArrayList<IPiatto> getPiatti() {
		return tuttiPiatti;
	}
	@Override
	public IPiatto getElementOfPiatti(int i) {
		return tuttiPiatti.get(i);
	}
	@Override
	public Map<String, Integer> getPrenotazioni() {
		return prenotazioni;
	}
	@Override
	public int getPostiLiberi() {
		return postiLiberi;
	}
	@Override
	public void setPostiLiberi(int n) {
		postiLiberi = n;
	}
	@Override
	public String getNome() {
		return nome;
	}
	@Override
	public Dipendente getDipendenteByNome(String s) {
		for(Dipendente d:dipendenti)
		{
			if(d.getNome().equals(s)) {
				return d;
			}
		}
		return null;
	}
}