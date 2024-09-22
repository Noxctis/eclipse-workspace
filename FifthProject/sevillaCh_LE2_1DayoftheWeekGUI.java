/*
============================================================================
FILE :sevillaCh_LE2_1DayoftheWeekGUI.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : Calculate the day of the week.
COPYRIGHT : 22-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/
public class sevillaCh_LE2_1DayoftheWeekGUI {

    public static void main(String[] args) {
        // Create an object of the class
    	DayoftheWeek day = new DayoftheWeek();

        // Read input
        day.readInputGUI();

        // Call writeOutput to calculate and display the result
        day.writeOutputGUI();
    }
}
