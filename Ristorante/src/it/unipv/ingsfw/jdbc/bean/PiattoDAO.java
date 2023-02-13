package it.unipv.ingsfw.jdbc.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ingsfw.jdbc.util.ConnessioneDB;

public class PiattoDAO implements IPiattoDAO{
	private Connection conness;
	ArrayList<DBPiatto> piatti;

	public PiattoDAO(){
		super();
		piatti=new ArrayList<>();
	}
	
	@Override
	public ArrayList<DBPiatto> selectAllAntipasti(){

		conness=ConnessioneDB.startConnection(conness);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conness.createStatement();
			String query="SELECT * from tabelleristorante.ANTIPASTI";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				DBPiatto p=new DBPiatto(rs1.getString(1), rs1.getInt(2),rs1.getDouble(3));
				piatti.add(p);
			}
		}catch (Exception e){e.printStackTrace();}

		ConnessioneDB.closeConnection(conness);
		return piatti;
	}
	
	@Override
	public ArrayList<DBPiatto> selectAllBibite(){

		conness=ConnessioneDB.startConnection(conness);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conness.createStatement();
			String query="SELECT * from tabelleristorante.BIBITE";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				DBPiatto p=new DBPiatto(rs1.getString(1), rs1.getInt(2),rs1.getDouble(3));

				piatti.add(p);
			}
		}catch (Exception e){e.printStackTrace();}

		ConnessioneDB.closeConnection(conness);
		return piatti;
	}
	
	@Override
	public ArrayList<DBPiatto> selectAllDolci(){

		conness=ConnessioneDB.startConnection(conness);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conness.createStatement();
			String query="SELECT * from tabelleristorante.DOLCI";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				DBPiatto p=new DBPiatto(rs1.getString(1), rs1.getInt(2),rs1.getDouble(3));

				piatti.add(p);
			}
		}catch (Exception e){e.printStackTrace();}

		ConnessioneDB.closeConnection(conness);
		return piatti;
	}
	
	@Override
	public ArrayList<DBPiatto> selectAllPrimi(){

		conness=ConnessioneDB.startConnection(conness);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conness.createStatement();
			String query="SELECT * from tabelleristorante.PRIMI";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				DBPiatto p=new DBPiatto(rs1.getString(1), rs1.getInt(2),rs1.getDouble(3));

				piatti.add(p);
			}
		}catch (Exception e){e.printStackTrace();}

		ConnessioneDB.closeConnection(conness);
		return piatti;
	}
	
	@Override
	public ArrayList<DBPiatto> selectAllSecondi(){

		conness=ConnessioneDB.startConnection(conness);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conness.createStatement();
			String query="SELECT * from tabelleristorante.SECONDI";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				DBPiatto p=new DBPiatto(rs1.getString(1), rs1.getInt(2),rs1.getDouble(3));

				piatti.add(p);
			}
		}catch (Exception e){e.printStackTrace();}

		ConnessioneDB.closeConnection(conness);
		return piatti;
	}
	
	@Override
	public boolean insertAntipasto(DBPiatto p) {

		conness=ConnessioneDB.startConnection(conness);
		PreparedStatement st1;

		boolean es=true;

		try
		{
			String query="tabelleristorante.ANTIPASTI (NOME,QUANTITA,PREZZO) VALUES(?,?,?)";
			st1 = conness.prepareStatement(query);
			st1.setString(1, p.getNome());
			st1.setInt(2,p.getQuantita());
			st1.setDouble(3,p.getPrezzo());

			st1.executeUpdate(query);

		}catch (Exception e){
			e.printStackTrace();
			es=false;
		}

		ConnessioneDB.closeConnection(conness);
		return es;
	}
	
	@Override
	public boolean insertBibita(DBPiatto p) {

		conness=ConnessioneDB.startConnection(conness);
		PreparedStatement st1;

		boolean es=true;

		try
		{
			String query="tabelleristorante.BIBITE (NOME,QUANTITA,PREZZO) VALUES(?,?,?)";
			st1 = conness.prepareStatement(query);
			st1.setString(1, p.getNome());
			st1.setInt(2,p.getQuantita());
			st1.setDouble(3,p.getPrezzo());

			st1.executeUpdate(query);

		}catch (Exception e){
			e.printStackTrace();
			es=false;
		}

		ConnessioneDB.closeConnection(conness);
		return es;
	}
	
	@Override
	public boolean insertDolce(DBPiatto p) {

		conness=ConnessioneDB.startConnection(conness);
		PreparedStatement st1;

		boolean es=true;

		try
		{
			String query="tabelleristorante.DOLCI (NOME,QUANTITA,PREZZO) VALUES(?,?,?)";
			st1 = conness.prepareStatement(query);
			st1.setString(1, p.getNome());
			st1.setInt(2,p.getQuantita());
			st1.setDouble(3,p.getPrezzo());

			st1.executeUpdate(query);

		}catch (Exception e){
			e.printStackTrace();
			es=false;
		}

		ConnessioneDB.closeConnection(conness);
		return es;
	}
	
	@Override
	public boolean insertPrimo(DBPiatto p) {

		conness=ConnessioneDB.startConnection(conness);
		PreparedStatement st1;

		boolean es=true;

		try
		{
			String query="tabelleristorante.PRIMI (NOME,QUANTITA,PREZZO) VALUES(?,?,?)";
			st1 = conness.prepareStatement(query);
			st1.setString(1, p.getNome());
			st1.setInt(2,p.getQuantita());
			st1.setDouble(3,p.getPrezzo());

			st1.executeUpdate(query);

		}catch (Exception e){
			e.printStackTrace();
			es=false;
		}

		ConnessioneDB.closeConnection(conness);
		return es;
	}
	
	@Override
	public boolean insertSecondo(DBPiatto p) {

		conness=ConnessioneDB.startConnection(conness);
		PreparedStatement st1;

		boolean es=true;

		try
		{
			String query="tabelleristorante.SECONDI (NOME,QUANTITA,PREZZO) VALUES(?,?,?)";
			st1 = conness.prepareStatement(query);
			st1.setString(1, p.getNome());
			st1.setInt(2,p.getQuantita());
			st1.setDouble(3,p.getPrezzo());

			st1.executeUpdate(query);

		}catch (Exception e){
			e.printStackTrace();
			es=false;
		}

		ConnessioneDB.closeConnection(conness);
		return es;
	}
}

