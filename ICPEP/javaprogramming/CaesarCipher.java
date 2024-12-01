package javaprogramming;

import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        
        int shift = scanner.nextInt();
        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    char c = (char) (ch + shift);
                    if (c > 'z') {
                        newWord.append((char) (ch - (26 - shift)));
                    } else {
                        newWord.append(c);
                    }
                } else if (Character.isUpperCase(ch)) {
                    char c = (char) (ch + shift);
                    if (c > 'Z') {
                        newWord.append((char) (ch - (26 - shift)));
                    } else {
                        newWord.append(c);
                    }
                }
            } else {
                newWord.append(ch);
            }
        }
    }
}
