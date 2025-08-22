import java.util.Arrays;
public class NumberCheckerQ_4 {

    public static int countDigits(int n) {
        return String.valueOf(n).length();
    }

    public static int[] getDigits(int n) {
        String s = String.valueOf(n);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return digits;
    }

    public static int[] reverseArray(int[] arr) {
        int[] rev = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }
        return rev;
    }

    public static boolean arraysEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean isPalindrome(int n) {
        int[] digits = getDigits(n);
        int[] rev = reverseArray(digits);
        return arraysEqual(digits, rev);
    }

    public static boolean isDuck(int n) {
        int[] digits = getDigits(n);
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 707;
        int[] digits = getDigits(number);

        System.out.println("Number: " + number);
        System.out.println("Count of Digits: " + countDigits(number));
        System.out.println("Digits Array: " + Arrays.toString(digits));
        System.out.println("Reversed Digits: " + Arrays.toString(reverseArray(digits)));
        System.out.println("Is Palindrome? " + isPalindrome(number));
        System.out.println("Is Duck Number? " + isDuck(number));
    }
}
