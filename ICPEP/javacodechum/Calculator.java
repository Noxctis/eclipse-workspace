package javacodechum;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double firstNum, secondNum;
        double result = 0;
        char operator;
    
        System.out.println("Enter the first number: ");
        firstNum = sc.nextDouble();
        System.out.println("Enter the second number: ");
        secondNum = sc.nextDouble();
        System.out.println("Enter the operator: ");
        operator = sc.next().charAt(0);
        
        switch(operator){
            case '+':
                result = firstNum + secondNum;
                System.out.println("The sum is: " + result);
                break;
            case '-':
                result = firstNum - secondNum;
                System.out.println("The difference is: " + result);
                break;
            case '*':
                result = firstNum * secondNum;
                System.out.println("The product is: " + result);
                break;
            case '/':
                result = firstNum / secondNum;
                System.out.println("The quotient is: " + result);
                break;
            default:
                System.out.println("Invalid operator");
        }
        System.out.printf("Result: %.2f", result);
    }
    
}
