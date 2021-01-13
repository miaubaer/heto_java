package UI;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class StartWindow extends JFrame implements IUserInterface {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int WIDTH = 1280;
    private int HEIGHT = 720;
    
    private JFrame frame;
    private ListOfEvents list;
    private DisplayEventDetails display;

    public static Connection getConnection(Connection con) throws ClassNotFoundException
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









    public StartWindow() {
        // Frame Settings
        this.frame = design("Verwaltung", WIDTH, HEIGHT);
        Container c = getContentPane();
        setLayout(new BoxLayout(c, BoxLayout.X_AXIS));

        // Container Settings

        // Panels Settings
        this.display = new DisplayEventDetails();
        this.list = new ListOfEvents(this.display);

        c.add(Box.createHorizontalStrut(30));

        c.add(this.list);

        c.add(Box.createHorizontalStrut(30));
        
        c.add(this.display);

        c.add(Box.createHorizontalStrut(30));

        System.out.println("Hello From StartWindow");

        this.frame.add(c);
        // this.frame.setVisible(true);
    }

    @Override
    public void show() {
        frame.setVisible(true);
    }

    @Override
    public void hide() {
        frame.setVisible(false);
    }
}
