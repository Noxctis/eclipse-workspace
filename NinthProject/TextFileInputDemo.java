import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileInputDemo
{
    public static void main(String[] args)
    {
        String fileName = "out.txt";
        String newfileName = "output.txt";
        Scanner inputStream = null;
        PrintWriter outputStream = null;
        System.out.println("The file " + newfileName + 
                           "\ncontains the following lines:\n");
                           
       try
       {
           inputStream = new Scanner(new File(fileName));
       }
       catch(FileNotFoundException e)
       {
           System.out.println("Error opening the file " + 
                               fileName);
           System.exit(0);
       }
       
       try //new file
       {
       outputStream = new PrintWriter(newfileName);
       }
       catch(FileNotFoundException e)
       {
       System.out.println("Error opening the file " + 
       newfileName);
       System.exit(0);
       }
       
       while (inputStream.hasNextLine())
       {
           String line = inputStream.nextLine();
//           for (int count = 1; count <= 3; count++)
//           {
               outputStream.println(line);
       
       }
       
       inputStream.close();
       outputStream.close();

   }
       
    }