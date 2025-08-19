import java.util.*;
public class NaturalSumWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n >= 0) {
            int sumFormula = n * (n + 1) / 2;

            int sumLoop = 0, i = 1;
            while (i <= n) {
                sumLoop += i;
                i++;
            }
            System.out.println("Formula result: " + sumFormula);
            System.out.println("Loop result: " + sumLoop);
        } else {
            System.out.println("Not a natural number");
        }
    }
}
