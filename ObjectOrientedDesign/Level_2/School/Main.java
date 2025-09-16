public class Main {
    public static void main(String[] args) {
        // Create a Student
        Student john = new Student("John");

        // Add subjects with marks
        john.addSubject(new Subject("Maths", 90));
        john.addSubject(new Subject("Science", 85));
        john.addSubject(new Subject("English", 78));

        // Calculate grade
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.calculateGrade(john);

        // Print result
        System.out.println("Student: " + john.getName());
        for (Subject s : john.getSubjects()) {
            System.out.println(" - " + s.getName() + ": " + s.getMarks());
        }
        System.out.println("Final Grade: " + grade);
    }
}
