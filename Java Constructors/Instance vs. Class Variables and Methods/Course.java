class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "ABC Institute";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: ₹" + fee);
        System.out.println("------------------------");
    }

    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 6, 15000);
        Course c2 = new Course("Web Development", 4, 12000);
        Course c3 = new Course("Data Science", 8, 25000);

        c1.displayCourseDetails();
        c2.displayCourseDetails();
        c3.displayCourseDetails();

        Course.updateInstituteName("XYZ Academy");

        c1.displayCourseDetails();
        c2.displayCourseDetails();
        c3.displayCourseDetails();
    }
}
