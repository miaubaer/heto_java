import java.sql.*;

import UI.StartWindow;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://51.195.103.189:1433;user=sa;password=sqlIUBH2021;");

            StartWindow win = new StartWindow(connection);
            win.show();
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
