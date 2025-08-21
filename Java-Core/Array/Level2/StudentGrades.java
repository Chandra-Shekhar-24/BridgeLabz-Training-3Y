package Level2;

import java.util.Scanner;

public class StudentGrades {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));
            int phy, chem, math;
            do { System.out.print("Physics: "); phy = sc.nextInt(); } while (phy < 0);
            do { System.out.print("Chemistry: "); chem = sc.nextInt(); } while (chem < 0);
            do { System.out.print("Maths: "); math = sc.nextInt(); } while (math < 0);

            double per = (phy + chem + math) / 3.0;
            String grade = (per >= 80) ? "A" :
                           (per >= 70) ? "B" :
                           (per >= 60) ? "C" :
                           (per >= 50) ? "D" :
                           (per >= 40) ? "E" : "R";

            System.out.printf("Marks: %d %d %d | Percentage: %.2f | Grade: %s\n",
                              phy, chem, math, per, grade);
        }
    }
}
