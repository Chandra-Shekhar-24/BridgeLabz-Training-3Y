package Assignment1.SelfProblems;

import java.util.Scanner;

public class Ques1_ {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Principal amount (INR): ");
        double principal = sc.nextDouble();

        System.out.print("Enter the Rate of interest (%): ");
        double rate = sc.nextDouble();

        System.out.print("Enter the Time period (in years): ");
        double time = sc.nextDouble();

        double simpleInterest = (principal * rate * time) / 100;

        System.out.printf("The Simple Interest is INR %.2f%n", simpleInterest);

        sc.close();
    }
}
