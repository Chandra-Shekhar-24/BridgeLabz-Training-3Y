
public class StudentsGrades {
    String name;
    String rollNumber;
    double[] marks;

    // Constructor
    StudentsGrades(String name, String rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Calculate grade
    public String calculateGrade() {
        double avgMarks = calculateAverageMarks();
        if (avgMarks >= 80) return "Grade A";
        else if (avgMarks >= 60) return "Grade B";
        else if (avgMarks >= 50) return "Grade C";
        else if (avgMarks >= 40) return "Grade D";
        else return "Grade F";
    }

    // Calculate average marks
    public double calculateAverageMarks() {
        double sum = 0;
        for (double m : marks) {
            sum += m;
        }
        return sum / marks.length;
    }

    // Display student details
    public void displayStudent() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Mark " + (i + 1) + ": " + marks[i]);
        }
        System.out.println(calculateGrade());
        System.out.println("-----------------");
    }

    public static void main(String[] args) {
        double[] mark1 = {80, 70, 75};
        double[] mark2 = {60, 65, 50};

        StudentsGrades s1 = new StudentsGrades("Thamarai", "ECE001", mark1);
        StudentsGrades s2 = new StudentsGrades("Kannan", "CSC002", mark2);

        s1.displayStudent();
        s2.displayStudent();
    }
}