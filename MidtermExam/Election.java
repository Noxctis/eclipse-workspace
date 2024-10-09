public class Election {

    private Candidate candidate1;
    private Candidate candidate2;
    private Candidate candidate3;
    private Candidate candidate4;
    private Candidate candidate5;

    // Default constructor: Initializes five candidates with default values
    public Election() {
        this.candidate1 = new Candidate();
        this.candidate2 = new Candidate();
        this.candidate3 = new Candidate();
        this.candidate4 = new Candidate();
        this.candidate5 = new Candidate();
    }

    // Non-default constructor: Initializes with five provided candidates
    public Election(Candidate candidate1, Candidate candidate2, Candidate candidate3, 
                    Candidate candidate4, Candidate candidate5) {
        this.candidate1 = candidate1;
        this.candidate2 = candidate2;
        this.candidate3 = candidate3;
        this.candidate4 = candidate4;
        this.candidate5 = candidate5;
    }

    // Calculate the total votes received by all candidates
    public int calculateTotalVotes() {
        return Candidate.getTotalVotes();
    }

    // Calculate percentage of total votes for each candidate
    public double calculatePercentage(Candidate candidate) {
        int totalVotes = calculateTotalVotes();
        if (totalVotes == 0) return 0;
        return ((double) candidate.getVotesReceived() / totalVotes) * 100;
    }

    // Determine the candidate with the highest number of votes
    public String determineWinner() {
        Candidate winner = candidate1;

        if (candidate2.getVotesReceived() > winner.getVotesReceived()) winner = candidate2;
        if (candidate3.getVotesReceived() > winner.getVotesReceived()) winner = candidate3;
        if (candidate4.getVotesReceived() > winner.getVotesReceived()) winner = candidate4;
        if (candidate5.getVotesReceived() > winner.getVotesReceived()) winner = candidate5;

        return winner.getSurname();
    }

    // Display election results in tabulated format
    public void displayResults() {
        System.out.printf("%-15s %-15s %-15s%n", "Candidate", "Votes Received", "% of Total Votes");
        displayCandidateResult(candidate1);
        displayCandidateResult(candidate2);
        displayCandidateResult(candidate3);
        displayCandidateResult(candidate4);
        displayCandidateResult(candidate5);

        System.out.printf("%-15s %-15d%n", "Total Votes", calculateTotalVotes());
        System.out.printf("The Winner is %s.%n", determineWinner());
    }

    // Helper method to display a candidate's result
    private void displayCandidateResult(Candidate candidate) {
        System.out.printf("%-15s %-15d %-15.2f%n", 
                          candidate.getSurname(), 
                          candidate.getVotesReceived(), 
                          calculatePercentage(candidate));
    }
}
