import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileInputDemo {
    public static void main(String[] args) {
        String inputFileName = "out.txt";
        String outputFileName = "output.txt";

        try (Scanner inputStream = new Scanner(new File(inputFileName));
             PrintWriter outputStream = new PrintWriter(outputFileName)) {

            while (inputStream.hasNext()) {
                String word = inputStream.next(); // Read word by word
                outputStream.print(word + " "); // Write each word to output.txt
            }

            System.out.println("Words from " + inputFileName + " have been written to " + outputFileName);

        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + inputFileName);
            e.printStackTrace(); // Print stack trace for debugging
        }
    }
}
