package it.unipv.ingsfw.jdbc.bean;

import java.util.ArrayList;
import java.util.Map;

public interface IPrenotazioneDAO {
	public Map<String,Integer> selectAllPrenotazioni();
	public boolean insertPrenotazione(String nome, int posti);
	public boolean deletePrenotazione(String nome);
	public ArrayList<String> selectAllNomiPrenotazioni();
}
