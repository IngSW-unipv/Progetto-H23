package it.unipv.ingsfw.jdbc.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.unipv.ingsfw.jdbc.util.ConnessioneDB;

public class PrenotazioneDAO implements IPrenotazioneDAO{
	private Connection conness;
	Map<String,Integer> prenotaz;

	public PrenotazioneDAO(){
		super();
		prenotaz=new HashMap<>();
	}

	@Override
	public Map<String,Integer> selectAllPrenotazioni(){

		conness=ConnessioneDB.startConnection(conness);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conness.createStatement();
			String query="SELECT * from tabelleristorante.PRENOTAZIONI";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				//DBPrenotazione p=new DBPrenotazione(rs1.getString(1), rs1.getInt(2));
				prenotaz.put(rs1.getString(1), rs1.getInt(2));
			}
		}catch (Exception e){e.printStackTrace();}

		ConnessioneDB.closeConnection(conness);
		return prenotaz;
	}

	@Override
	public boolean insertPrenotazione(String nome, int posti) {

		conness=ConnessioneDB.startConnection(conness);
		PreparedStatement st1;

		boolean es=true;

		try
		{
			st1 = conness.prepareStatement("INSERT INTO tabelleristorante.PRENOTAZIONI (NOME_CLIENTE,NUMERO_PERSONE) VALUES(?,?)");
			st1.setString(1, nome);
			st1.setInt(2,posti);

			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			es=false;
		}

		ConnessioneDB.closeConnection(conness);
		return es;
	}
	public boolean deletePrenotazione(String nome) {

		conness=ConnessioneDB.startConnection(conness);
		PreparedStatement st1;

		boolean es=true;

		try
		{

			st1 = conness.prepareStatement("DELETE FROM tabelleristorante.PRENOTAZIONI WHERE tabelleristorante.PRENOTAZIONI.NOME_CLIENTE = ?;");
			st1.setString(1, nome);
			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			es=false;
		}

		ConnessioneDB.closeConnection(conness);
		return es;
	}
	@Override
	public ArrayList<String> selectAllNomiPrenotazioni(){
		ArrayList<String> nomiclienti=new ArrayList<>();
		conness=ConnessioneDB.startConnection(conness);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conness.createStatement();
			String query="SELECT NOME_CLIENTE from tabelleristorante.PRENOTAZIONI";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				nomiclienti.add(rs1.getString(1));
			}
		}catch (Exception e){e.printStackTrace();}

		ConnessioneDB.closeConnection(conness);
		return nomiclienti;
	}
}
