import java.util.Scanner;

public class ShortestLongestWord {
    static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    static String[] splitWords(String text) {
        int len = getLength(text);
        int words = 0;
        for (int i = 0; i < len; i++) if (text.charAt(i) == ' ') words++;
        words++;
        String[] result = new String[words];
        int idx = 0, wordStart = 0;
        for (int i = 0; i <= len; i++) {
            if (i == len || text.charAt(i) == ' ') {
                String temp = "";
                for (int k = wordStart; k < i; k++) temp += text.charAt(k);
                result[idx++] = temp;
                wordStart = i + 1;
            }
        }
        return result;
    }

    static String[][] wordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(getLength(words[i]));
        }
        return table;
    }

    static int[] shortestLongest(String[][] table) {
        int minIdx = 0, maxIdx = 0;
        int minLen = Integer.parseInt(table[0][1]);
        int maxLen = minLen;
        for (int i = 1; i < table.length; i++) {
            int len = Integer.parseInt(table[i][1]);
            if (len < minLen) {
                minLen = len; minIdx = i;
            }
            if (len > maxLen) {
                maxLen = len; maxIdx = i;
            }
        }
        return new int[]{minIdx, maxIdx};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String[] words = splitWords(text);
        String[][] table = wordLengthTable(words);
        int[] result = shortestLongest(table);
        System.out.println("Shortest word: " + table[result[0]][0] + ", Length: " + table[result[0]][1]);
        System.out.println("Longest word: " + table[result[1]][0] + ", Length: " + table[result[1]][1]);
        sc.close();
    }
}
