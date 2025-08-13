package Assignment1.SelfProblems;

import java.util.Scanner;

public class Ques3_ {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the base: ");
        double base = sc.nextDouble();

        System.out.print("Enter the exponent: ");
        double exponent = sc.nextDouble();

        double result = Math.pow(base, exponent);

        System.out.printf("%.2f raised to the power %.2f is %.2f%n", base, exponent, result);

        sc.close();
    }
}
