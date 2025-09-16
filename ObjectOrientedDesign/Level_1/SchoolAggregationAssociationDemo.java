import java.util.*;

class Course {
    private String courseName;
    private List<Student> students = new ArrayList<>();
    public Course(String courseName) { this.courseName = courseName; }
    public void enrollStudent(Student s) {
        students.add(s);
        s.addCourse(this);
    }
    public void showEnrolled() {
        System.out.println("Course: " + courseName);
        for (Student s : students) System.out.println(" - " + s.getName());
    }
}

class Student {
    private String name;
    private List<Course> courses = new ArrayList<>();
    public Student(String name) { this.name = name; }
    public String getName() { return name; }
    public void addCourse(Course c) { courses.add(c); }
    public void showCourses() {
        System.out.println(name + " enrolled in:");
        for (Course c : courses) System.out.println(" - " + c.courseName);
    }
}

class School {
    private String name;
    private List<Student> students = new ArrayList<>();
    public School(String name) { this.name = name; }
    public void addStudent(Student s) { students.add(s); }
    public void showStudents() {
        System.out.println("School: " + name);
        for (Student s : students) System.out.println(" - " + s.getName());
    }
}

public class SchoolAggregationAssociationDemo {
    public static void main(String[] args) {
        School school = new School("Springfield High");
        Student s1 = new Student("Rahul");
        Student s2 = new Student("Priya");

        school.addStudent(s1);
        school.addStudent(s2);

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        c1.enrollStudent(s1);
        c2.enrollStudent(s1);
        c2.enrollStudent(s2);

        school.showStudents();
        s1.showCourses();
        c2.showEnrolled();
    }
}
