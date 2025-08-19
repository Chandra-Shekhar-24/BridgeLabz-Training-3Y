package Level2;

import java.util.Scanner;

public class MultipleFor {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number less than 100: ");
        int num = sc.nextInt();

        System.out.println("Multiples of " + num + " below 100:");
        for (int i = 100; i >= 1; i--) {
            if (i % num == 0) {
                System.out.println(i);
            }
        }
    }
}
