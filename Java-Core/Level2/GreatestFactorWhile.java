package Level2;

import java.util.Scanner;

public class GreatestFactorWhile {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();

        int greatestFactor = 1;
        int counter = num - 1;

        while (counter >= 1) {
            if (num % counter == 0) {
                greatestFactor = counter;
                break;
            }
            counter--;
        }
        System.out.println("Greatest factor besides " + num + " is: " + greatestFactor);
    }
}
