package MultilevelInheritance;
class Course {
    String courseName;
    int duration;

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayInfo() {
        System.out.println("Course -> Name: " + courseName + ", Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayInfo() {
        System.out.println("Online Course -> Name: " + courseName + ", Duration: " + duration + " weeks, Platform: " + platform + ", Recorded: " + isRecorded);
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    void displayInfo() {
        double finalFee = fee - (fee * discount / 100);
        System.out.println("Paid Online Course -> Name: " + courseName + ", Duration: " + duration + " weeks, Platform: " + platform + ", Recorded: " + isRecorded + ", Fee: " + fee + ", Discount: " + discount + "%, Final Fee: " + finalFee);
    }
}

public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        Course c1 = new Course("Mathematics", 8);
        OnlineCourse c2 = new OnlineCourse("Java Programming", 6, "Udemy", true);
        PaidOnlineCourse c3 = new PaidOnlineCourse("Machine Learning", 12, "Coursera", true, 1000, 20);

        c1.displayInfo();
        c2.displayInfo();
        c3.displayInfo();
    }
}
