package javaprogramming;

import java.util.Scanner;

public class GreatestNumberToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        processArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        scanner.close();
    }

    public static void processArray(int[] arr) {
        int n = arr.length;
        int maxFromRight = arr[n - 1];
        arr[n - 1] = -1; // Last element is always replaced with -1

        for (int i = n - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = maxFromRight;
            if (temp > maxFromRight) {
                maxFromRight = temp;
            }
        }
    }
}
//Test case
//17 18 4 5 6 3
//Output
//17 18 6 6 6 -1

//400
//-1
