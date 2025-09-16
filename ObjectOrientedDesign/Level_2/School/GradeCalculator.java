public class GradeCalculator {
    public String calculateGrade(Student student) {
        if (student.getSubjects().isEmpty()) {
            return "No subjects found!";
        }

        int total = 0;
        for (Subject subject : student.getSubjects()) {
            total += subject.getMarks();
        }

        double avg = (double) total / student.getSubjects().size();

        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 50) return "C";
        else return "F";
    }
}
