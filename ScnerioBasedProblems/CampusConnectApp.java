package OOPS50QUES;
import java.util.ArrayList;
import java.util.List;

abstract class Person {
    protected String name;
    protected String email;
    protected String id;

    public Person(String name, String email, String id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public abstract void printDetails();
}

interface ICourseActions {
    void enrollCourse(Course course);
    void dropCourse(Course course);
}

class Student extends Person implements ICourseActions {
    private List<Course> enrolledCourses;
    private List<Double> grades;

    public Student(String name, String email, String id) {
        super(name, email, id);
        this.enrolledCourses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    @Override
    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    @Override
    public void dropCourse(Course course) {
        enrolledCourses.remove(course);
        course.removeStudent(this);
        System.out.println(name + " dropped " + course.getCourseName());
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (double g : grades) sum += g;
        return sum / grades.size();
    }

    @Override
    public void printDetails() {
        System.out.println("Student: " + name + " | Email: " + email + " | ID: " + id);
        System.out.println("Enrolled Courses: " + enrolledCourses.size());
        System.out.println("GPA: " + calculateGPA());
    }
}

class Faculty extends Person {
    private List<Course> teachingCourses;

    public Faculty(String name, String email, String id) {
        super(name, email, id);
        this.teachingCourses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        teachingCourses.add(course);
        course.setFaculty(this);
        System.out.println(name + " assigned to " + course.getCourseName());
    }

    @Override
    public void printDetails() {
        System.out.println("Faculty: " + name + " | Email: " + email + " | ID: " + id);
        System.out.println("Courses Teaching: " + teachingCourses.size());
    }
}

class Course {
    private String courseName;
    private Faculty faculty;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void showCourseDetails() {
        System.out.println("Course: " + courseName);
        if (faculty != null)
            System.out.println("Faculty: " + faculty.name);
        System.out.println("Enrolled Students: " + students.size());
    }
}

public class CampusConnectApp {
    public static void main(String[] args) {
        Faculty f1 = new Faculty("Dr. Meera", "meera@college.edu", "F101");
        Student s1 = new Student("Arjun", "arjun@college.edu", "S001");
        Student s2 = new Student("Priya", "priya@college.edu", "S002");

        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Database Systems");

        f1.assignCourse(c1);
        f1.assignCourse(c2);

        s1.enrollCourse(c1);
        s1.enrollCourse(c2);

        s2.enrollCourse(c1);

        s1.addGrade(8.5);
        s1.addGrade(9.0);
        s2.addGrade(7.0);

        System.out.println();
        f1.printDetails();
        s1.printDetails();
        s2.printDetails();

        System.out.println();
        c1.showCourseDetails();
        c2.showCourseDetails();
    }
}
