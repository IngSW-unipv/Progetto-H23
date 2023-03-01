package it.unipv.ingsfw.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDB {

    private static String username="root";    //inserire utente che lavora su mysql
    private static String password="psw-mysql";    //inserire password per accedere al proprio mysql
    private static String dbURL;

    public static Connection startConnection(Connection conn)
    {

        if ( isOpen(conn) )
            closeConnection(conn);

        try 
        {
            dbURL="jdbc:mysql://localhost:3306/?&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(dbURL, username, password);

        }
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }
        return conn;
    }

    public static boolean isOpen(Connection conn)
    {
        if (conn == null)
            return false;
        else
            return true;
    }

    public static Connection closeConnection(Connection conn)
    {
        if ( !isOpen(conn) )
            return null;
        try 
        {
            conn.close();
            conn = null;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return null;
        }
        return conn;
    }
}