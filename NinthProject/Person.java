/**
 * The Person class represents a basic person with a name.
 */
public class Person {
    private String name;

    /**
     * Default constructor that initializes the name to "No name yet".
     */
    public Person() {
        this.name = "No name yet";
    }

    /**
     * Constructor that initializes the name to the given value.
     * @param initialName The initial name of the person.
     */
    public Person(String initialName) {
        this.name = initialName;
    }

    /**
     * Gets the name of the person.
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     * @param newName The new name to set.
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Outputs the name of the person to the console.
     */
    public void writeOutput() {
        System.out.println("Name: " + name);
    }

    /**
     * Checks if two Person objects have the same name, ignoring case.
     * @param otherPerson The other person to compare with.
     * @return True if the names are the same (ignoring case), otherwise false.
     */
    public boolean hasSameName(Person otherPerson) {
        return this.name.equalsIgnoreCase(otherPerson.name);
    }
}
