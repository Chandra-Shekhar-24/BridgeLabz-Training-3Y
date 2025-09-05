class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
        System.out.println("------------------------");
    }
}

class PostgraduateStudent extends Student {
    private String specialization;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    public void displayPostgraduateDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + getCGPA());
        System.out.println("Specialization: " + specialization);
        System.out.println("------------------------");
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Ravi Kumar", 8.2);
        PostgraduateStudent pg1 = new PostgraduateStudent(201, "Priya Sharma", 9.1, "Data Science");

        s1.displayDetails();
        pg1.displayPostgraduateDetails();

        s1.setCGPA(8.8);
        System.out.println("Updated CGPA of Ravi Kumar: " + s1.getCGPA());
    }
}
