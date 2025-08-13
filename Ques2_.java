package Assignment1.SelfProblems;

import java.util.Scanner;

public class Ques2_ {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the rectangle: ");
        double length = sc.nextDouble();

        System.out.print("Enter the width of the rectangle: ");
        double width = sc.nextDouble();

        double perimeter = 2 * (length + width);

        System.out.printf("The perimeter of the rectangle is %.2f%n", perimeter);

        sc.close();
    }
}
