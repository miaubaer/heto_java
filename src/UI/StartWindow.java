package UI;

import java.awt.*;
import javax.swing.*;

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
