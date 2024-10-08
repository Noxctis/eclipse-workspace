package Test;

import java.text.DecimalFormat;

class Bestseller {
    private String title;
    private int sales;

    private static int totalSalesCount = 0;
    private static int bestSalesCount = 0;
    private static String bestSellerTitle = "";

    // Constructor
    public Bestseller(String title, int sales) {
        this.title = title;
        this.sales = sales;
        totalSalesCount += sales;
        updateBestSeller();
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getSales() {
        return sales;
    }

    // Method to update the best seller
    private void updateBestSeller() {
        if (sales > bestSalesCount) {
            bestSalesCount = sales;
            bestSellerTitle = title;
        }
    }

    // Static methods
    public static int getTotalSalesCount() {
        return totalSalesCount;
    }

    public static String getBestSellerTitle() {
        return bestSellerTitle;
    }

    // Method to calculate the percentage of sales
    public double calculatePercentage() {
        if (totalSalesCount == 0) {
            return 0.00;
        }
        double totalPercentage = ((double) sales / totalSalesCount) * 100;
        return Double.parseDouble(new DecimalFormat("0.00").format(totalPercentage));
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.printf("%-30s %-15d %13.2f\n", title, sales, calculatePercentage());
    }
}


public class BestsellerTest {
    public static void main(String[] args) {
        // Create individual Bestseller instances
        Bestseller book1 = new Bestseller("Batman", 115);
        Bestseller book2 = new Bestseller("Superman", 170);
        Bestseller book3 = new Bestseller("Wonder Woman", 110);
        Bestseller book4 = new Bestseller("Iron Man", 75);
        Bestseller book5 = new Bestseller("Aquaman", 165);

        // Display header
        System.out.printf("%-30s %-15s %13s\n", "Books", "Sales Received", "% of Total Sales");
        
        // Display details for each book
        book1.displayBookDetails();
        book2.displayBookDetails();
        book3.displayBookDetails();
        book4.displayBookDetails();
        book5.displayBookDetails();

        // Display total sales and best seller
        System.out.printf("Total \t\t\t\t %d\n", Bestseller.getTotalSalesCount());
        System.out.printf("\nThe Bestseller book is \"%s\".\n", Bestseller.getBestSellerTitle());
    }
}
