package Assignment2.Level2;

import java.util.Scanner;

public class Ques7 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of a: ");
        int a = sc.nextInt();

        System.out.print("Enter value of b: ");
        int b = sc.nextInt();

        System.out.print("Enter value of c: ");
        int c = sc.nextInt();

        int result1 = a + b * c;
        int result2 = a * b + c;
        int result3 = c + a / b;
        int result4 = a % b + c;

        System.out.printf("The results of Int Operations are %d, %d, %d, and %d%n",
                          result1, result2, result3, result4);

        sc.close();
    }
}
