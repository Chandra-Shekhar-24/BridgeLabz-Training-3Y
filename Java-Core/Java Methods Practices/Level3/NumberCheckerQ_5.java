public class NumberCheckerQ_5 {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static boolean isNeon(int n) {
        int sq = n * n;
        int sum = 0;
        while (sq > 0) {
            sum += sq % 10;
            sq /= 10;
        }
        return sum == n;
    }
    public static boolean isSpy(int n) {
        int sum = 0, prod = 1;
        int temp = n;
        while (temp > 0) {
            int d = temp % 10;
            sum += d;
            prod *= d;
            temp /= 10;
        }
        return sum == prod;
    }
    public static boolean isAutomorphic(int n) {
        String sq = String.valueOf(n * n);
        return sq.endsWith(String.valueOf(n));
    }
    public static boolean isBuzz(int n) {
        return (n % 7 == 0 || n % 10 == 7);
    }
    public static void main(String[] args) {
        int number = 25;
        System.out.println("Number: " + number);
        System.out.println("Is Prime? " + isPrime(number));
        System.out.println("Is Neon? " + isNeon(number));
        System.out.println("Is Spy? " + isSpy(number));
        System.out.println("Is Automorphic? " + isAutomorphic(number));
        System.out.println("Is Buzz? " + isBuzz(number));
    }
}