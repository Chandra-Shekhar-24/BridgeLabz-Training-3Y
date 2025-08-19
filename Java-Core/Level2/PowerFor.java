package Level2;

import java.util.Scanner;

public class PowerFor {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.print("Enter power: ");
        int pow = sc.nextInt();

        int result = 1;
        for (int i = 1; i <= pow; i++) {
            result *= num;
        }
        System.out.println(num + "^" + pow + " = " + result);
    }
}
