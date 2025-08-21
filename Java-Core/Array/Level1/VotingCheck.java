import java.util.Scanner;

public class VotingCheck{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] age = new int[3];

        for (int i = 0; i < age.length; i++) {
            System.out.println("Enter age of student " + (i+1) + ": " );
            age[i] = sc.nextInt();
        }

        for (int i = 0; i < age.length; i++) {
            if(age[i]>=18){
                System.out.println("The student with the age " + age[i] + " can vote.");
            }
            else if(age[i]<0){
                System.out.println("invalid age " + age[i]);
            }
            else{
                System.out.println("The student with the age " + age[i] +" cannot vote. ");
            }
        }
    }
}