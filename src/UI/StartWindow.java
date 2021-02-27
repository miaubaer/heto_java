package UI;

import java.awt.*;

import javax.swing.*;

import java.util.List;

import java.sql.*;

import Schemas.*;

public class StartWindow extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Connection connection;
    private int width = 1280;
    private int height = 720;

    private JFrame frame;
    private ListOfEvents list;
    private DisplayEventDetails display;

    private List<GameEvent> events;

    public StartWindow(Connection connection) throws ClassNotFoundException {
        this.connection = connection;
        this.getDataFromDatabase();

        // Frame Settings
        this.frame = design("Verwaltung", width, height);
        Container c = getContentPane();
        setLayout(new BoxLayout(c, BoxLayout.X_AXIS));

        // Container Settings

        // Panels Settings
        this.display = new DisplayEventDetails(this.connection, this);
        this.list = new ListOfEvents(this.events, this.display);

        c.add(Box.createHorizontalStrut(30));
        c.add(this.list);
        c.add(Box.createHorizontalStrut(30));
        c.add(this.display);
        c.add(Box.createHorizontalStrut(30));

        this.frame.add(c);
    }

    private JFrame design(String title, int w, int h) {
        JFrame f = new JFrame(title);
        f.setSize(w, h);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        return f;
    }

    private void getDataFromDatabase() {

        try {
            this.events = Queries.getListOfEvents(connection);
        } catch (SQLException e) {
            System.out.println(e);
            Dialog.errorMessage(this, "Connection Error", "The connection between client and sql server is failed");
            System.exit(0);
        }
    }

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }
}
