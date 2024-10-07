
public class BookTest {
    public static void main(String[] args) {
        // Create a loop to add multiple books;
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
        
        /*Scanner scanner = new Scanner(System.in);
        
        // Create a loop to add multiple books
        while (true) {
            System.out.println("Enter book details:");

            // User input for title
            System.out.print("Title: ");
            String title = scanner.nextLine().trim();
            while (title.isEmpty()) {
                System.out.print("Title cannot be empty. Please enter a valid title: ");
                title = scanner.nextLine().trim();
            }
            
            // User input for genre with validation
            String genre;
            while (true) {
                System.out.print("Genre (Reference, Classic, Religion): ");
                genre = scanner.nextLine().trim();
                if (genre.equalsIgnoreCase("Reference") || 
                    genre.equalsIgnoreCase("Classic") || 
                    genre.equalsIgnoreCase("Religion")) {
                    break; // Valid genre
                } else {
                    System.out.println("Invalid genre. Please enter one of the following: Reference, Classic, Religion.");
                }
            }
            
            // User input for number of pages with validation
            int pages = 0;
            while (true) {
                System.out.print("Number of pages: ");
                if (scanner.hasNextInt()) {
                    pages = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (pages > 0) {
                        break; // Valid pages
                    } else {
                        System.out.println("Number of pages must be greater than 0.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear invalid input
                }
            }

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

        // Determine and display the genre with the highest count
        String highestGenre = Book.getHighestGenre();
        System.out.println("The genre with the highest count is: " + highestGenre + ".");

        scanner.close();
        */
         
    }
}
