package Level2;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int temp = num, count = 0;
        while (temp != 0) { count++; temp /= 10; }

        int[] digits = new int[count];
        for (int i = 0; i < count; i++) {
            digits[i] = num % 10;
            num /= 10;
        }

        System.out.println("Reversed Number:");
        for (int d : digits) System.out.print(d);

        sc.close();
    }
}
