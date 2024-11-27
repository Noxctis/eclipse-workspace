import java.util.Scanner;
public class Exercise5 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        int[] nums = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        
        System.out.print("Original Array: ");
        printArray(nums);
        
        moveZeroes(nums);
        
        System.out.print("Modified Array: ");
        printArray(nums);
        
        scanner.close();
    }
    

    public static void moveZeroes(int[] nums) {
        int index = 0; 
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}