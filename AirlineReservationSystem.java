import java.util.ArrayList;
import java.util.Scanner;

public class AirlineReservationSystem {
    
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Passenger> passengers = new ArrayList<>();
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Airline Reservation System");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Passenger Details");
            System.out.println("4. Exit");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    cancelTicket();
                    break;
                case 3:
                    viewPassengerDetails();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        }
    }
    
    public static void bookTicket() {
        System.out.println("Enter passenger name:");
        String name = scanner.next();
        System.out.println("Enter departure city:");
        String departure = scanner.next();
        System.out.println("Enter destination city:");
        String destination = scanner.next();
        System.out.println("Enter travel date (DD/MM/YYYY):");
        String travelDate = scanner.next();
        
        Passenger passenger = new Passenger(name, departure, destination, travelDate);
        passengers.add(passenger);
        System.out.println("Ticket booked successfully");
    }
    
    public static void cancelTicket() {
        System.out.println("Enter passenger name:");
        String name = scanner.next();
        System.out.println("Enter travel date (DD/MM/YYYY):");
        String travelDate = scanner.next();
        
        for (int i = 0; i < passengers.size(); i++) {
            Passenger passenger = passengers.get(i);
            if (passenger.getName().equals(name) && passenger.getTravelDate().equals(travelDate)) {
                passengers.remove(i);
                System.out.println("Ticket cancelled successfully");
                return;
            }
        }
        
        System.out.println("Ticket not found");
    }
    
    public static void viewPassengerDetails() {
        System.out.println("Enter passenger name:");
        String name = scanner.next();
        
        for (int i = 0; i < passengers.size(); i++) {
            Passenger passenger = passengers.get(i);
            if (passenger.getName().equals(name)) {
                System.out.println("Name: " + passenger.getName());
                System.out.println("Departure: " + passenger.getDeparture());
                System.out.println("Destination: " + passenger.getDestination());
                System.out.println("Travel Date: " + passenger.getTravelDate());
                return;
            }
        }
        
        System.out.println("Passenger not found");
    }
}

class Passenger {
    private String name;
    private String departure;
    private String destination;
    private String travelDate;
    
    public Passenger(String name, String departure, String destination, String travelDate) {
        this.name = name;
        this.departure = departure;
        this.destination = destination;
        this.travelDate = travelDate;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDeparture() {
        return departure;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public String getTravelDate() {
        return travelDate;
    }
}
