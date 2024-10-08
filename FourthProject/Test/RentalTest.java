package Test;

import java.util.Scanner;

class Rental {
    public static final int MINS_IN_HOUR = 60;
    public static final int RENTAL_RATE_HR = 40;

    private String contactNumber;
    private double hoursOfRental;
    private double minsOverHour;
    private double price;

    public Rental() {
        contactNumber = "";
		hoursOfRental = 0;
    }

    public Rental(String contactNumber, int numberOfMinutes) {
        setContactNumber(contactNumber);
        setHoursAndMinutes(numberOfMinutes);
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setHoursAndMinutes(double minutes) {
        this.minsOverHour = minutes;
        this.hoursOfRental = this.minsOverHour / MINS_IN_HOUR; // Corrected to store hours properly
        this.price = this.hoursOfRental * RENTAL_RATE_HR;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public double getHoursOfRental() {
        return this.hoursOfRental;
    }

    public double getMinsOverHour() {
        return this.minsOverHour;
    }

    public double getPrice() {
        return this.price;
    }
}

public class RentalTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create individual Rental instances
        Rental rental1 = new Rental("CANOE", 300);
        Rental rental2 = new Rental("KAYAK", 100);
        Rental rental3 = new Rental("CHAIRS", 30);
        Rental rental4 = new Rental("UMBRELLAS", 45);
        Rental rental5 = new Rental(); // Default constructor

        // Display rental details
        System.out.println();
        displayRentalDetails(1, rental1);
        displayRentalDetails(2, rental2);
        displayRentalDetails(3, rental3);
        displayRentalDetails(4, rental4);
        displayRentalDetails(5, rental5);

        scanner.close();
    }

    // Method to display rental details
    public static void displayRentalDetails(int index, Rental rental) {
        System.out.printf("%d. Contact Number: %s \tHours of Rental: %.2f \tMinutes: %.2f \tPrice: %.2f\n",
                index, rental.getContactNumber(), rental.getHoursOfRental(), rental.getMinsOverHour(), rental.getPrice());
    }
}
