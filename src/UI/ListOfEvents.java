package UI;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Schemas.GameEvent;

public class ListOfEvents extends JPanel implements ListSelectionListener {

    private static final long serialVersionUID = 1L;
    private DisplayEventDetails display;
    private List<GameEvent> events;

    public ListOfEvents(List<GameEvent> events, DisplayEventDetails display) {
        this.display = display;
        this.events = events;

        initUI(new JList<String>(getNameListOfGameEvents(this.events)));
    }

    private void initUI(JList<String> list) {
        setLayout(new BorderLayout());


        list.setVisible(true);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(this);

        JScrollPane p = new JScrollPane(list);

        add(p, BorderLayout.CENTER); 
    }

    private String[] getNameListOfGameEvents(List<GameEvent> events) {
        List<String> str = new ArrayList<String>();

        for (GameEvent event : events) {
            str.add(event.getName());
        }

        String[] res = new String[str.size()];
        for (int i = 0; i < str.size(); i++) {
            res[i] = str.get(i);
        }
        return res;
    }

    private void displayInformation(GameEvent event) {
        display.setTextToFields(event);
    }

    private GameEvent findSelectedGameEvent(List<GameEvent> events, String name) {
        for (GameEvent event : events) {
            if (event.getName() == name) {
                return event;
        }
    }
    return null;
}

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (this.display == null) return ;
        
        JList<String> source = (JList) listSelectionEvent.getSource();
        int index = source.getSelectedIndex();

        if (index == -1) { return; }
        GameEvent selectedEvent = this.findSelectedGameEvent(this.events, (String) source.getSelectedValue());
        this.displayInformation(selectedEvent);
    }
}