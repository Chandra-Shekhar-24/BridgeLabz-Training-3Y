package Assignment2.Level2;

import java.util.Scanner;

public class Ques8 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Integer operations
        System.out.println("=== IntOperation ===");
        System.out.print("Enter integer value of a: ");
        int a = sc.nextInt();
        System.out.print("Enter integer value of b: ");
        int b = sc.nextInt();
        System.out.print("Enter integer value of c: ");
        int c = sc.nextInt();

        int intResult1 = a + b * c;
        int intResult2 = a * b + c;
        int intResult3 = c + a / b;
        int intResult4 = a % b + c;

        System.out.printf("The results of Int Operations are %d, %d, %d, and %d%n",
                          intResult1, intResult2, intResult3, intResult4);

        // Double operations
        System.out.println("\n=== DoubleOpt ===");
        System.out.print("Enter double value of a: ");
        double da = sc.nextDouble();
        System.out.print("Enter double value of b: ");
        double db = sc.nextDouble();
        System.out.print("Enter double value of c: ");
        double dc = sc.nextDouble();

        double doubleResult1 = da + db * dc;
        double doubleResult2 = da * db + dc;
        double doubleResult3 = dc + da / db;
        double doubleResult4 = da % db + dc;

        System.out.printf("The results of Double Operations are %.2f, %.2f, %.2f, and %.2f%n",
                          doubleResult1, doubleResult2, doubleResult3, doubleResult4);

        sc.close();
    }
}
