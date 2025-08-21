import java.util.Scanner;

public class SubstringDemo {

    // Method to create substring using charAt()
    public static String substringWithCharAt(String str, int start, int end) {
        String result = "";
        for(int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    // Method to compare substrings
    public static boolean compareWithCharAt(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String userDefinedSub = substringWithCharAt(text, start, end);
        String builtInSub = text.substring(start, end);

        System.out.println("UserDefined Substring: " + userDefinedSub);
        System.out.println("BuiltIn Substring: " + builtInSub);
        System.out.println("Are they equal? " + compareWithCharAt(userDefinedSub, builtInSub));
        sc.close();
    }
}
