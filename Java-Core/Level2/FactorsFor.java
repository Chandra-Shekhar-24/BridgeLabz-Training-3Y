package Level2;

import java.util.Scanner;

public class FactorsFor {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int num = sc.nextInt();

        System.out.println("Factors of " + num + ": ");
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                System.out.println(i);
            }
        }
    }
}
