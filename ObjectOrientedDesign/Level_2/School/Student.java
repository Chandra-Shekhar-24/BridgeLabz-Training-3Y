import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Subject> subjects = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
}

