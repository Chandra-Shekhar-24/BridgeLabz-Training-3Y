import java.util.Scanner;

public class UniqueCharFrequency {
    static char[] findUniqueChars(String text) {
        int len = text.length();
        char[] temp = new char[len];
        int count = 0;
        outer: for(int i=0; i<len; i++) {
            char c = text.charAt(i);
            for(int j=0; j<i; j++) {
                if(text.charAt(j) == c) {
                    continue outer;
                }
            }
            temp[count++] = c;
        }
        char[] unique = new char[count];
        System.arraycopy(temp, 0, unique, 0, count);
        return unique;
    }

    static String[][] charFrequency(String text) {
        int[] freq = new int[256];
        int len = text.length();
        for(int i=0; i<len; i++) freq[(int)text.charAt(i)]++;

        char[] uniqueChars = findUniqueChars(text);
        String[][] res = new String[uniqueChars.length][2];
        for(int i=0; i<uniqueChars.length; i++) {
            res[i][0] = String.valueOf(uniqueChars[i]);
            res[i][1] = String.valueOf(freq[(int) uniqueChars[i]]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.nextLine();
        String[][] table = charFrequency(text);
        System.out.printf("%-10s%-10s%n", "Char", "Frequency");
        for(String[] row : table)
            System.out.printf("%-10s%-10s%n", row[0], row[1]);
        sc.close();
    }
}
