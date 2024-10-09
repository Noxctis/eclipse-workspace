
public class BookstoreCredit {
	
	private String Name;
    private double GPA;
    private double creditAmount; 


    public BookstoreCredit() {
        this.Name = "";
        this.GPA = 0;
        this.creditAmount = 0;
        calculateCreditAmount();
    }

    public BookstoreCredit(String newName,double newGPA) {
    	this.Name = newName;
    	this.GPA = newGPA;
    	calculateCreditAmount();
    }
    
    public String getName() {
        return Name;
    }
    
    public void setName(String newName) {
        Name = newName;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double newGPA) {
        this.GPA = newGPA;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double newCreditAmount) {
        this.creditAmount = newCreditAmount;
    }

    public void calculateCreditAmount() {
        creditAmount = 75 * GPA;
    }

    public void displayDetails() {
        System.out.printf("%-15s \t\t%-20f %-15f%n", Name, GPA, creditAmount);
    }
}
