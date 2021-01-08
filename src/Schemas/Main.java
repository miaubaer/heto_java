// Hermann

package Schemas;

import java.io.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.imageio.*;
import javax.swing.*;

public class Main {

    Scanner in = new Scanner(System.in);
    static Connection con;
    static PreparedStatement pstmt;
    static Random rand = new Random();

    public Main() throws ClassNotFoundException {
        this.con = ConnectionProvider.getConnection();
    }

    //SHOW GUI with Background-image
    public static void setGUI(JFrame f, Event a) {
        f.setSize(1280, 720);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("esportsbg.jpg")))));  //Setting background of the JFrame
        } catch (IOException e) {
            e.printStackTrace();
        }
        f.pack();
        f.setVisible(true);

        JLabel eventName = new JLabel(a.getEventName());
        eventName.setBounds(360, 215, 400, 50);
        eventName.setForeground(Color.orange);
        eventName.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 50));
        f.add(eventName);
        JLabel eventLocation = new JLabel(a.getEventLocation());
        eventLocation.setBounds(370, 260, 400, 50);
        eventLocation.setForeground(Color.orange);
        eventLocation.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
        f.add(eventLocation);
    }



    // Abfragen
    public static void main(String[] args) throws ClassNotFoundException {
        //  Was du getestet hast, habe ich in die Methode unten "tobisTest()" verschoben. (Hermann)

    }

    private void tobisTest() throws ClassNotFoundException {

        Main a= new Main();
        //a.addGames();             //Uncomment this when running the program for the first time.
        JFrame eSports= new JFrame("Esports Event Info");
        int input,input2, headphoneCount, pcCount, mouseCount, keyboardCount, monitorCount, frontRowSeats, backRowSeats, VIPRooms, foodCapacity;
        String eventName, eventLocation, query;
       //markerUseLater Inventory eventInventory;
        boolean flag=false;
        boolean exitFlag=false;
        Event newEvent;
        Scanner in= new Scanner(System.in);

        while (true)
        {
            System.out.println("Enter 1 to add event, 2 to exit");          //Enter event details.

            input= in.nextInt();
            if (input==2)
            {
                System.out.println("Exiting the menu!");
                return;
            }
            in.nextLine();
            while (input==1)
            {
                System.out.println("Enter the name of the event: ");
                eventName= in.nextLine();
                query= "select * from event";
                try {
                    pstmt= con.prepareStatement(query);
                    ResultSet set= pstmt.executeQuery();
                    while (set.next())
                    {
                        String check= set.getString("id");
                        if (check.equalsIgnoreCase(eventName))
                        {
                            System.out.println("An event already exists with this name!");
                            flag=true;
                            break;
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (flag==true)
                {
                    break;
                }
                System.out.println("Enter the location of the event: ");        //Enter details of the event inventory.
                eventLocation= in.nextLine();

                newEvent= new Event(eventName, eventLocation, 0.0, null, null);
                System.out.println("Event successfully created!");
                System.out.println("Welcome to the event management menu!");




                //Manage/add players,spectators,sponsors and inventory of the event.
                while (exitFlag==false)
                {
                    System.out.println("Press 1 to add a team/players, 2 to add spectators, 3 to add sponsors, 4 to add inventory, 5 to exit");
                    input= in.nextInt();
                    if (input==1)
                    {
                        System.out.println("*** THIS IS UNDER CONSTRUCTON, CHOOSE ANOTHER OPTION ***");
                    }
                    else if (input==2)
                    {
                        System.out.println("*** THIS IS UNDER CONSTRUCTON, CHOOSE ANOTHER OPTION ***");
                    }
                    else if (input==3)
                    {
                        System.out.println("*** THIS IS UNDER CONSTRUCTON, CHOOSE ANOTHER OPTION ***");
                    }
                    else if (input==4)
                    {
                        System.out.println("*** THIS IS UNDER CONSTRUCTON, CHOOSE ANOTHER OPTION ***");
                    }
                    else if (input==5)
                    {
                        System.out.println("Confirming event details and adding to database.");
                        System.out.println("Event successfully added, exiting menu");
                        exitFlag=true;
                        setGUI(eSports,newEvent);    //Displaying event details in the GUI


                    }
                }
            }
        }
    }
}