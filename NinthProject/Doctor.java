/**
 * The Doctor class represents a doctor with a name, specialty, and office visit fee.
 * It extends the Person class.
 */
public class Doctor extends Person {
    private String specialty;
    private double officeVisitFee;

    /**
     * Default constructor that initializes the specialty to "No specialty"
     * and the office visit fee to 0.0.
     */
    public Doctor() {
        super();
        this.specialty = "No specialty";
        this.officeVisitFee = 0.0;
    }

    /**
     * Constructor that initializes the doctor with a name, specialty, and office visit fee.
     * @param name The name of the doctor.
     * @param specialty The specialty of the doctor (e.g., Pediatrician).
     * @param officeVisitFee The office visit fee for the doctor.
     */
    public Doctor(String name, String specialty, double officeVisitFee) {
        super(name);
        this.specialty = specialty;
        this.officeVisitFee = officeVisitFee;
    }

    /**
     * Gets the specialty of the doctor.
     * @return The specialty of the doctor.
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * Sets the specialty of the doctor.
     * @param specialty The new specialty to set.
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * Gets the office visit fee of the doctor.
     * @return The office visit fee.
     */
    public double getOfficeVisitFee() {
        return officeVisitFee;
    }

    /**
     * Sets the office visit fee of the doctor.
     * @param officeVisitFee The new office visit fee to set.
     */
    public void setOfficeVisitFee(double officeVisitFee) {
        this.officeVisitFee = officeVisitFee;
    }

    /**
     * Displays the details of the doctor, including name, specialty, and office visit fee.
     */
    @Override
    public void writeOutput() {
        super.writeOutput();
        System.out.println("Specialty: " + specialty);
        System.out.println("Office Visit Fee: " + officeVisitFee);
    }

    /**
     * Checks if two Doctor objects are equal based on name and specialty.
     * @param otherDoctor The other doctor to compare with.
     * @return True if the names and specialties are the same (ignoring case), otherwise false.
     */
    public boolean equals(Doctor otherDoctor) {
        return super.hasSameName(otherDoctor) && this.specialty.equalsIgnoreCase(otherDoctor.specialty);
    }
}
