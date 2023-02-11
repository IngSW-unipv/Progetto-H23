package it.unipv.ingsfw.jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class scriviDB {

    private String f;
    private Connection conn;

    public scriviDB() {
        super();
    }
    public void fai()
    {
        conn=ConnessioneDB.startConnection(conn);
        Statement st1;
        ResultSet rs1;

        try
        {
            st1 = conn.createStatement();

            String query="SELECT * from tabelleristorante.PIATTI";        //query per prendere i piatti
            //String query="SELECT * from tabelleristorante.PRENOTAZIONI";
            rs1=st1.executeQuery(query);

            while(rs1.next())
            {
                f = rs1.getString(1)+" "+ rs1.getString(2)+" "+rs1.getString(3);
                //f=rs1.getString(1)+" "+ rs1.getString(2);
                System.out.println(f);

            }
        }catch (Exception e){e.printStackTrace();}

        ConnessioneDB.closeConnection(conn);
    }
   
}

