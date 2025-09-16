import java.util.*;

class Professor {
    private String name;
    public Professor(String name){ this.name=name; }
    public String getName(){ return name; }
}

class CourseUMS {
    private String courseName;
    private Professor professor;
    private List<StudentUMS> students = new ArrayList<>();
    public CourseUMS(String courseName){ this.courseName=courseName; }
    public void assignProfessor(Professor p){ this.professor=p; }
    public void enroll(StudentUMS s){ students.add(s); }
    public void showDetails(){
        System.out.println("Course: " + courseName);
        if(professor!=null) System.out.println("Professor: " + professor.getName());
        for(StudentUMS s: students) System.out.println(" - " + s.getName());
    }
}

class StudentUMS {
    private String name;
    public StudentUMS(String name){ this.name=name; }
    public String getName(){ return name; }
    public void enrollCourse(CourseUMS c){ c.enroll(this); }
}

public class UniversityManagementDemo {
    public static void main(String[] args) {
        StudentUMS s1 = new StudentUMS("Karan");
        StudentUMS s2 = new StudentUMS("Meera");
        Professor p = new Professor("Dr. Rao");
        CourseUMS c1 = new CourseUMS("Algorithms");

        c1.assignProfessor(p);
        s1.enrollCourse(c1);
        s2.enrollCourse(c1);

        c1.showDetails();
    }
}
