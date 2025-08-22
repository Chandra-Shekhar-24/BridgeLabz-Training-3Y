import java.util.Scanner;
public class StudentScorecardQ_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        double[][] scorecard = new double[n][3];
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter marks for Student %d (Physics, Chemistry, Math): ", i + 1);
            int phy = sc.nextInt(), chem = sc.nextInt(), math = sc.nextInt();
            int total = phy + chem + math;
            double avg = total / 3.0;
            double perc = (total / 300.0) * 100;
            scorecard[i][0] = total;
            scorecard[i][1] = avg;
            scorecard[i][2] = perc;
        }
        System.out.println("\nScorecard:");
        System.out.println("Student\tTotal\tAverage\tPercentage");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.0f\t%.2f\t%.2f%%\n", i + 1, scorecard[i][0], scorecard[i][1], scorecard[i][2]);
        }
    }
}