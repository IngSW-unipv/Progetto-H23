package it.unipv.ingsfw.jdbc.bean;

import java.util.ArrayList;

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
	boolean insertAllPiatti(ArrayList<DBPiatto> p);
}
