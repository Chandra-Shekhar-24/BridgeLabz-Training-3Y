package OOPS50QUES;
interface Graded {
    void assignGrade(Enrollment enrollment, String grade);
}

abstract class Student{
    private String name;
    private int id;
    private double gpa;

    public Student(String name, int id){
        this.name = name;
        this.id = id;
        this.gpa = 0.0;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public double getGpa(){
        return gpa;
    }

    public void updategpa(double gradepoint){
        this.gpa = (this.gpa + gradepoint)/2;
    }

    public void getreportcard(){
        System.out.println("Name: " + name + ", Id : " + id + ", Gpa: " + gpa);
    }

    public abstract void displayInfo();
}

class Undergraduate extends Student {
    public Undergraduate(String name, int id) {
        super(name, id);
    }

    public void displayInfo() {
        System.out.println("Undergraduate Student: " + getName() + ", ID: " + getId());
    }
}

class Postgraduate extends Student {
    public Postgraduate(String name, int id) {
        super(name, id);
    }

    @Override
    public void displayInfo() {
        System.out.println("Postgraduate Student: " + getName() + ", ID: " + getId());
    }
}

class Course{
    private String courseName;
    private String courseCode;

    public Course(String courseName,String courseCode){
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getCourseName(){
        return courseName;
    }

    public String getCourseCode(){
        return courseCode;
    }

    public void displayInfo(){
        System.out.println("Course: " + courseName + " ("+courseCode+")");
    }
}

class Faculty implements Graded{
    private String name;

    public Faculty(String name){
        this.name = name;
    }

    public void assignGrade(Enrollment enrollment, String grade){
        double points = 0.0;
        if(grade.equals("A")) points=10.0;
        else if(grade.equals("B")) points=9.0;
        else if(grade.equals("C")) points=8.0;
        else if(grade.equals("D")) points=7.0;

        enrollment.setGrade(grade, points);
        System.out.println(name + " assigned " + grade + " to " + enrollment.getStudent().getName());
    }
}

class PassFailFaculty implements Graded {
    private String name;

    public PassFailFaculty(String name) {
        this.name = name;
    }

    @Override
    public void assignGrade(Enrollment enrollment, String grade) {
        double gradePoint = grade.equalsIgnoreCase("Pass") ? 3.0 : 0.0;
        enrollment.setGrade(grade, gradePoint);
        System.out.println("Faculty " + name + " assigned Pass/Fail grade " + grade + " to " + enrollment.getStudent().getName());
    }
}


class Enrollment {
    private Student student;
    private Course course;
    private String grade;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade, double gradePoint) {
        this.grade = grade;
        student.updategpa(gradePoint);
    }

    public void displayEnrollment() {
        String showGrade;
        if (grade == null) {
            showGrade = "N/A";
        } else {
            showGrade = grade;
        }
        System.out.println(student.getName() + " enrolled in " + course.getCourseName() + " Grade: " + showGrade);
    }
}

public class UniversityCourseEnroolmentSystem {
    public static void main(String[] args) {
        Student s1 = new Undergraduate("Amit",101);
        Student s2 = new Postgraduate("Luckhy",202);

        Course c1 = new Course("Data Structures", "CS201");
        Course c2 = new Course("Machine Learning", "CS501");

        Enrollment e1 = new Enrollment(s1, c1);
        Enrollment e2 = new Enrollment(s2, c2);

        Faculty f1 = new Faculty("Dr. Sharma");
        PassFailFaculty f2 = new PassFailFaculty("Prof. Mehta");

        s1.displayInfo();
        s2.displayInfo();

        c1.displayInfo();
        c2.displayInfo();

        f1.assignGrade(e1, "A");
        f2.assignGrade(e2, "Pass");

        e1.displayEnrollment();
        e2.displayEnrollment();

        s1.getreportcard();
        s2.getreportcard();
    }
}