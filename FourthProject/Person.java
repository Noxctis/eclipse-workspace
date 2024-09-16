/*
============================================================================
FILE :	Person.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that compares a person's age and name. 
COPYRIGHT : 16-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/

import java.util.Scanner;

	/**
 	Class for data on Person.
	 */
public class Person
{
    private String personName;
    private int personAge;

    /**
     * Precondition: The input from the user must be a valid string for the name
     * and a valid non-negative integer for the age.
     * Postcondition: The instance variables personName and personAge are updated with the user input.
     */
    public void readInput( )
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is the person's name?");
        personName = keyboard.nextLine( );

        System.out.println("What is the person's age?");
        personAge = keyboard.nextInt( );
        keyboard.nextLine();  // Consume the remaining newline character
        while (personAge < 0)
        {
            System.out.println("Age cannot be negative.");
            System.out.println("Reenter Age:");
            personAge = keyboard.nextInt( );
            keyboard.nextLine();  // Consume the remaining newline character
        }
    }

    /**
     * Precondition: The instance variables personName and personAge are initialized.
     * Postcondition: Outputs the values of personName and personAge to the console.
     */
    public void writeOutput( )
    {
         System.out.println("Name = " + personName);
         System.out.println("Age = " + personAge);
    }

    /**
     * Precondition: The instance variables of the calling object have values.
     * Postcondition: Returns a string representation of the Person.
     * @return A string containing the person's name and age.
     */
    public String displayPerson() {
        return "Name: " + personName + "\nAge: " + personAge;
    }

    /**
     * Precondition: A valid string and a non-negative integer are provided as parameters.
     * Postcondition: Initializes the instance variables personName and personAge.
     * @param newName The name to assign to the person.
     * @param newAge The age to assign to the person.
     */
    public Person(String newName, int newAge) {
        personName = newName;
        personAge = newAge;
    }

    /**
     * Precondition: None.
     * Postcondition: Initializes the instance variables personName to an empty string and personAge to 0.
     */
    public Person() {
        personName = "";
        personAge = 0;
    }
    
    /**
     * Precondition: A valid string is passed as an argument.
     * Postcondition: The instance variable personName is updated with the new value.
     * @param newName The name to assign to the person.
     */
    public void setName(String newName)
    {
        personName = newName;
    }
    
    /**
     * Precondition: A valid non-negative integer is passed as an argument.
     * Postcondition: The instance variable personAge is updated with the new value.
     * @param newAge The age to assign to the person. Must be non-negative.
     */
    public void setAge(int newAge)
    {
    	if (newAge >= 0) {
            personAge = newAge;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }

    /**
     * Precondition: A valid string and non-negative integer are passed as arguments.
     * Postcondition: Updates the instance variables personName and personAge with the new values.
     * @param newName The name to assign to the person.
     * @param newAge The age to assign to the person. Must be non-negative.
     */
    public void setPerson(String newName, int newAge) {
        personName = newName;
        if (newAge >= 0) {
            personAge = newAge;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }
    
    /**
     * Precondition: The instance variable personName has a value.
     * Postcondition: Returns the value of the instance variable personName.
     * @return The person's name.
     */
    public String getName( )
    {
        return personName;
    }

    /**
     * Precondition: The instance variable personAge has a value.
     * Postcondition: Returns the value of the instance variable personAge.
     * @return The person's age.
     */
    public int getAge( )
    {
        return personAge;
    }

    /**
     * Precondition: Both the calling object and the otherObject must be properly initialized.
     * Postcondition: Returns true if both personName and personAge are equal for the calling object and the otherObject.
     * @param otherObject The other Person object to compare with.
     * @return True if both the name and age are equal, otherwise false.
     */
    public boolean isEquals(Person otherObject)
    {
        return (this.personName.equalsIgnoreCase(otherObject.personName)) &&
               (this.personAge == otherObject.personAge);
    }
    
    /**
     * Precondition: Both the calling object and the otherObject must be properly initialized.
     * Postcondition: Returns true if personName is equal for the calling object and the otherObject.
     * @param otherObject The other Person object to compare with.
     * @return True if the names are equal, otherwise false.
     */
    public boolean isEqualsName(Person otherObject)
    {
        return (this.personName.equalsIgnoreCase(otherObject.personName));
    }

    /**
     * Precondition: Both the calling object and the otherObject must be properly initialized.
     * Postcondition: Returns true if personAge is equal for the calling object and the otherObject.
     * @param otherObject The other Person object to compare with.
     * @return True if the ages are equal, otherwise false.
     */   
    public boolean isEqualsAge(Person otherObject)
    {
        return (this.personAge == otherObject.personAge);
    }

    /**
     * Precondition: Both the calling object and the otherObject must be properly initialized.
     * Postcondition: Returns true if the calling object is older than the otherObject.
     * @param otherObject The other Person object to compare with.
     * @return True if the calling object is older, otherwise false.
     */
    public boolean isOlder(Person otherObject)
    {
        return (this.personAge > otherObject.personAge);
    }
    
    /**
     * Precondition: Both the calling object and the otherObject must be properly initialized.
     * Postcondition: Returns true if the calling object is younger than the otherObject.
     * @param otherObject The other Person object to compare with.
     * @return True if the calling object is younger, otherwise false.
     */
    public boolean isYounger(Person otherObject)
    {
        return (this.personAge < otherObject.personAge);
    }
}
