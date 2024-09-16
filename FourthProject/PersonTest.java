/*
============================================================================
FILE :	PersonTest.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that compares a person's age and name. 
COPYRIGHT : 16-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/

public class PersonTest {
    public static void main(String[] args) {
        // Create two Person objects
        Person person1 = new Person();
        Person person2 = new Person();

        // Set name and age for person1
        person1.setName("John Doe");
        person1.setAge(25);

        // Set name and age for person2
        person2.setName("Jane Smith");
        person2.setAge(30);

        // Display person1 details
        System.out.println("Person 1:");
        person1.writeOutput();

        // Display person2 details
        System.out.println("\nPerson 2:");
        person2.writeOutput();

        // Test isEquals method (true case)
        System.out.println("\nTesting isEquals (true case):");
        person2.setName("John Doe"); // Change Name
        person2.setAge(25); // Change Age
        person1.writeOutput();
        person2.writeOutput();
        System.out.println("Are person1 and person2 equal? " + person1.isEquals(person2)); // true

        // Test isEquals method (false case)
        System.out.println("\nTesting isEquals (false case):");
        person2.setAge(30); // Change age
        person1.writeOutput();
        person2.writeOutput();
        System.out.println("Are person1 and person2 equal? " + person1.isEquals(person2)); // false

        // Test isEqualsName method (true case)
        System.out.println("\nTesting isEqualsName (true case):");
        System.out.println("Do person1 and person2 have the same name? " + person1.isEqualsName(person2)); // true

        // Test isEqualsName method (false case)
        System.out.println("\nTesting isEqualsName (false case):");
        person2.setName("Jane Smith"); // Change name
        person1.writeOutput();
        person2.writeOutput();
        System.out.println("Do person1 and person2 have the same name? " + person1.isEqualsName(person2)); // false

        // Test isEqualsAge method (true case)
        System.out.println("\nTesting isEqualsAge (true case):");
        person2.setAge(25); // Set same age
        person1.writeOutput();
        person2.writeOutput();
        System.out.println("Do person1 and person2 have the same age? " + person1.isEqualsAge(person2)); // true

        // Test isEqualsAge method (false case)
        System.out.println("\nTesting isEqualsAge (false case):");
        person2.setAge(30); // Change age
        person1.writeOutput();
        person2.writeOutput();
        System.out.println("Do person1 and person2 have the same age? " + person1.isEqualsAge(person2)); // false

        // Test isOlder method (true case)
        System.out.println("\nTesting isOlder (true case):");
        person1.setAge(35); // Change age
        person1.writeOutput();
        person2.writeOutput();
        System.out.println("Is person1 older than person2? " + person1.isOlder(person2)); // true

        // Test isOlder method (false case)
        System.out.println("\nTesting isOlder (false case):");
        person1.setAge(20); // Change age
        person1.writeOutput();
        person2.writeOutput();
        System.out.println("Is person1 older than person2? " + person1.isOlder(person2)); // false

        // Test isYounger method (true case)
        System.out.println("\nTesting isYounger (true case):");
        System.out.println("Is person1 younger than person2? " + person1.isYounger(person2)); // true

        // Test isYounger method (false case)
        System.out.println("\nTesting isYounger (false case):");
        person1.setAge(40); // Change age
        person1.writeOutput();
        person2.writeOutput();
        System.out.println("Is person1 younger than person2? " + person1.isYounger(person2)); // false
    }
}
