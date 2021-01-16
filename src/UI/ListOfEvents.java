package UI;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Schemas.GameEvent;

public class ListOfEvents extends JPanel implements ListSelectionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private DisplayEventDetails display;
    private List<GameEvent> events;

    public ListOfEvents(List<GameEvent> events, DisplayEventDetails display) {
        this.display = display;
        this.events = events;

        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        JList<String> list = new JList<String>(getNameListOfGameEvents(this.events));

        list.setVisible(true);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(this);

        JScrollPane p = new JScrollPane(list);

        add(p, BorderLayout.CENTER); 
    }

    private String[] getNameListOfGameEvents(List<GameEvent> events) {
        List<String> res = new ArrayList<String>();

        for (GameEvent event : events) {
            res.add(event.getGameEventName());
        }

        return (String[]) res.toArray();
    }

    private void displayInformation(GameEvent event) {
        display.setName(event.getGameEventName());
        display.setRegion(event.getGameEventLocation());
        display.setPrizePool(String.valueOf(event.getPrizepool()));
        display.setRatio(event.getRatio());
    }

    private GameEvent findSelectedGameEvent(List<GameEvent> events, String name) {
        for (GameEvent event : events) {
            if (event.getGameEventName() == name) {
                return event;
        }
    }
    return null;
}

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        JList<String> list = (JList) listSelectionEvent.getSource();
        int index = list.getSelectedIndex();
        
        if (index == -1) { return; }
        GameEvent selectedEvent = this.findSelectedGameEvent(this.events, (String) list.getSelectedValue());
        this.displayInformation(selectedEvent);
    }
}