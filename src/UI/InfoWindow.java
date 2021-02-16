package UI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *  Class to show Informations to user via pop-up dialog.
 */
public class InfoWindow extends JOptionPane {
    private static final long serialVersionUID = 1L;

    public static void errorMessage(JFrame frame, String title, String message) {
        showMessageDialog(frame, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
