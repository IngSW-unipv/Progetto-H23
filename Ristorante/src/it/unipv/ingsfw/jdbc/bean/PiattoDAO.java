package it.unipv.ingsfw.jdbc.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ingsfw.jdbc.util.ConnessioneDB;
import it.unipv.ingsfw.model.alimenti.IPiatto;

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
			String query="INSERT INTO tabelleristorante.ANTIPASTI (NOME,QUANTITA,PREZZO) VALUES(?,?,?)";
			st1 = conness.prepareStatement(query);
			st1.setString(1, p.getNome());
			st1.setInt(2,p.getQuantita());
			st1.setDouble(3,p.getPrezzo());

			//st1.executeQuery(query);
			st1.executeUpdate();
			//st1.execute();

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
			String query="INSERT INTO tabelleristorante.BIBITE (NOME,QUANTITA,PREZZO) VALUES(?,?,?)";
			st1 = conness.prepareStatement(query);
			st1.setString(1, p.getNome());
			st1.setInt(2,p.getQuantita());
			st1.setDouble(3,p.getPrezzo());

			//st1.executeQuery(query);
			st1.executeUpdate();
			//st1.execute();

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
			String query="INSERT INTO tabelleristorante.DOLCI (NOME,QUANTITA,PREZZO) VALUES(?,?,?)";
			st1 = conness.prepareStatement(query);
			st1.setString(1, p.getNome());
			st1.setInt(2,p.getQuantita());
			st1.setDouble(3,p.getPrezzo());

			//st1.executeQuery(query);
			st1.executeUpdate();
			//st1.execute();

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
			String query="INSERT INTO tabelleristorante.PRIMI (NOME,QUANTITA,PREZZO) VALUES(?,?,?)";
			st1 = conness.prepareStatement(query);
			st1.setString(1, p.getNome());
			st1.setInt(2,p.getQuantita());
			st1.setDouble(3,p.getPrezzo());


			st1.executeUpdate();

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
			String query="INSERT INTO tabelleristorante.SECONDI (NOME,QUANTITA,PREZZO) VALUES(?,?,?)";
			st1 = conness.prepareStatement(query);
			st1.setString(1, p.getNome());
			st1.setInt(2,p.getQuantita());
			st1.setDouble(3,p.getPrezzo());


			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			es=false;
		}

		ConnessioneDB.closeConnection(conness);
		return es;
	}

	@ Override
	public boolean updateQuantita(IPiatto p, int quantita) {

		conness=ConnessioneDB.startConnection(conness);
		PreparedStatement st1;

		boolean es=true;

		try
		{
			switch(p.getTipo()) {
			case ANTIPASTO:
				st1 = conness.prepareStatement("UPDATE tabelleristorante.ANTIPASTI SET QUANTITA = ? WHERE NOME = ?");
				st1.setInt(1, quantita);
				st1.setString(2, p.getNome());
				st1.executeUpdate();
				break;
			case BIBITA:
				st1 = conness.prepareStatement("UPDATE tabelleristorante.BIBITE SET QUANTITA = ? WHERE NOME = ?");
				st1.setInt(1, quantita);
				st1.setString(2, p.getNome());
				st1.executeUpdate();
				break;
			case DOLCE:
				st1 = conness.prepareStatement("UPDATE tabelleristorante.DOLCI SET QUANTITA = ? WHERE NOME = ?");
				st1.setInt(1, quantita);
				st1.setString(2, p.getNome());
				st1.executeUpdate();
				break;
			case PRIMO:
				st1 = conness.prepareStatement("UPDATE tabelleristorante.PRIMI SET QUANTITA = ? WHERE NOME = ?");
				st1.setInt(1, quantita);
				st1.setString(2, p.getNome());
				st1.executeUpdate();
				break;
			case SECONDO:
				st1 = conness.prepareStatement("UPDATE tabelleristorante.SECONDI SET QUANTITA = ? WHERE NOME = ?");
				st1.setInt(1, quantita);
				st1.setString(2, p.getNome());
				st1.executeUpdate();
				break;
			}


		}catch (Exception e){
			e.printStackTrace();
			es=false;
		}

		ConnessioneDB.closeConnection(conness);
		return es;
	}
}





