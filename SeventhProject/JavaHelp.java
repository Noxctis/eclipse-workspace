// Java Cheat Sheet - Commonly Used Methods
public class JavaHelp {

    // String Methods
    public void stringMethods() {
        String str = "Hello, World!";
        System.out.println(str.length()); // Length of the string
        System.out.println(str.charAt(0)); // Get character at index 0
        System.out.println(str.substring(0, 5)); // Substring from index 0 to 5
        System.out.println(str.toLowerCase()); // Convert to lowercase
        System.out.println(str.toUpperCase()); // Convert to uppercase
        System.out.println(str.equals("Hello")); // Compare strings
        System.out.println(str.contains("World")); // Check if contains substring
        System.out.println(str.replace("World", "Java")); // Replace substring
        System.out.println(str.trim()); // Trim whitespace
    }

    // Math Methods
    public void mathMethods() {
        System.out.println(Math.abs(-10)); // Absolute value
        System.out.println(Math.max(5, 10)); // Maximum of two numbers
        System.out.println(Math.min(5, 10)); // Minimum of two numbers
        System.out.println(Math.pow(2, 3)); // Power (2^3)
        System.out.println(Math.sqrt(16)); // Square root
        System.out.println(Math.random()); // Random number between 0.0 and 1.0
        System.out.println(Math.sin(Math.toRadians(30))); // Sine of an angle in degrees
        System.out.println(Math.cos(Math.toRadians(60))); // Cosine of an angle in degrees
    }

    // Array Methods
    public void arrayMethods() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arr.length); // Length of the array
        int[][] matrix = {{1, 2}, {3, 4}};
        System.out.println(matrix.length); // Number of rows
        System.out.println(matrix[0].length); // Number of columns in first row
        Arrays.sort(arr); // Sort the array
        System.out.println(Arrays.toString(arr)); // Print array as string
    }

    // List (ArrayList) Methods
    public void listMethods() {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        System.out.println(list.size()); // Size of the list
        System.out.println(list.get(0)); // Get element at index 0
        list.remove("Banana"); // Remove an element
        list.set(1, "Mango"); // Set element at index 1
        System.out.println(list.contains("Apple")); // Check if contains element
        System.out.println(list.indexOf("Mango")); // Get index of an element
        System.out.println(list.isEmpty()); // Check if list is empty
        list.clear(); // Clear the list
    }

    // File I/O Methods
    public void fileIOMethods() throws IOException {
        // Writing to a file
        FileWriter writer = new FileWriter("file.txt");
        writer.write("Hello, File!");
        writer.close();

        // Reading from a file
        FileReader reader = new FileReader("file.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    // Exception Handling
    public void exceptionHandling() {
        try {
            int result = 10 / 0; // This will throw an ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } finally {
            System.out.println("This will always run.");
        }
    }

    // Date and Time Methods
    public void dateAndTimeMethods() {
        LocalDate date = LocalDate.now(); // Get current date
        LocalTime time = LocalTime.now(); // Get current time
        LocalDateTime dateTime = LocalDateTime.now(); // Get current date and time

        System.out.println(date); // Print date
        System.out.println(time); // Print time
        System.out.println(dateTime); // Print date and time

        LocalDate specificDate = LocalDate.of(2020, Month.JANUARY, 1); // Set a specific date
        LocalTime specificTime = LocalTime.of(12, 0); // Set a specific time
        System.out.println(specificDate);
        System.out.println(specificTime);
    }

    // Main method for testing
    public static void main(String[] args) throws IOException {
        JavaCheatSheet cheatSheet = new JavaCheatSheet();
        cheatSheet.stringMethods();
        cheatSheet.mathMethods();
        cheatSheet.arrayMethods();
        cheatSheet.listMethods();
        cheatSheet.fileIOMethods();
        cheatSheet.exceptionHandling();
        cheatSheet.dateAndTimeMethods();
    }
}
