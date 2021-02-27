package Schemas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Queries {
    private static final SimpleDateFormat DTF = new SimpleDateFormat("yyyy-MM-dd");
    private static String selectQuery = "SELECT %s FROM ESport.dbo.%s";
    private static String updateQuery = "UPDATE ESport.dbo.%s SET %s WHERE %s";

    public static List<GameEvent> getListOfEvents(Connection connection) throws SQLException {
        ResultSet rs = connection.createStatement().executeQuery(
            String.format(
                selectQuery,
                Arrays.stream(GameEvent.columns)
                    .collect(Collectors.joining(", ")),
                GameEvent.table)
        );

        List<GameEvent> events = new ArrayList<GameEvent>();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String location = rs.getString("location") == null ? "" : rs.getString("ratio");
            int prize = rs.getInt("prizepool");
            String ratio = rs.getString("ratio");
            Date start = rs.getDate("start_date");
            Date end = rs.getDate("end_date");

            events.add(new GameEvent(
                id,
                name,
                location,
                prize,
                ratio,
                start,
                end  
            ));
        }

        return events;
    }

    public static void updateEvent(Connection connection, int id, GameEvent event) throws SQLException {
        String[] set = new String[GameEvent.columns.length - 1];
        
        set[0] = String.format("%s='%s'", GameEvent.columns[1], event.getName());
        set[1] = String.format("%s='%s'", GameEvent.columns[2], event.getLocation());
        set[2] = String.format("%s='%s'", GameEvent.columns[3], event.getPrizepool());
        set[3] = String.format("%s='%s'", GameEvent.columns[4], event.getRatio());
        set[4] = String.format("%s=CAST('%s' AS DATE)", GameEvent.columns[5], DTF.format(event.getStartDate()));
        set[5] = String.format("%s=CAST('%s' AS DATE)", GameEvent.columns[6], DTF.format(event.getEndDate()));
        
        connection.createStatement().execute(String.format(
            updateQuery,
            GameEvent.table,
            Arrays.stream(set).collect(Collectors.joining(", ")),
            String.format("%s=%d", GameEvent.columns[0], id)
        ));
    }
}
