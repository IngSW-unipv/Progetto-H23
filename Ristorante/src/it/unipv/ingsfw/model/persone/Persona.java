package it.unipv.ingsfw.model.persone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import it.unipv.ingsfw.model.ausiliari.Comparatore;
import it.unipv.ingsfw.model.eccezioni.NoIdentificatoException;
import it.unipv.ingsfw.model.ordine.IOrdine;
import it.unipv.ingsfw.model.ordine.Ordine;

public abstract class Persona implements IPersona{
	private String nome;
	protected ArrayList<IOrdine> ordini;
	protected boolean identificato;
	
	//stringa ausiliaria
	private String ordiniString;

	public Persona(String nome) {
		super();
		this.nome = nome;
		this.ordini=new ArrayList<IOrdine>();
		this.identificato = false;
		this.ordiniString="";
	}
	@Override
	public String getNome() {
		return nome;
	}
	
	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	@Override
	public void setIdentificato(boolean b) {
		this.identificato = b;
	}
	
	@Override
	public ArrayList<IOrdine> getOrdini() {
		return ordini;
	}
	@Override
	public void stampaOrdini() {
		for (IOrdine o: this.ordini) {
			o.stampaPiattiOrdinati();
		}

		Collections.sort(ordini, new Comparator<IOrdine>() {
			@Override
			public int compare(IOrdine o1, IOrdine o2) {
				return (int) (o1.getTempo() - o2.getTempo());
			}
		});
	}
	
	public String getStringOrdini() {
		ordiniString = "";
		for (IOrdine o: this.ordini) {
			ordiniString=ordiniString+o.getNomiPiattiOrdinati()+"\n";
		}
		return ordiniString;
	}
	
//	public void getAndPrintOrdini() {
//		for (IOrdine o: this.ordini) {
//			o.stampaPiattiOrdinati();
//		}
//		//return void;
//	}
	public void controllaPrenotazione() {
		try {
			if(identificato == false) {
				throw new NoIdentificatoException();
			}
		}
		catch(NoIdentificatoException e) {
			System.out.println(e.getMessage());
			
		}
	}
}
