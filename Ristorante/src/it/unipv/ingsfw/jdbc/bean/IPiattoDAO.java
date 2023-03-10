package it.unipv.ingsfw.jdbc.bean;

import java.util.ArrayList;

import it.unipv.ingsfw.model.alimenti.IPiatto;

public interface IPiattoDAO {
	public ArrayList<DBPiatto> selectAllAntipasti();
	public ArrayList<DBPiatto> selectAllBibite();
	public ArrayList<DBPiatto> selectAllDolci();
	public ArrayList<DBPiatto> selectAllPrimi();
	public ArrayList<DBPiatto> selectAllSecondi();
	public boolean insertAntipasto(DBPiatto p);
	public boolean insertBibita(DBPiatto p);
	public boolean insertDolce(DBPiatto p);
	public boolean insertPrimo(DBPiatto p);
	public boolean insertSecondo(DBPiatto p);
	public boolean updateQuantita(IPiatto p, int quantita);
}
