package Assignment2.Level2;

import java.util.Scanner;

public class Ques6 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = sc.nextInt();

        int quotient = number1 / number2;
        int remainder = number1 % number2;

        System.out.printf("The Quotient is %d and Remainder is %d of two numbers %d and %d%n",
                          quotient, remainder, number1, number2);

        sc.close();
    }
}
