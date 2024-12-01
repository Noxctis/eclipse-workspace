package javaprogramming;

import java.util.Scanner;

public class ArrayAscending {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String value = "True";
        System.out.println("Number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("elements in array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int j = 0; j < n - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                value = "False";
                break;
            }
        }
        System.out.println(value);
    }
}
