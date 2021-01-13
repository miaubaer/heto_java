package UI;

import java.awt.*;

import javax.swing.*;

public class DisplayEventDetails extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JTextField name;
    private JTextField location;

    public DisplayEventDetails() {
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        name = new JTextField(16);
        location = new JTextField(16);

        addRowToGrid(layout, "Name: ", name, 0);
        addRowToGrid(layout, "Ort: ", location, 1);
    }

    private void addRowToGrid(GridBagLayout gb, String name, JTextField jtf, int y) {
        JLabel l = new JLabel(name);

        GridBagConstraints gbcLabel = new GridBagConstraints();
        GridBagConstraints gbcTextField = new GridBagConstraints();
        
        gbcLabel.insets = new Insets(5, 5, 5, 5);
        gbcTextField.insets = new Insets(5, 5, 5, 5);

        gbcLabel.gridx = 0;
        gbcTextField.gridx = 1;
        gbcLabel.gridy = y;
        gbcTextField.gridy = y;
        gbcLabel.gridwidth = 1;
        gbcLabel.gridheight = 1;
        gbcTextField.gridwidth = 3;
        gbcTextField.gridheight = 1;
        gbcLabel.fill = GridBagConstraints.BOTH;
        gbcTextField.fill = GridBagConstraints.BOTH;

        gb.setConstraints(l, gbcLabel);
        gb.setConstraints(jtf, gbcTextField);

        add(l);
        add(jtf);
    }
}
