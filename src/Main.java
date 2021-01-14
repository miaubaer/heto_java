import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import UI.StartWindow;
import Schemas.*;

// Connection add to this file. (H)
// @T Do not change the folder structure please. (H)
// @T Look above how to import a class from a package. (H)

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
