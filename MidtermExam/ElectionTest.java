import java.util.Scanner;

public class ElectionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate candidate objects using non-default constructor
        Candidate candidate1 = new Candidate("Johnson", 5000);
        Candidate candidate2 = new Candidate("Miller", 4000);
        Candidate candidate3 = new Candidate("Duffy", 6000);
        Candidate candidate4 = new Candidate("Robinson", 2500);
        Candidate candidate5 = new Candidate("Ashton", 1800);

        // Create an election object and pass the candidates
        Election election = new Election(candidate1, candidate2, candidate3, candidate4, candidate5);

        // Display the election results
        election.displayResults();

        /*
         * // Input for Candidate 1
        System.out.print("Enter the name of candidate 1: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter votes received by " + name1 + ": ");
        int votes1 = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Input for Candidate 2
        System.out.print("Enter the name of candidate 2: ");
        String name2 = scanner.nextLine();
        System.out.print("Enter votes received by " + name2 + ": ");
        int votes2 = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Input for Candidate 3
        System.out.print("Enter the name of candidate 3: ");
        String name3 = scanner.nextLine();
        System.out.print("Enter votes received by " + name3 + ": ");
        int votes3 = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Input for Candidate 4
        System.out.print("Enter the name of candidate 4: ");
        String name4 = scanner.nextLine();
        System.out.print("Enter votes received by " + name4 + ": ");
        int votes4 = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Input for Candidate 5
        System.out.print("Enter the name of candidate 5: ");
        String name5 = scanner.nextLine();
        System.out.print("Enter votes received by " + name5 + ": ");
        int votes5 = scanner.nextInt();

        // Create Candidate objects with user input
        Candidate candidate1 = new Candidate(name1, votes1);
        Candidate candidate2 = new Candidate(name2, votes2);
        Candidate candidate3 = new Candidate(name3, votes3);
        Candidate candidate4 = new Candidate(name4, votes4);
        Candidate candidate5 = new Candidate(name5, votes5);

        // Create Election object using the candidates
        Election election = new Election(candidate1, candidate2, candidate3, candidate4, candidate5);

        // Display the election results
        election.displayResults();
        */

        scanner.close();
    }
}
