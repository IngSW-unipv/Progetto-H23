package it.unipv.ingsfw.jdbc.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ingsfw.jdbc.util.ConnessioneDB;

public class DipendenteDAO implements IDipendenteDAO {
	private Connection conness;
	ArrayList<DBDipendente> dipendenti;

	public DipendenteDAO(){
		super();
		dipendenti =new ArrayList<>();
	}



	@Override
	public ArrayList<DBDipendente> selectAllDipendenti() {
		conness=ConnessioneDB.startConnection(conness);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conness.createStatement();
			String query="SELECT * from tabelleristorante.DIPENDENTI";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				DBDipendente d=new DBDipendente(rs1.getString(1));

				dipendenti.add(d);
			}
		}catch (Exception e){e.printStackTrace();}

		ConnessioneDB.closeConnection(conness);
		return dipendenti;
	}

}
