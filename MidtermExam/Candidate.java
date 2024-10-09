public class Candidate {

    private String surname;
    private int votesReceived;

    private static int totalVotes = 0;  // Keeps track of total votes across all candidates

    // Default constructor
    public Candidate() {
        this.surname = "";
        this.votesReceived = 0;
    }

    // Non-default constructor
    public Candidate(String surname, int votesReceived) {
        this.surname = surname;
        this.votesReceived = votesReceived;
        Candidate.totalVotes += votesReceived;  // Update total votes when candidate is created
    }

    // Getters and Setters
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getVotesReceived() {
        return votesReceived;
    }

    public void setVotesReceived(int votesReceived) {
        // Adjust total votes if the number of votes changes
        Candidate.totalVotes -= this.votesReceived;  // Subtract the old value
        this.votesReceived = votesReceived;
        Candidate.totalVotes += votesReceived;  // Add the new value
    }

    public static int getTotalVotes() {
        return totalVotes;
    }
}
