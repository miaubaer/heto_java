import java.io.*;
import java.sql.*;
import java.util.*;


public class Main {

    Scanner in = new Scanner(System.in);
    static Connection con;
    static PreparedStatement pstmt;
    static Random rand = new Random();

    public Main() throws ClassNotFoundException {
        // this.con = ConnectionProvider.getConnection();

    }



    // Abfragen

    public static void main(String[] args) throws ClassNotFoundException {

        Main a= new Main();
        //a.addGames();             //Uncomment this when running the program for the first time.
        JFrame eSports= new JFrame("Esports Event Info");
        int input,input2, headphoneCount, pcCount, mouseCount, keyboardCount, monitorCount, frontRowSeats, backRowSeats, VIPRooms, foodCapacity;
        String eventName, eventLocation, query;
        Inventory eventInventory;
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
                System.out.println("Enter the details of the inventory: ");
                System.out.println("Enter the total count of headphones in the inventory for the event");
                headphoneCount= in.nextInt();
                System.out.println("Enter the total count of computers in the inventory for the event");
                pcCount= in.nextInt();
                System.out.println("Enter the total count of monitors in the inventory for the event");
                monitorCount= in.nextInt();
                System.out.println("Enter the total count of mice in the inventory for the event");
                mouseCount= in.nextInt();
                System.out.println("Enter the total count of keyboards in the inventory for the event");
                keyboardCount= in.nextInt();
                System.out.println("Enter the details of the seating and food availability: ");
                System.out.println("Enter the total count of front row seats for the event");
                frontRowSeats= in.nextInt();
                System.out.println("Enter the total count of back row seats for the event");
                backRowSeats= in.nextInt();
                System.out.println("Enter the total count of VIPRooms for the event");
                VIPRooms= in.nextInt();
                System.out.println("Enter the count of people who can be catered with food for the event");
                foodCapacity= in.nextInt();
                eventInventory= new Inventory(headphoneCount,pcCount,monitorCount,mouseCount,keyboardCount,foodCapacity,frontRowSeats,backRowSeats,VIPRooms);
                System.out.println("Inventory successfully added to the event!");
                newEvent= new Event(eventInventory, eventName, eventLocation);
                System.out.println("Event successfully created!");
                System.out.println("Welcome to the event management menu!");

            }
        }
    }
}