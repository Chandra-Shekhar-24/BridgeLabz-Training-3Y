import java.util.Random;

public class VotingEligibility {

    static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++)
            ages[i] = rand.nextInt(90) + 10; // Random 2-digit age, 10-99
        return ages;
    }

    static String[][] votingTable(int[] ages) {
        String[][] arr = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            arr[i][0] = String.valueOf(ages[i]);
            arr[i][1] = (ages[i] >= 18 ? "Yes" : "No");
            if (ages[i] < 0) arr[i][1] = "No";
        }
        return arr;
    }

    static void displayTable(String[][] arr) {
        System.out.println("Age	CanVote");
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i][0] + "	" + arr[i][1]);
    }

    public static void main(String[] args) {
        int[] ages = generateAges(10);
        String[][] table = votingTable(ages);
        displayTable(table);
    }
}
