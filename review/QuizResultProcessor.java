import java.util.*;
public class QuizResultProcessor {
    
    public static int calculateScore(String[] correctAnswers, String[] userAnswers) {
        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (i < userAnswers.length && correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }
    
    public static String getGrade(int score, int totalQuestions) {
        double percentage = (score * 100.0) / totalQuestions;

        if (percentage >= 90) return "A+";
        else if (percentage >= 75) return "A";
        else if (percentage >= 60) return "B";
        else if (percentage >= 40) return "C";
        else return "F";
    }


    public static void main(String[] args) {
        String[] correctAnswers = {"A", "C", "B", "D", "A"};
        
        String[][] userAnswersList = {
                {"A", "C", "B", "D", "A"},   
                {"A", "B", "B", "D", "C"},   
                {"C", "C", "A", "D", "A"}    
        };


        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < userAnswersList.length; i++) {
            int score = calculateScore(correctAnswers, userAnswersList[i]);
            scores.add(score);
            String grade = getGrade(score, correctAnswers.length);

            System.out.println("User " + (i + 1) + " Score: " + score + "/" + correctAnswers.length);
            System.out.println("User " + (i + 1) + " Grade: " + grade);
            System.out.println("------------------------");
        }

        System.out.println("All Users' Scores: " + scores);
    }
}
