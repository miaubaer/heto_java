package UI;

import java.awt.*;

import javax.swing.*;

public class DisplayEventDetails extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JTextField name = new JTextField(16);
    private JTextField region = new JTextField(16);
    private JTextField prizePool = new JTextField(16);
    private JTextField ratio = new JTextField(16);
    // taken places
    // team list
    // game list | low priority

    public DisplayEventDetails() {
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        this.name.setEditable(false);
        this.region.setEditable(false);
        this.prizePool.setEditable(false);
        this.ratio.setEditable(false);

        addLabelToGrid(layout, new JLabel("Names: "), 0, 0, 1, 1);
        addLabelToGrid(layout, new JLabel("Ort: "), 0, 1, 1, 1);
        addLabelToGrid(layout, new JLabel("Belohnung: "), 0, 2, 1, 1);
        addLabelToGrid(layout, new JLabel("Anteile: "), 0, 3, 1, 1);

        addTextFieldToGrid(layout, this.name, 1, 0, 5, 1);
        addTextFieldToGrid(layout, this.region, 1, 1, 5, 1);
        addTextFieldToGrid(layout, this.prizePool, 1, 2, 5, 1);
        addTextFieldToGrid(layout, this.ratio, 1, 3, 5, 1);
    }

    public String getName() {
        return this.name.getText();
    }
    public void setName(String name) {
        this.name.setText(name);
    }

    public String getRegion() {
        return this.region.getText();
    }
    public void setRegion(String region) {
        this.region.setText(region);
    }

    public String getRatio() {
        return this.ratio.getText();
    }
    public void setRatio(String ratio) {
        this.ratio.setText(ratio);
    }

    public String getPrizePool() {
        return this.prizePool.getText();
    }
    public void setPrizePool(String prizePool) {
        this.prizePool.setText(prizePool);
    }


    // The method adds a JLAbel to Layout.
    // Parameters: (layout, JLabel, position x, position y, size of cell dimension x, size if cell dimension y)
    private void addLabelToGrid(GridBagLayout layout, JLabel l, int x, int y, int sx, int sy) {
        GridBagConstraints cons = new GridBagConstraints();

        cons.insets = new Insets(5, 5, 5, 5);

        cons.gridx = x;
        cons.gridy = y;
        cons.gridwidth = sx;
        cons.gridheight = sy;
        cons.fill = GridBagConstraints.BOTH;

        layout.setConstraints(l, cons);
        add(l);
    }

    // The method adds a JTextField to Layout.
    // Parameters: (layout, TextFiel, position x, position y, size of cell dimension x, size if cell dimension y)
    private void addTextFieldToGrid(GridBagLayout layout, JTextField tf, int x, int y, int sx, int sy) {
        GridBagConstraints cons = new GridBagConstraints();

        cons.insets = new Insets(5, 5, 5, 5);

        cons.gridx = x;
        cons.gridy = y;
        cons.gridwidth = sx;
        cons.gridheight = sy;
        cons.fill = GridBagConstraints.BOTH;

        layout.setConstraints(tf, cons);
        add(tf);
    }
}
