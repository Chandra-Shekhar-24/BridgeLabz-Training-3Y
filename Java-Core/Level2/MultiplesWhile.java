package Level2;

import java.util.Scanner;

public class MultiplesWhile {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number less than 100: ");
        int num = sc.nextInt();

        int counter = 100;
        System.out.println("Multiples of " + num + " below 100:");
        while (counter > 1) {
            if (counter % num == 0) {
                System.out.println(counter);
            }
            counter--;
        }
    }
}
