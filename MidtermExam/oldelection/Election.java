import java.util.Scanner;

public class Election {

	private double percentTotalVotes;
	private int TotalVotes;
	

	Candidate candidate1 = new Candidate("Johnson", 5000); // Standard single quote
    Candidate candidate2 = new Candidate("Miller", 4000);
    Candidate candidate3 = new Candidate("Duffy", 6000);
    Candidate candidate4 = new Candidate("Robinson", 2500);
    Candidate candidate5 = new Candidate("Ashton", 1800);

    private double candidate1votes;
    private double candidate2votes;
    private double candidate3votes;
    private double candidate4votes;
    private double candidate5votes;
    
    
    public String calculateWinnerTotalVotes() {
    	int maxCount = Math.max(candidate1.getVotesReceived(), Math.max(Math.max(candidate2.getVotesReceived(), candidate3.getVotesReceived()),Math.max(candidate4.getVotesReceived(), candidate5.getVotesReceived())));
        if (maxCount == candidate1.getVotesReceived()) {
            return candidate1.getSurname();
        } else if (maxCount == candidate2.getVotesReceived()) {
            return candidate2.getSurname();
        } else if (maxCount == candidate3.getVotesReceived()) {
            return candidate3.getSurname();
        } else if (maxCount == candidate4.getVotesReceived()) {
            return candidate4.getSurname();    
        } else {
            return candidate5.getSurname();
        }
    }
    
    private void calculatePercentTotalVotes() {
    	candidate1votes = ((double)candidate1.getVotesReceived()/Candidate.getTotalNumberVotes())*100;
    	candidate2votes = ((double)candidate2.getVotesReceived()/Candidate.getTotalNumberVotes())*100;
    	candidate3votes = ((double)candidate3.getVotesReceived()/Candidate.getTotalNumberVotes())*100;
    	candidate4votes = ((double)candidate4.getVotesReceived()/Candidate.getTotalNumberVotes())*100;
    	candidate5votes = ((double)candidate5.getVotesReceived()/Candidate.getTotalNumberVotes())*100;
    }
    
    
    public void displayResults() {
    	
    	calculatePercentTotalVotes();
        System.out.printf("%-30s %-20d %-15f%n", candidate1.getSurname(), candidate1.getVotesReceived(), candidate1votes);
        System.out.printf("%-30s %-20d %-15f%n", candidate2.getSurname(), candidate2.getVotesReceived(), candidate2votes);
        System.out.printf("%-30s %-20d %-15f%n", candidate3.getSurname(), candidate3.getVotesReceived(), candidate3votes);
        System.out.printf("%-30s %-20d %-15f%n", candidate4.getSurname(), candidate4.getVotesReceived(), candidate4votes);
        System.out.printf("%-30s %-20d %-15f%n", candidate5.getSurname(), candidate5.getVotesReceived(), candidate5votes);
        System.out.println("Winner is "+calculateWinnerTotalVotes());
    }
}
