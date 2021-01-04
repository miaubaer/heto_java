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
                con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ESports;user=sa;password=us3raccount;");
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