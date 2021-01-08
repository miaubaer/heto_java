package Schemas;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String teamName;
    // private int totalWins
        var ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        var fonts = ge.getAvailableFontFamilyNames();
        var list = new JList(fonts);

        list.addListSelectionListener(e -> {

            if (!e.getValueIsAdjusting()) {

                var name = (String) list.getSelectedValue();
                var font = new Font(name, Font.PLAIN, 12);

                label.setFont(font);
            }
        });

        spane = new JScrollPane();
        spane.getViewport().add(list);

        label = new JLabel("Aguirre, der Zorn Gottes");
        label.setFont(new Font("Serif", Font.PLAIN, 12));

        createLayout(spane, label);

        setTitle("JList");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    };
    // private int ranking;
    private String[] playerList; // marker evtl Game List

    // Konstruktor
    public Team(String teamName, String[] playerList) {
        this.teamName = teamName;
        this.playerList = playerList;
    }

    public String getTeamName() {
        return teamName;
    }

    public String[] getPlayerList() {
        return playerList;
    }
}
