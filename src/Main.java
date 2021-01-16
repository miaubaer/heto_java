import java.sql.*;
import java.util.Scanner;

import UI.StartWindow;

public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://51.195.103.189:1433;user=sa;password=sqlIUBH2021;");

            StartWindow win = new StartWindow(connection.createStatement());
            win.show();
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
