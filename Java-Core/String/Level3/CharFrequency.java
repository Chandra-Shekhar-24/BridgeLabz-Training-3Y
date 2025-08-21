import java.util.Scanner;

public class CharFrequency {
    static String[][] charFrequency(String text) {
        int[] freq = new int[256];
        int len = text.length();
        for (int i = 0; i < len; i++)
            freq[(int) text.charAt(i)]++;

        int count = 0;
        for(int i=0;i<256;i++) {
            if(freq[i]>0) count++;
        }

        String[][] result = new String[count][2];
        int idx=0;
        for(int i=0;i<256;i++) {
            if(freq[i]>0) {
                result[idx][0] = String.valueOf((char) i);
                result[idx][1] = String.valueOf(freq[i]);
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.nextLine();
        String[][] freqTable = charFrequency(text);
        System.out.printf("%-10s%-10s%n", "Char", "Frequency");
        for (String[] row : freqTable)
            System.out.printf("%-10s%-10s%n", row[0], row[1]);
        sc.close();
    }
}
