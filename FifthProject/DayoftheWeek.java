/*
============================================================================
FILE : DayoftheWeek.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : Calculate the day of the week.
COPYRIGHT : 22-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/
import javax.swing.JOptionPane;
import java.util.Scanner;

public class DayoftheWeek {

    private int year, month, dayOfMonth;

    /**
     * Reads the input values (year, month, day) from the user and validates them.
     * 
     * Precondition: The user must input valid integers for the year, month, and day.
     * 
     * Postcondition: The instance variables `year`, `month`, and `dayOfMonth` are set to valid input values.
     */
    public void readInput() {
        Scanner keyInput = new Scanner(System.in);
        boolean validInput = false;

        // Validate and read year input
        while (!validInput) {
            System.out.println("Enter year (e.g., 2012):");
            try {
                year = keyInput.nextInt(); // Try to read an integer value
                if (year <= 0) {
                    System.out.println("Year must be a positive number. Please try again.");
                } else {
                    validInput = true; // Valid input, exit the loop
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid year.");
                keyInput.next(); // Clear the invalid input
            }
        }

        validInput = false;

        // Validate and read month input
        while (!validInput) {
            System.out.println("Enter month (1-12):");
            try {
                month = keyInput.nextInt(); // Try to read an integer value
                if (month < 1 || month > 12) {
                    System.out.println("Month must be between 1 and 12. Please try again.");
                } else {
                    validInput = true; // Valid input, exit the loop
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid month.");
                keyInput.next(); // Clear the invalid input
            }
        }

        validInput = false;

        // Validate and read day input
        while (!validInput) {
            System.out.println("Enter the day of the month (1-31):");
            try {
                dayOfMonth = keyInput.nextInt(); // Try to read an integer value
                if (dayOfMonth < 1 || dayOfMonth > 31) {
                    System.out.println("Day must be between 1 and 31. Please try again.");
                } else {
                    validInput = true; // Valid input, exit the loop
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid day.");
                keyInput.next(); // Clear the invalid input
            }
        }
        keyInput.close(); // Close the scanner
    }
    
    /**
     * Reads the input values (year, month, day) from the user via `JOptionPane` and validates them.
     * 
     * Precondition: The user must input valid integers for the year, month, and day through a `JOptionPane` dialog.
     * 
     * Postcondition: The instance variables `year`, `month`, and `dayOfMonth` are set to valid input values.
     */
    public void readInputGUI() {
        boolean validInput = false;

        // Validate and read year input
        while (!validInput) {
            try {
                String yearInput = JOptionPane.showInputDialog(null, "Enter year (e.g., 2012):", "Input", JOptionPane.QUESTION_MESSAGE);
                if (yearInput == null) {
                    JOptionPane.showMessageDialog(null, "Input cannot be empty. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                year = Integer.parseInt(yearInput); // Try to parse an integer value
                if (year <= 0) {
                    JOptionPane.showMessageDialog(null, "Year must be a positive number. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    validInput = true; // Valid input, exit the loop
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid year.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        validInput = false;

        // Validate and read month input
        while (!validInput) {
            try {
                String monthInput = JOptionPane.showInputDialog(null, "Enter month (1-12):", "Input", JOptionPane.QUESTION_MESSAGE);
                if (monthInput == null) {
                    JOptionPane.showMessageDialog(null, "Input cannot be empty. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                month = Integer.parseInt(monthInput); // Try to parse an integer value
                if (month < 1 || month > 12) {
                    JOptionPane.showMessageDialog(null, "Month must be between 1 and 12. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    validInput = true; // Valid input, exit the loop
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid month.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        validInput = false;

        // Validate and read day input
        while (!validInput) {
            try {
                String dayInput = JOptionPane.showInputDialog(null, "Enter the day of the month (1-31):", "Input", JOptionPane.QUESTION_MESSAGE);
                if (dayInput == null) {
                    JOptionPane.showMessageDialog(null, "Input cannot be empty. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                dayOfMonth = Integer.parseInt(dayInput); // Try to parse an integer value
                if (dayOfMonth < 1 || dayOfMonth > 31) {
                    JOptionPane.showMessageDialog(null, "Day must be between 1 and 31. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    validInput = true; // Valid input, exit the loop
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid day.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    /**
     * Adjusts the month for January and February, converting them to 13 and 14.
     * 
     * Precondition: The month is a valid number (1-12).
     * 
     * Postcondition: The month is converted to 13 or 14 if January or February is input.
     * 
     * @param month the original month input by the user.
     * @return the adjusted month value.
     */
    public int adjustMonth(int month) {
        if (month == 1) {
            month = 13; // Convert January to 13
        } else if (month == 2) {
            month = 14; // Convert February to 14
        }
        return month; // Return the original month for other months
    }

    /**
     * Adjusts the year if the month is January or February by decrementing it by 1.
     * 
     * Precondition: The month and year are valid.
     * 
     * Postcondition: The year is decremented by 1 if the month is January or February.
     * 
     * @param month the adjusted month.
     * @param year the original year input by the user.
     * @return the adjusted year.
     */
    public int adjustYear(int month, int year) {
        if (month == 13 || month == 14) {
            year = year - 1; // Decrement the year if January or February
        }
        return year; // Return unchanged year for other months
    }

    /**
     * Calculates the day of the week using Zeller's Congruence.
     * 
     * Precondition: The day, month, and year are valid values.
     * 
     * Postcondition: Returns the calculated day of the week as an integer (0 = Saturday, 1 = Sunday, ..., 6 = Friday).
     * 
     * @param dayOfMonth the day of the month.
     * @param month the adjusted month.
     * @param year the adjusted year.
     * @return the calculated day of the week.
     */
    public int calculateDayOfWeek(int dayOfMonth, int month, int year) {
        return (dayOfMonth + ((26 * (month + 1)) / 10) + (year % 100)
                + ((year % 100) / 4) + ((year / 100) / 4) + (5 * (year / 100))) % 7;
    }

    /**
     * Displays the calculated day of the week based on the integer value (0 = Saturday, 1 = Sunday, ..., 6 = Friday).
     * 
     * Precondition: The dayOfWeek value must be between 0 and 6.
     * 
     * Postcondition: The name of the day is printed to the console.
     * 
     * @param dayOfWeek the integer representing the calculated day of the week.
     */
    public void displayDayOfWeek(int dayOfWeek) {
        System.out.print("Day of the week is ");
        switch (dayOfWeek) {
            case 0:
                System.out.println("Saturday");
                break;
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
        }
    }

    /**
     * Executes all the steps to calculate and display the day of the week.
     * 
     * Precondition: The inputs (year, month, and dayOfMonth) must be valid.
     * 
     * Postcondition: The adjusted month, year, and calculated day of the week are displayed to the user.
     */
    public void writeOutput() {
        // Adjust month and year
        int adjustedMonth = adjustMonth(month);
        int adjustedYear = adjustYear(adjustedMonth, year);

        // Calculate the day of the week
        int dayOfWeek = calculateDayOfWeek(dayOfMonth, adjustedMonth, adjustedYear);

        // Display the result
        displayDayOfWeek(dayOfWeek);
    }
    
    /**
     * Executes all the steps to calculate and display the day of the week via `JOptionPane`.
     * 
     * Precondition: The inputs (year, month, and dayOfMonth) must be valid.
     * 
     * Postcondition: The adjusted month, year, and calculated day of the week are displayed to the user using `JOptionPane`.
     */
    public void writeOutputGUI() {
        // Adjust month and year
        int adjustedMonth = adjustMonth(month);
        int adjustedYear = adjustYear(adjustedMonth, year);

        // Calculate the day of the week
        int dayOfWeek = calculateDayOfWeek(dayOfMonth, adjustedMonth, adjustedYear);

        // Display the result using JOptionPane
        String dayOfWeekString = "";
        switch (dayOfWeek) {
            case 0:
                dayOfWeekString = "Saturday";
                break;
            case 1:
                dayOfWeekString = "Sunday";
                break;
            case 2:
                dayOfWeekString = "Monday";
                break;
            case 3:
                dayOfWeekString = "Tuesday";
                break;
            case 4:
                dayOfWeekString = "Wednesday";
                break;
            case 5:
                dayOfWeekString = "Thursday";
                break;
            case 6:
                dayOfWeekString = "Friday";
                break;
        }

        JOptionPane.showMessageDialog(null, "Day of the week is " + dayOfWeekString, "Day of the week Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
