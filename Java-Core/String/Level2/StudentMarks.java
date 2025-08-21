import java.util.*;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];   // Physics, Chemistry, Maths
        int[] total = new int[n];
        double[] percent = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = 40 + rand.nextInt(61); // random marks 40-100
                total[i] += marks[i][j];
            }
            percent[i] = Math.round((total[i] / 300.0) * 10000) / 100.0;

            if (percent[i] >= 80) grade[i] = "A";
            else if (percent[i] >= 70) grade[i] = "B";
            else if (percent[i] >= 60) grade[i] = "C";
            else if (percent[i] >= 50) grade[i] = "D";
            else if (percent[i] >= 40) grade[i] = "E";
            else grade[i] = "R";
        }

        System.out.printf("%-8s %-8s %-8s %-8s %-8s %-10s %-6s%n",
                "Stu", "Phy", "Chem", "Math", "Total", "Percent", "Grade");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-8d %-8d %-8d %-8d %-8d %-10.2f %-6s%n",
                    (i + 1), marks[i][0], marks[i][1], marks[i][2],
                    total[i], percent[i], grade[i]);
        }
    }
}
