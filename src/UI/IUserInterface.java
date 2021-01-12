package UI;

import javax.swing.JFrame;

public interface IUserInterface {
    public void show();

    public void hide();

    public default JFrame design(String title, int w, int h) {
        JFrame f = new JFrame(title);
        f.setSize(w, h);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        return f;
    }
}
