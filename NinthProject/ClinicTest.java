public class ClinicTest {
    public static void main(String[] args) {
        // Test Person class
        System.out.println("Testing Person class:");
        Person person1 = new Person("Alice");
        person1.writeOutput();
        person1.setName("Alicia");
        System.out.println("Updated Name: " + person1.getName());
        
        Person person2 = new Person("Alicia");
        System.out.println("Has Same Name: " + person1.hasSameName(person2));
        
        System.out.println();

        // Test Doctor class
        System.out.println("Testing Doctor class:");
        Doctor doctor1 = new Doctor("Dr. Smith", "Pediatrician", 100.0);
        doctor1.writeOutput();
        doctor1.setSpecialty("General Practitioner");
        doctor1.setOfficeVisitFee(150.0);
        System.out.println("Updated Specialty: " + doctor1.getSpecialty());
        System.out.println("Updated Office Visit Fee: " + doctor1.getOfficeVisitFee());
        
        Doctor doctor2 = new Doctor("Dr. Smith", "General Practitioner", 150.0);
        System.out.println("Equals Another Doctor: " + doctor1.equals(doctor2));
        
        System.out.println();

        // Test Patient class
        System.out.println("Testing Patient class:");
        Patient patient1 = new Patient("Bob", "P001");
        patient1.writeOutput();
        patient1.setIdNumber("P002");
        System.out.println("Updated ID Number: " + patient1.getIdNumber());
        
        Patient patient2 = new Patient("Bob", "P002");
        System.out.println("Equals Another Patient: " + patient1.equals(patient2));
        
        System.out.println();

        // Test Billing class
        System.out.println("Testing Billing class:");
        Billing billing1 = new Billing(patient1, doctor1);
        billing1.displayBilling();
        System.out.println("Billing Amount: $" + billing1.getBillingAmount());
    }
}
