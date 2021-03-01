package UI;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

public class PopupList {

    private JList<String> list;
    private JDialog frame;

    public PopupList(JFrame parent, List<String> list, String title, int w, int h) {
        this.list = new JList<String>(ListToArray(list));

        this.frame = new JDialog(parent, title, true);

        this.list.setVisible(true);
        this.list.setEnabled(false);

        JScrollPane p = new JScrollPane(this.list);

        this.frame.setSize(w, h);
        this.frame.setResizable(false);
        this.frame.setLayout(new BorderLayout());
        this.frame.add(p, BorderLayout.CENTER);
        this.frame.setVisible(true);
    }

    private String[] ListToArray(List<String> list) {
        String[] res = new String[list.size()];

        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
