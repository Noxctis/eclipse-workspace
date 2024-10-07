import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        // Create a loop to add multiple books
        /*         Scanner scanner = new Scanner(System.in);
        // Create individual book instances
        Book book1 = new Book("Charlotte’s Web", "Classic", 150);
        Book book2 = new Book("Holy Bible", "Religion", 1000);
        Book book3 = new Book("Bible History", "Religion", 300);
        Book book4 = new Book("My First Atlas", "Reference", 200);
        // Display all books
        System.out.printf("%-30s %-15s %-10s%n", "Title", "Genre", "No. of pages");
        book1.displayBook();
        book2.displayBook();
        book3.displayBook();
        book4.displayBook();
        // Find and display the book with the most pages
        Book bookWithMostPages = book1; // Start with the first book
        if (book2.getPages() > bookWithMostPages.getPages()) {
        bookWithMostPages = book2;
        }
        if (book3.getPages() > bookWithMostPages.getPages()) {
        bookWithMostPages = book3;
        }
        if (book4.getPages() > bookWithMostPages.getPages()) {
        bookWithMostPages = book4;
        }
        System.out.println("\nThe book with the most pages is: \"" + bookWithMostPages.getTitle() + "\".");
        // Determine and display the genre with the highest count
        String highestGenre = Book.getHighestGenre();
        System.out.println("The genre with the highest count is: " + highestGenre + ".");
        // Display total number of books
        Book.displayTotalBooks();
        scanner.close();
         */ 
        try (Scanner scanner = new Scanner(System.in)) {
            // Create a loop to add multiple books
            while (true) {
                System.out.println("Enter book details:");
                
                // User input for title, genre, and number of pages
                System.out.print("Title: ");
                String title = scanner.nextLine();
                
                System.out.print("Genre (Reference, Classic, Religion): ");
                String genre = scanner.nextLine();
                
                System.out.print("Number of pages: ");
                int pages = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                
                // Create a new book instance
                Book book = new Book(title, genre, pages);
                
                // Display the added book
                System.out.println("Book added:");
                book.displayBook();
                
                // Ask user if they want to add another book
                System.out.print("Do you want to add another book? (yes/no): ");
                String response = scanner.nextLine();
                if (!response.equalsIgnoreCase("yes")) {
                    break; // Exit the loop if the user doesn't want to add more books
                }
            }
            
            // Display total number of books
            Book.displayTotalBooks();
            
            // Find and display the book with the most pages
            // This example assumes at least one book has been added
            // You can also track the most pages dynamically if needed
            // Here, we'll need to modify to store books if desired
            
            // Ask the user to input the books again or use previous logic for max pages
            // For now, this section will just display the genre with the highest count
            String highestGenre = Book.getHighestGenre();
            System.out.println("The genre with the highest count is: " + highestGenre + ".");
        }
    }
}
