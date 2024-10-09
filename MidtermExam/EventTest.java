import java.util.Scanner;

public class EventTest {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create book objects
        Event event1 = new Event("A200", 40); // Standard single quote
        Event event3 = new Event("A300", 20); // Standard single quote
        
        Event event2 = new Event();
        event2.setEventNumber("A100");
        event2.setNumberOfGuests(35);
        System.out.println(event2.getEventNumber() + " " + event2.getNumberOfGuests() + " "  + event2.getEventPrice());
        event2.displayEventDetails();
        
        System.out.printf("%-30s %-20s %-15s%n", "Event Number", "Number of Guests", "Event Price");
        event1.displayEventDetails();
        event3.displayEventDetails();

        scanner.close();
    }
}
