import java.util.Scanner;

public class UniqueCharacters {
    static int getLength(String str) {
        int count = 0;
        try {
            while(true) {
                str.charAt(count);
                count++;
            }
        } catch(Exception e) {}
        return count;
    }

    static char[] findUniqueChars(String text) {
        int length = getLength(text);
        char[] temp = new char[length];
        int uniqueCount = 0;

        outer: for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == c) {
                    continue outer;
                }
            }
            temp[uniqueCount++] = c;
        }

        char[] unique = new char[uniqueCount];
        System.arraycopy(temp, 0, unique, 0, uniqueCount);
        return unique;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        char[] uniqueChars = findUniqueChars(text);
        System.out.print("Unique characters: ");
        for(char c : uniqueChars) {
            System.out.print(c + " ");
        }
        sc.close();
    }
}
