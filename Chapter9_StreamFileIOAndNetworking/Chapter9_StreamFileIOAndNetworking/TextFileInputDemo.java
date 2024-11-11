import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileInputDemo
{
    public static void main(String[] args)
    {
        String fileName = "out.txt";
        String outputFileName ="output.txt";
        Scanner inputStream = null;
        PrintWriter outputStream = null;
        
        System.out.println("The file " + fileName + 
                           "\ncontains the following lines:\n");
                           
       try
       {
           inputStream = new Scanner(new File(fileName));
           outputStream = new PrintWriter(outputFileName);
       }
       catch(FileNotFoundException e)
       {
           System.out.println("Error opening the file " + 
                               fileName);
           System.exit(0);
       }
       
       while (inputStream.hasNextLine())
       {
           String line = inputStream.nextLine();
           System.out.println(line);
           outputStream.println(" "+ line);
       }
       inputStream.close();
       outputStream.close();
    }
}