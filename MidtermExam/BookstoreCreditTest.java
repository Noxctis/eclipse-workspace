import java.util.Scanner;

public class BookstoreCreditTest {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create book objects
        BookstoreCredit student1 = new BookstoreCredit("Charles", 5.1); // Standard single quote
        BookstoreCredit student2 = new BookstoreCredit("Stephen", 5);
        BookstoreCredit student3 = new BookstoreCredit("Sid",2.7);
        BookstoreCredit student4 = new BookstoreCredit("John",3.2);
        
        BookstoreCredit student5 = new BookstoreCredit();
        student5.setName("Arnold");
        student5.setGPA(3.2);
        student5.calculateCreditAmount();
        System.out.println(student5.getName() + " " + student5.getGPA() + " " + student5.getCreditAmount());
        student5.displayDetails();
        
        System.out.printf("%-30s %-20s %-15s%n", "Name", "GPA", "Credit Amount");
        student1.displayDetails();
        student2.displayDetails();
        student3.displayDetails();
        student4.displayDetails();

        scanner.close();
    }
}
