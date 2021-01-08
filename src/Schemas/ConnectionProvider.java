package Schemas;

import java.sql.*;

public class ConnectionProvider {
    private static Connection con;

    // tobimarker

    public static Connection getConnection() throws ClassNotFoundException
    {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try
        {
            if(con==null)
            {
                con=DriverManager.getConnection("jdbc:sqlserver://51.195.103.189:1433;user=sa;password=sqlIUBH2021;");
                //con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=sa;password=us3raccount;");
                // jdbc:sqlserver://51.195.103.189:1433;user=sa;password=sqlIUBH2021;
                // jdbc:sqlserver://51.195.103.189:1433;user=sa;password=sqlIUBH2021;
                System.out.println("Verbindung wurde aufgebaut");
            }

        }
        catch(SQLException E)
        {
            E.printStackTrace();
        }


        return con;

    }

}
