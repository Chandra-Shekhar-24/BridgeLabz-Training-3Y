package Assignment1.SelfProblems;

import java.util.Scanner;

public class Ques4_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = sc.nextDouble();

        System.out.print("Enter the third number: ");
        double num3 = sc.nextDouble();

        double average = (num1 + num2 + num3) / 3;

        System.out.printf("The average of %.2f, %.2f, and %.2f is %.2f%n", num1, num2, num3, average);

        sc.close();
    }
}
