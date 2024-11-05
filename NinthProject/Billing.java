/**
 * The Billing class represents a billing record that associates a patient with a doctor
 * and calculates the total billing amount based on the doctor's office visit fee.
 */
public class Billing {
    private Patient patient;
    private Doctor doctor;

    /**
     * Constructor that initializes the billing record with a patient and a doctor.
     * @param patient The patient for this billing record.
     * @param doctor The doctor for this billing record.
     */
    public Billing(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    /**
     * Gets the patient associated with this billing record.
     * @return The patient for this billing record.
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Gets the doctor associated with this billing record.
     * @return The doctor for this billing record.
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Calculates the total billing amount for this record based on the doctor's office visit fee.
     * @return The billing amount for this record.
     */
    public double getBillingAmount() {
        return doctor.getOfficeVisitFee();
    }

    /**
     * Displays the billing details including the patient and doctor details, and the billing amount.
     */
    public void displayBilling() {
        System.out.println("Billing Record:");
        patient.writeOutput();
        doctor.writeOutput();
        System.out.println("Total Billing Amount: $" + getBillingAmount());
    }
}
