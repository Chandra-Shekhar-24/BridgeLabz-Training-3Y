package Level2;
import java.util.Scanner;
public class StudentGrade2D {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] marks = new int[n][3];
        double[] percent = new double[n];
        String[] grade = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));
            for (int j = 0; j < 3; j++) {
                do {
                    System.out.print((j == 0 ? "Physics: " : j == 1 ? "Chemistry: " : "Maths: "));
                    marks[i][j] = sc.nextInt();
                } while (marks[i][j] < 0);
            }
            percent[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            grade[i] = (percent[i] >= 80) ? "A" :
                       (percent[i] >= 70) ? "B" :
                       (percent[i] >= 60) ? "C" :
                       (percent[i] >= 50) ? "D" :
                       (percent[i] >= 40) ? "E" : "R";
        }
        System.out.println("\n--- Results ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d -> Physics:%d Chemistry:%d Maths:%d | Percentage: %.2f | Grade: %s\n",
            i+1, marks[i][0], marks[i][1], marks[i][2], percent[i], grade[i]);
        }
    }
}
