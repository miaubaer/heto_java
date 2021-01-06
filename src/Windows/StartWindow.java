package Windows;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import Schemas.*;

public class StartWindow extends JFrame {/*
    private JPanel startPanel = new JPanel();

    // Built-in lists of team for tests
    Schemas.Team[] tl1 = {
        new Schemas.Team("OG", new String[]{"NBK", "Aleksib", "valde", "ISSAA", "mantuu"}),
        new Schemas.Team("Schemas.Team Vitality", new String[]{"apEX", "RpK", "ZywOo", "shox", "misutaaa"}),
        new Schemas.Team("G2 Esports", new String[]{"kennys", "AmaNEk", "nexa", "huNter-", "NiKo"}),
        new Schemas.Team("Natus Vincere", new String[]{"fampie", "s1mple", "electronic", "Boombl4", "Perfecto"}),
        new Schemas.Team("BIG", new String[]{"tabseN", "tizian", "XANTERES", "syrsoN", "k1to"}),
        new Schemas.Team("Astralis", new String[]{"device", "dupreeh", "Xyp9x", "gla1ve", "Magisk"}),
        new Schemas.Team("FURIA Esports", new String[]{"yuurih", "arT", "VINI", "KSCERATO", "HEN1"}),
        new Schemas.Team("mousesports", new String[]{"chrisj", "ropz", "karrigen", "frozen", "Bymas"}),
    };
    Schemas.Team[] tl2 = {
        new Schemas.Team("Cloud9", new String[]{"floppy", "ALEX", "mezil", "woxic", "es3tag"}),
        new Schemas.Team("c0ntact Gaming", new String[]{"EspiranTo", "ottoNd", "Snappi", "Spinx", "rigoN"}),
        new Schemas.Team("Dignitas", new String[]{"f0rest", "friberg", "hallzerk", "H4RR3", "HEAP"}),
        new Schemas.Team("Schemas.Team Envy", new String[]{"Nifty", "Calyx", "MICHU", "LEGIJA", "Thomas"}),
        new Schemas.Team("Gen.G Esports", new String[]{"autimatic", "koosta", "BnTeT", "Xizt", "kreaz"}),
        new Schemas.Team("MAD Lions", new String[]{"acoR", "sjuush", "roej", "HooXi", "refrezh"}),
        new Schemas.Team("MIBR", new String[]{"kNgV-", "trk", "LUCAS1", "leo_drk", "v$m"}),
        new Schemas.Team("BIG", new String[]{"tabseN", "tizian", "XANTERES", "syrsoN", "k1to"}),
        new Schemas.Team("Fnatic", new String[]{"KRIMZ", "JW", "Brollan", "flusha", "Golden"}),
        new Schemas.Team("OG", new String[]{"NBK", "Aleksib", "valde", "ISSAA", "mantuu"}),
        new Schemas.Team("Virtus.pro", new String[]{"buster", "qikert", "jame", "SANJI", "YEKINDAR"}),
        new Schemas.Team("forZe", new String[]{"facecrack", "Jerry", "almazer", "xsepower", "FL1T"}),
    };

    // Built-in events just for test
    private Schemas.Event[] events = {
        // https://liquipedia.net/counterstrike/BLAST/Premier/2020/Fall
        new Schemas.Event(
            "BLAST Premier", 
            "Europe", 
            425000.0, 
            new double[]{
                0.53, 0.20, 0.09, 0.05, 0.04, 0.04, 0.03, 0.03
            }, 
            Arrays.asList(tl1)
        ),
        new Schemas.Event(
            "Flashpoint Season 2", 
            "Europe", 
            1000000.0, 
            new double[]{
                0.5, 0.25, 0.10, 0.05, 0.035, 0.035, 0.015, 0.015
            }, 
            Arrays.asList(tl2)
        ),
    };

    public StartWindow() {
        initUI();
    }

    private void initUI() {

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
    }*/
}
