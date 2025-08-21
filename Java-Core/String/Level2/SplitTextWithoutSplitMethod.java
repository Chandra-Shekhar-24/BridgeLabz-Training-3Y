import java.util.Scanner;

public class SplitTextWithoutSplitMethod {
    static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // Index out of bounds
        }
        return count;
    }

    static String[] splitWords(String text) {
        int len = getLength(text);
        int words = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ')
                words++;
        }
        words++;
        String[] result = new String[words];
        int idx = 0, wordStart = 0;
        for (int i = 0; i <= len; i++) {
            if (i == len || text.charAt(i) == ' ') {
                String temp = "";
                for (int k = wordStart; k < i; k++)
                    temp += text.charAt(k);
                result[idx++] = temp;
                wordStart = i + 1;
            }
        }
        return result;
    }

    static boolean compareArrays(String[] a1, String[] a2) {
        if (a1.length != a2.length) return false;
        for (int i = 0; i < a1.length; i++)
            if (!a1[i].equals(a2[i])) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String[] wordsUser = splitWords(text);
        String[] wordsBuiltIn = text.split(" ");
        System.out.println("Arrays are equal? " + compareArrays(wordsUser, wordsBuiltIn));
        sc.close();
    }
}
