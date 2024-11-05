/**
 * The Patient class represents a patient with a name and an identification number.
 * It extends the Person class.
 */
public class Patient extends Person {
    private String idNumber;

    /**
     * Default constructor that initializes the ID number to "No ID yet".
     */
    public Patient() {
        super();
        this.idNumber = "No ID yet";
    }

    /**
     * Constructor that initializes the patient with a name and ID number.
     * @param name The name of the patient.
     * @param idNumber The identification number of the patient.
     */
    public Patient(String name, String idNumber) {
        super(name);
        this.idNumber = idNumber;
    }

    /**
     * Gets the ID number of the patient.
     * @return The ID number of the patient.
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * Sets the ID number of the patient.
     * @param idNumber The new ID number to set.
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Displays the details of the patient, including name and ID number.
     */
    @Override
    public void writeOutput() {
        super.writeOutput();
        System.out.println("ID Number: " + idNumber);
    }

    /**
     * Checks if two Patient objects are equal based on name and ID number.
     * @param otherPatient The other patient to compare with.
     * @return True if the names and ID numbers are the same, otherwise false.
     */
    public boolean equals(Patient otherPatient) {
        return super.hasSameName(otherPatient) && this.idNumber.equals(otherPatient.idNumber);
    }
}
