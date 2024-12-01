import java.util.Scanner;
public class CamelCase {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String[] newWord = word.split("-");
        /* //System.out.print("%s",newWord.toUpperCase(newWord.charAt(0)));
        StringBuilder initials = new StringBuilder();
        for (int i = 0; i < newWord.length - 1; i++) {
            initials.append(newWord[i].toUpperCase().charAt(0));
        }
        String newString = initials.toString();
        System.out.println(newString); */
         // Extract the last name
         //String lastName = nameParts[nameParts.length - 1];

         // Capitalize the first letter and keep the rest of the last name in lowercase
         //lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
 
    }
}
