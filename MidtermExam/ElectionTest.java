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

        scanner.close();
    }
}
