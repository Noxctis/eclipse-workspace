public class Book {
    private String title;
    private String genre; // "Reference", "Classic", "Religion"
    private int pages;

    // Static variables
    private static int numBooks = 0;
    private static int numReference = 0;
    private static int numClassic = 0;
    private static int numReligion = 0;

    // Constructor with default values
    public Book() {
        this.title = "";
        this.genre = "";
        this.pages = 0;
        numBooks++;
    }

    // Constructor with parameters
    public Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
        numBooks++;
        incrementGenreCount();
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }

    public static int getNumBooks() {
        return numBooks;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        incrementGenreCount();
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    // Increment genre count
    private void incrementGenreCount() {
        switch (genre) {
            case "Reference":
                numReference++;
                break;
            case "Classic":
                numClassic++;
                break;
            case "Religion":
                numReligion++;
                break;
            default :
            break;
        }
    }

    // Method to determine the genre with the highest count
    public static String getHighestGenre() {
        if (numReligion >= numClassic && numReligion >= numReference) {
            return "Religion";
        } else if (numClassic >= numReference) {
            return "Classic";
        } else {
            return "Reference";
        }
    }

    // Method to display book details
    public void displayBook() {
        System.out.printf("%-30s %-15s %-10d%n", title, genre, pages);
    }

    // Static method to display total books
    public static void displayTotalBooks() {
        System.out.println("There are a total of " + numBooks + " books in the library.");
    }
}
