package oldelection;
import java.util.Scanner;

public class ElectionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Election election1 = new Election();

        //System.out.println(student5.getName() + " " + student5.getGPA() + " " + student5.getCreditAmount());
        //student5.displayDetails();
        
        System.out.printf("%-30s %-20s %-15s%n", "Candidate", "Votes Received", "% of Total Votes");
   
        election1.displayResults();
        System.out.println("Total" + "                          " + Candidate.getTotalNumberVotes());
        scanner.close();
    }
}
