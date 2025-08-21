import java.util.Scanner;

public class TrimSpacesUsingCharAt {

    static int[] findTrimIndices(String str) {
        int len = 0;
        try { while (true) { str.charAt(len); len++; } } catch (Exception e) {}
        int start = 0, end = len-1;
        while (start < len && str.charAt(start) == ' ') start++;
        while (end >= 0 && str.charAt(end) == ' ') end--;
        return new int[]{start, end+1};
    }

    static String substringWithCharAt(String str, int start, int end) {
        String s = "";
        for(int i=start; i<end; i++)
            s += str.charAt(i);
        return s;
    }

    static boolean compareWithCharAt(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();
        int[] indices = findTrimIndices(str);
        String trimmedCustom = substringWithCharAt(str, indices[0], indices[1]);
        String trimmedBuiltIn = str.trim();
        System.out.println("Custom Trim: '" + trimmedCustom + "'");
        System.out.println("Built-in Trim: '" + trimmedBuiltIn + "'");
        System.out.println("Are they equal? " + compareWithCharAt(trimmedCustom, trimmedBuiltIn));
        sc.close();
    }
}
