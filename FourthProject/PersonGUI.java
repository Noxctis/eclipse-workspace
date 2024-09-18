/*
============================================================================
FILE :	PersonGUI.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that compares a person's age and name. 
COPYRIGHT : 16-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/

import javax.swing.JOptionPane;

public class PersonGUI {
    public static void main(String[] args) {
        // Collect data for person1
        String name1 = getValidName("Enter the name of the first person:");
        if (name1 == null) { // Handle cancellation
            System.exit(0);
        }
        int age1 = getValidAge("Enter the age of the first person:");
        Person person1 = new Person(name1, age1);

        // Collect data for person2
        String name2 = getValidName("Enter the name of the second person:");
        if (name2 == null) { // Handle cancellation
            System.exit(0);
        }
        int age2 = getValidAge("Enter the age of the second person:");
        Person person2 = new Person(name2, age2);

        // Comparison results
        boolean isEqual = person1.isEquals(person2);
        boolean sameName = person1.isEqualsName(person2);
        boolean sameAge = person1.isEqualsAge(person2);
        boolean older = person1.isOlder(person2);
        boolean younger = person1.isYounger(person2);

        // Build the output string
        String output = String.format(
                "Person 1: \nName: %s \nAge: %d\n\nPerson 2: \nName: %s \nAge: %d\n\n", 
                person1.getName(), person1.getAge(), person2.getName(), person2.getAge());

        // Add comparisons to the output string
        output += String.format("Person 1 is equal to Person 2 (same name and age): %b\n", isEqual);
        output += String.format("Person 1 has the same name as Person 2: %b\n", sameName);
        output += String.format("Person 1 has the same age as Person 2: %b\n", sameAge);
        output += String.format("Person 1 is older than Person 2: %b\n", older);
        output += String.format("Person 1 is younger than Person 2: %b\n", younger);

        // Display the final output in one JOptionPane
        JOptionPane.showMessageDialog(null, output);
    }

    /**
     * Precondition: A valid string is passed as arguments.
     * Postcondition: Returns a valid and non-negative integer
     * @param message The message on what to input into the GUI.
     * @return Value A valid and non-negative integer.
     */
    private static int getValidAge(String prompt) {
        int age = -1;
        boolean valid = false;
        
        while (!valid) {
            String ageStr = JOptionPane.showInputDialog(prompt);
            if (ageStr == null) { // Handle cancellation
                System.exit(0);
            }
            try {
                age = Integer.parseInt(ageStr);
                if (age >= 0) {
                    valid = true; // Valid non-negative integer
                } else {
                    JOptionPane.showMessageDialog(null, "Age cannot be negative. Please try again.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer for the age.");
            }
        }

        return age;
    }
    
    /**
     * Precondition: A valid string is passed as arguments.
     * Postcondition: Returns a valid non-empty string
     * @param message The message on what to input into the GUI.
     * @return name A valid and non-empty string.
     */
    private static String getValidName(String prompt) {
        String name = "";
        boolean valid = false;
        
        while (!valid) {
            String nameStr = JOptionPane.showInputDialog(prompt);
            if (nameStr == null) { // Handle cancellation
                System.exit(0);
            }
            try {
                name = nameStr;
                if (!name.isEmpty()) {
                    valid = true; // Valid non-empty string
                } else {
                    JOptionPane.showMessageDialog(null, "Name cannot be Blank. Please try again.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a name.");
            }
        }

        return name;
    }
    
}
