import java.util.Scanner;

public class BookTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create book objects
        Book2 book1 = new Book2("Charlotte's Web", "Classic", 150); // Standard single quote
        Book2 book2 = new Book2("Holy Bible", "Religion", 1000);
        Book2 book3 = new Book2("Bible History", "Religion", 300);
        Book2 book4 = new Book2("My First Atlas", "Reference", 200);

        // Display all books
        System.out.printf("%-30s %-20s %-15s%n", "Title", "Genre", "No. of pages");
        book1.displayBook();
        book2.displayBook();
        book3.displayBook();
        book4.displayBook();

        // Output results
        System.out.printf("%n\"%s\" holds the highest number of pages.%n", Book2.getBookWithMostPages()); // Standard quotes
        System.out.printf("The book that has the most genre is \"%s\".%n", Book2.genreWithMostBooks()); // Standard quotes
        System.out.printf("There are a total of %d books in the library.%n", Book2.getTotalBooks());

        scanner.close();
    }
}
