
public class Event {
	private String eventNumber;
    private int numberOfGuests;
    private int eventPrice;

    public static int pricePerGuest = 35;
    public static int cutOffValue = 50;

    public Event() {
        this.eventNumber = "A000";
        this.numberOfGuests = 0;
    }

    public Event(String newEventNumber, int newNumberOfGuests) {
        setEventNumber(newEventNumber);
        setNumberOfGuests(newNumberOfGuests);
    }

    public String getEventNumber() {
        return eventNumber;
    }

    public void setEventNumber(String newEventNumber) {
        this.eventNumber = newEventNumber;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int newNumberOfGuests) {
    	if (newNumberOfGuests <= 50) {
        this.numberOfGuests = newNumberOfGuests;
        calculateEventPrice();
        }
    	else {
    		System.out.println("ERROR Beyond cutoff Value for guest numbers");
    	}
    }

    private void calculateEventPrice() {
        eventPrice = numberOfGuests * pricePerGuest;
    }
    
    public int getEventPrice() {
        return eventPrice;
    }

    public void displayEventDetails() {
        System.out.printf("%-30s %-20d %-15d%n", eventNumber, numberOfGuests, eventPrice);
    }

}
