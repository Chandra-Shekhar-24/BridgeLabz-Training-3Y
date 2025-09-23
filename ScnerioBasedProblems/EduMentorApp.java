package OOPS50QUES;

import java.util.ArrayList;
import java.util.List;

abstract class User {
    protected String name;
    protected String email;
    protected String userId;

    public User(String name, String email, String userId) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }

    public abstract void printDetails();
}

class Learner extends User {
    private List<Quiz> quizzesTaken;

    public Learner(String name, String email, String userId) {
        super(name, email, userId);
        this.quizzesTaken = new ArrayList<>();
    }

    public void takeQuiz(Quiz quiz, List<String> answers) {
        quiz.evaluate(answers);
        quizzesTaken.add(quiz);
        System.out.println(name + " completed quiz: " + quiz.getDifficulty() +
                " | Score: " + quiz.getScore() + "/" + quiz.getTotalQuestions());
    }

    @Override
    public void printDetails() {
        System.out.println("Learner: " + name + " | Email: " + email + " | ID: " + userId);
        System.out.println("Quizzes Taken: " + quizzesTaken.size());
    }
}

class Instructor extends User {
    private List<String> coursesTaught;

    public Instructor(String name, String email, String userId) {
        super(name, email, userId);
        this.coursesTaught = new ArrayList<>();
    }

    public void addCourse(String courseName) {
        coursesTaught.add(courseName);
    }

    @Override
    public void printDetails() {
        System.out.println("Instructor: " + name + " | Email: " + email + " | ID: " + userId);
        System.out.println("Courses Taught: " + coursesTaught);
    }
}

interface ICertifiable {
    void generateCertificate(Learner learner);
}

class ShortCourse implements ICertifiable {
    private String courseName;

    public ShortCourse(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public void generateCertificate(Learner learner) {
        System.out.println("Certificate of Completion: " + courseName +
                " | Awarded to: " + learner.name + " (Short Course)");
    }
}

class FullTimeCourse implements ICertifiable {
    private String courseName;

    public FullTimeCourse(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public void generateCertificate(Learner learner) {
        System.out.println("Diploma Certificate: " + courseName +
                " | Awarded to: " + learner.name + " (Full-Time Program)");
    }
}

class Quiz {
    private List<String> questions;
    private List<String> correctAnswers;
    private int score;
    private String difficulty;

    public Quiz(List<String> questions, List<String> answers, String difficulty) {
        this.questions = new ArrayList<>(questions);
        this.correctAnswers = new ArrayList<>(answers);
        this.score = 0;
        this.difficulty = difficulty;
    }

    public void evaluate(List<String> userAnswers) {
        score = 0;
        for (int i = 0; i < correctAnswers.size(); i++) {
            if (userAnswers.get(i).equalsIgnoreCase(correctAnswers.get(i))) {
                score++;
            }
        }
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return correctAnswers.size();
    }

    public String getDifficulty() {
        return difficulty;
    }

    public double getPercentage() {
        return (score * 100.0) / getTotalQuestions();
    }
}

public class EduMentorApp {
    public static void main(String[] args) {
        Instructor ins = new Instructor("Dr. Rao", "rao@edumentor.com", "I101");
        ins.addCourse("Java Basics");
        ins.addCourse("Data Structures");

        Learner l1 = new Learner("Sneha", "sneha@edu.com", "L001");

        List<String> q1 = List.of("2+2?", "Capital of India?", "Java is?");
        List<String> a1 = List.of("4", "Delhi", "Language");
        Quiz quiz1 = new Quiz(q1, a1, "Easy");

        l1.takeQuiz(quiz1, List.of("4", "Delhi", "Language"));

        ShortCourse sc = new ShortCourse("Java Basics");
        FullTimeCourse fc = new FullTimeCourse("Computer Science");

        sc.generateCertificate(l1);
        fc.generateCertificate(l1);

        System.out.println();
        ins.printDetails();
        l1.printDetails();
    }
}
