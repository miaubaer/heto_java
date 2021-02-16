package UI;

import java.awt.*;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.sql.*;

import Schemas.*;

public class StartWindow extends JFrame implements IUserInterface {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Statement statement;
    private int WIDTH = 1280;
    private int HEIGHT = 720;

    private JFrame frame;
    private ListOfEvents list;
    private DisplayEventDetails display;

    private List<GameEvent> events;

    public StartWindow(Statement statement) throws ClassNotFoundException {
        this.statement = statement;
        this.getDataFromDatabase();

        // Frame Settings
        this.frame = design("Verwaltung", WIDTH, HEIGHT);
        Container c = getContentPane();
        setLayout(new BoxLayout(c, BoxLayout.X_AXIS));

        // Container Settings

        // Panels Settings
        this.display = new DisplayEventDetails();
        this.list = new ListOfEvents(this.events, this.display);

        c.add(Box.createHorizontalStrut(30));
        c.add(this.list);
        c.add(Box.createHorizontalStrut(30));
        c.add(this.display);
        c.add(Box.createHorizontalStrut(30));

        this.frame.add(c);
    }

    @Override
    public void show() {
        frame.setVisible(true);
    }

    @Override
    public void hide() {
        frame.setVisible(false);
    }

    @Override
    public void getDataFromDatabase() {
        String query = "SELECT name, region, prize, first_place_prize, second_place_prize, third_place_prize, start_date, end_date FROM ESports.dbo.GameEvent";

        try {
            ResultSet result = this.statement.executeQuery(query);
            List<GameEvent> events = new ArrayList<GameEvent>();

            while (result.next()) {
                String name = result.getString("name");
                String region = result.getString("region");
                double prize = result.getDouble("prize");
                double[] ratio = {
                    result.getDouble("first_place_prize"),
                    result.getDouble("second_place_prize"),
                    result.getDouble("third_place_prize")
                };
                Date start = result.getDate("start_date");
                Date end = result.getDate("end_date");

                events.add(new GameEvent(
                    name,
                    region,
                    prize,
                    ratio,
                    start,
                    end  
                ));
            }

            this.events = events;
        } catch (SQLException e) {
            System.out.println(e);
            InfoWindow.errorMessage(this, "Connection Error", "The connection between client ans sql server is failed");
            System.exit(0);
        }
    }
}
