/*
============================================================================
FILE :	PersonDemo.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that compares a person's age and name. 
COPYRIGHT : 16-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/
public class PersonDemo
{
    public static void main(String[] args)
    {
        Person person1 = new Person( ), person2 = new Person( );
        
        System.out.println("Enter data of the first person:");
        person1.readInput( );
        
       
        System.out.println("Enter data of the second person: ");
        person2.readInput( );
        
        person1.writeOutput();
        person2.writeOutput();


        System.out.println("Person 1 has same name and Age as Person 2? " + person1.isEquals(person2));
        System.out.println("Is Person 1 has same Age as Person 2? " + person1.isEqualsAge(person2));
        System.out.println("Is Person 1 has same name as Person 2? " + person1.isEqualsName(person2));
        System.out.println("Is Person 1 is Older tham Person 2? " + person1.isOlder(person2));
        System.out.println("Is Person 1 is younger than 2? " + person1.isYounger(person2));
        
        
    }
}
