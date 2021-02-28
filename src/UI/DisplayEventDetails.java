package UI;

import java.awt.*;
import java.awt.event.*;
import java.lang.ProcessHandle.Info;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

import Schemas.GameEvent;
import Schemas.Queries;

public class DisplayEventDetails extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final SimpleDateFormat DTF = new SimpleDateFormat("yyyy-MM-dd");

    Connection connection;
    private JFrame parent;
    private boolean isEditable = false;
    private GameEvent bufferedEvent;

    private JTextField name = new JTextField(16);
    private JTextField region = new JTextField(16);
    private JTextField prizepool = new JTextField(16);
    private JTextField ratio = new JTextField(16);
    private JTextField start = new JTextField(16);
    private JTextField end = new JTextField(16);
    private JButton changeMode = new JButton("Schreibar");
    private JButton showSpectators = new JButton("Zuschauer");
    private JButton showGamePlan = new JButton("Spielplab");
    private JButton showSponsors = new JButton("Sponsoren");
    private JButton saveChanges = new JButton("Speichern");

    // taken places
    // team list
    // game list | low priority

    public DisplayEventDetails(Connection connection, JFrame parent) {
        this.connection = connection;
        this.parent = parent;

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        this.name.setEditable(false);
        this.region.setEditable(false);
        this.prizepool.setEditable(false);
        this.ratio.setEditable(false);
        this.start.setEditable(false);
        this.end.setEditable(false);
        this.saveChanges.setEnabled(isEditable);

        addLabelToGrid(layout, new JLabel("Names: "), 0, 0, 1, 1);
        addLabelToGrid(layout, new JLabel("Ort: "), 0, 1, 1, 1);
        addLabelToGrid(layout, new JLabel("Belohnung: "), 0, 2, 1, 1);
        addLabelToGrid(layout, new JLabel("Anteile: "), 0, 3, 1, 1);
        addLabelToGrid(layout, new JLabel("Beginn: "), 0, 4, 1, 1);
        addLabelToGrid(layout, new JLabel("Ende: "), 0, 5, 1, 1);

        addTextFieldToGrid(layout, this.name, 1, 0, 5, 1);
        addTextFieldToGrid(layout, this.region, 1, 1, 5, 1);
        addTextFieldToGrid(layout, this.prizepool, 1, 2, 5, 1);
        addTextFieldToGrid(layout, this.ratio, 1, 3, 5, 1);
        addTextFieldToGrid(layout, this.start, 1, 4, 5, 1);
        addTextFieldToGrid(layout, this.end, 1, 5, 5, 1);

        addButtonToGrid(layout, this.showSpectators, "spectators", 0, 6, 2, 2);
        addButtonToGrid(layout, this.showSponsors, "sponsors", 2, 6, 2, 2);
        addButtonToGrid(layout, this.showGamePlan, "plan", 4, 6, 2, 2);
        addButtonToGrid(layout, this.changeMode, "mode", 0, 8, 2, 2);
        addButtonToGrid(layout, this.saveChanges, "save", 2, 8, 4, 2);
    }

    public void setTextToFields(GameEvent ge) {
        this.bufferedEvent = ge;
        this.name.setText(ge.getName());
        this.region.setText(ge.getLocation());
        this.ratio.setText(ge.getRatio());
        this.prizepool.setText(Integer.toString(ge.getPrizepool()));
        this.start.setText(DTF.format(ge.getStartDate()));
        this.end.setText(DTF.format(ge.getEndDate()));
    }

    private GridBagConstraints setCons(int x, int y, int sx, int sy) {
        GridBagConstraints cons = new GridBagConstraints();

        cons.insets = new Insets(5, 5, 5, 5);

        cons.gridx = x;
        cons.gridy = y;
        cons.gridwidth = sx;
        cons.gridheight = sy;
        cons.fill = GridBagConstraints.BOTH;

        return cons;
    }

    // The method adds a JLAbel to Layout.
    // Parameters: (layout, JLabel, position x, position y, size of cell dimension
    // x, size if cell dimension y)
    private void addLabelToGrid(GridBagLayout layout, JLabel l, int x, int y, int sx, int sy) {
        GridBagConstraints cons = setCons(x, y, sx, sy);

        layout.setConstraints(l, cons);
        add(l);
    }

    // The method adds a JTextField to Layout.
    // Parameters: (layout, TextFiel, position x, position y, size of cell dimension
    // x, size if cell dimension y)
    private void addTextFieldToGrid(GridBagLayout layout, JTextField tf, int x, int y, int sx, int sy) {
        GridBagConstraints cons = setCons(x, y, sx, sy);

        layout.setConstraints(tf, cons);
        add(tf);
    }

    // The method adds a Button to Layout.
    // Parameters: (layout, JButton, position x, position y, size of cell dimension
    // x, size if cell dimension y)
    private void addButtonToGrid(GridBagLayout layout, JButton b, String name, int x, int y, int sx, int sy) {
        b.addActionListener(this);
        b.setName(name);
        GridBagConstraints cons = setCons(x, y, sx, sy);

        layout.setConstraints(b, cons);
        add(b);
    }

    private void toggleMode() {
        if (this.isEditable) {
            setTextToFields(this.bufferedEvent);
        }

        this.isEditable = !this.isEditable;

        this.name.setEditable(this.isEditable);
        this.region.setEditable(this.isEditable);
        this.prizepool.setEditable(this.isEditable);
        this.ratio.setEditable(this.isEditable);
        this.start.setEditable(this.isEditable);
        this.end.setEditable(this.isEditable);
        this.saveChanges.setEnabled(this.isEditable);
    }

    private void saveChanges() {
        try {
            GameEvent ne = new GameEvent(
                this.name.getText(), 
                this.region.getText(),
                Integer.parseInt(this.prizepool.getText()), 
                this.ratio.getText(),
                DTF.parse(this.start.getText()), 
                DTF.parse(this.end.getText())
            );

            Queries.updateEvent(this.connection, this.bufferedEvent.getId(), ne);

            this.bufferedEvent = ne;

            Dialog.infoMessage(
                this.parent,
                "Success", 
                "Daten sind in die Datenbank eingetragen."
            );

            toggleMode();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            
            Dialog.errorMessage(
                this.parent,
                "Formatfehler",
                "Der Format der Daten ist fehlerhaft.\nDaten werden nicht abgespeichert."
            );
        } catch (SQLException e) {
            e.printStackTrace();
            Dialog.errorMessage(
                this.parent,
                "Connection Error",
                "The connection between client and database is failed.\nData will be restored"
                );
            
            toggleMode();
        } catch (ParseException e) {
            e.printStackTrace();
            Dialog.errorMessage(
                this.parent,
                "Datumfeld(-er) enthält(-en) Fehler.",
                "Mindastens ein Dateumfeld ist fehlerhaft.\nDaten werden nicht abgespeichert."
            );
        }
    }

    private void showSpectators() {
        try {
            new PopupList(
                this.parent,
                Queries.selectAllSpectatorsByGameEventId(
                    this.connection, 
                    this.bufferedEvent.getId()),
                "Spectators", 
                1200, 
                900
            );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Dialog.errorMessage(
                this.parent,
                "Connection Problem",
                "Daten konnten nicht abgefragt werden."
            );
        }
    };

    private void showSponsors() {
        try {
            new PopupList(
                this.parent,
                Queries.selectAllSponsorsByGameEventId(
                    this.connection, 
                    this.bufferedEvent.getId()),
                "Sponsors", 
                1200, 
                900
            );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Dialog.errorMessage(
                this.parent,
                "Connection Problem",
                "Daten konnten nicht abgefragt werden."
            );
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = ((JButton) e.getSource()).getName();

        switch (name) {
            case "mode":
                toggleMode();
                break;
            case "save":
                saveChanges();
                break;
            case "spectators":
                showSpectators();
                break;
            case "sponsors":
                showSponsors();
                break;
            default:
                break;
        }
    }
}
