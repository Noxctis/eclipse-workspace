public class Book2 {
    private String title;
    private String genre; // Genre is simply a string
    private int numberOfPages;

    private static int totalBooks = 0;
    private static int highestNumberOfPages = 0;
    private static String bookWithMostPages = "";
    private static int referenceCount = 0;
    private static int classicCount = 0;
    private static int religionCount = 0;

    public Book2() {
        this.title = "";
        this.genre = "";
        this.numberOfPages = 0;
        totalBooks++;
    }

    public Book2(String title, String genre, int numberOfPages) {
        this.title = title;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
        totalBooks++;
        updateGenreCount(genre);
        updateHighestPages();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        decrementGenreCount(this.genre);
        this.genre = genre;
        updateGenreCount(genre);
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
        updateHighestPages();
    }

    private void updateGenreCount(String genre) {
        switch (genre) {
            case "Reference":
                referenceCount++;
                break;
            case "Classic":
                classicCount++;
                break;
            case "Religion":
                religionCount++;
                break;
        }
    }

    private void decrementGenreCount(String genre) {
        switch (genre) {
            case "Reference":
                referenceCount--;
                break;
            case "Classic":
                classicCount--;
                break;
            case "Religion":
                religionCount--;
                break;
        }
    }

    private void updateHighestPages() {
        if (this.numberOfPages > highestNumberOfPages) {
            highestNumberOfPages = this.numberOfPages;
            bookWithMostPages = this.title;
        }
    }

    public static String genreWithMostBooks() {
        int maxCount = Math.max(referenceCount, Math.max(classicCount, religionCount));
        if (maxCount == referenceCount) {
            return "Reference";
        } else if (maxCount == classicCount) {
            return "Classic";
        } else {
            return "Religion";
        }
    }

    public void displayBook() {
        System.out.printf("%-30s %-20s %-15d%n", title, genre, numberOfPages);
    }

    public static int getTotalBooks() {
        return totalBooks;
    }

    public static String getBookWithMostPages() {
        return bookWithMostPages;
    }

    public static int getHighestNumberOfPages() {
        return highestNumberOfPages;
    }
}
