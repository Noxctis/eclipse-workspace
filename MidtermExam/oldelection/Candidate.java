package oldelection;
public class Candidate {

	   	private String surName;
	    private int votesReceived;
	    
	    private static int numberTotalVotes = 0;
	    
	    public Candidate() {
	        this.surName = "";
	        this.votesReceived = 0;
	    }

	    public Candidate(String newSurname, int newNumberOfVotes) {
	    	this.surName = newSurname;
	        this.votesReceived = newNumberOfVotes;
	        updateTotalNumberVotes(newNumberOfVotes);
	    }

	    public String getSurname() {
	        return surName;
	    }

	    public void setSurname(String newSurname) {
	        this.surName = newSurname;
	    }
	    

	    public int getVotesReceived() {
	        return votesReceived;
	    }

	    public void setVotesReceived(int newNumberOfVotes) { 
	        this.votesReceived = newNumberOfVotes;
	    }

	    private static void updateTotalNumberVotes(int newNumberOfVotes) {
	    	numberTotalVotes += newNumberOfVotes;
	    }
	    
	    public static int getTotalNumberVotes() {
	    	return numberTotalVotes;
	    }
	    
}
