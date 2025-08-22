import java.util.Scanner;

public class StudentVoteChecker {
    public boolean canStudentVote(int age) {
        if(age < 0) return false;
        if(age >= 18) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        StudentVoteChecker checker = new StudentVoteChecker();
        for(int i = 0; i < 10; i++) {
            System.out.print("Enter age of student " + (i+1) + ": ");
            ages[i] = sc.nextInt();
        }
        for(int i = 0; i < 10; i++) {
            System.out.println("Student " + (i+1) + " can vote: " + checker.canStudentVote(ages[i]));
        }
        sc.close();
    }
}
