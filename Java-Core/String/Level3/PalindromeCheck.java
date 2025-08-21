import java.util.Scanner;

public class PalindromeCheck {

    static boolean isPalindromeIterative(String text) {
        int start = 0, end = text.length()-1;
        while(start < end) {
            if(text.charAt(start) != text.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text, int start, int end) {
        if(start >= end) return true;
        if(text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start+1, end-1);
    }

    static boolean isPalindromeByReverse(String text) {
        char[] original = text.toCharArray();
        int n = original.length;
        char[] reverse = new char[n];
        for(int i=0; i<n; i++)
            reverse[i] = text.charAt(n-1-i);
        for(int i=0; i<n; i++) {
            if(original[i] != reverse[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.println("Iterative: " + (isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive: " + (isPalindromeRecursive(text, 0, text.length()-1) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Reverse Check: " + (isPalindromeByReverse(text) ? "Palindrome" : "Not Palindrome"));
        sc.close();
    }
}
