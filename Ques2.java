package Assignment1.AssistedProblems;

import java.util.Scanner;

public class Ques2 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double number1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double number2 = sc.nextDouble();

        double sum = number1 + number2;

        System.out.println("The sum of " + number1 + " and " + number2 + " is " + sum);

        sc.close();
    }
}
