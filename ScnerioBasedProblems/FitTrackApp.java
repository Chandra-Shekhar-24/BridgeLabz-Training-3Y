package OOPS50QUES;
import java.util.ArrayList;
import java.util.List;

class UserProfile {
    private String name;
    private int age;
    private double weight;
    private String goal;
    private int dailyTarget;
    private int caloriesBurned;

    public UserProfile(String name, int age, double weight) {
        this(name, age, weight, "Stay Healthy", 2000);
    }

    public UserProfile(String name, int age, double weight, String goal, int dailyTarget) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.goal = goal;
        this.dailyTarget = dailyTarget;
        this.caloriesBurned = 0;
    }

    public void addCalories(int calories) {
        this.caloriesBurned += calories;
    }

    public int getRemainingCalories() {
        return dailyTarget - caloriesBurned;
    }

    public void showProfile() {
        System.out.println("User: " + name + " | Age: " + age + " | Goal: " + goal);
        System.out.println("Daily Target: " + dailyTarget + " | Burned: " + caloriesBurned +
                " | Remaining: " + getRemainingCalories());
    }
}

interface ITrackable {
    void startWorkout();
    void stopWorkout();
}

abstract class Workout implements ITrackable {
    private String type;
    private int duration;
    private int caloriesBurned;

    public Workout(String type, int duration) {
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = 0;
    }

    public abstract void calculateCalories();

    protected void setCaloriesBurned(int calories) {
        this.caloriesBurned = calories;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void startWorkout() {
        System.out.println("Starting " + type + " workout for " + duration + " mins.");
    }

    @Override
    public void stopWorkout() {
        System.out.println("Stopped " + type + " workout. Calories burned: " + caloriesBurned);
    }
}

class CardioWorkout extends Workout {
    public CardioWorkout(int duration) {
        super("Cardio", duration);
    }

    @Override
    public void calculateCalories() {
        setCaloriesBurned(getDuration() * 10);
    }
}

class StrengthWorkout extends Workout {
    public StrengthWorkout(int duration) {
        super("Strength", duration);
    }

    @Override
    public void calculateCalories() {
        setCaloriesBurned(getDuration() * 8);
    }
}

class FitnessLog {
    private List<Workout> workoutHistory;

    public FitnessLog() {
        workoutHistory = new ArrayList<>();
    }

    public void addWorkout(Workout workout) {
        workoutHistory.add(workout);
    }

    public void showLog() {
        System.out.println("Workout History:");
        for (Workout w : workoutHistory) {
            System.out.println(w.getType() + " | Duration: " + w.getDuration() +
                    " mins | Calories: " + w.getCaloriesBurned());
        }
    }
}

public class FitTrackApp {
    public static void main(String[] args) {
        UserProfile user = new UserProfile("Rohit", 25, 72.5, "Weight Loss", 1800);

        CardioWorkout cw = new CardioWorkout(30);
        StrengthWorkout sw = new StrengthWorkout(40);

        FitnessLog log = new FitnessLog();

        cw.startWorkout();
        cw.calculateCalories();
        cw.stopWorkout();
        user.addCalories(cw.getCaloriesBurned());
        log.addWorkout(cw);

        sw.startWorkout();
        sw.calculateCalories();
        sw.stopWorkout();
        user.addCalories(sw.getCaloriesBurned());
        log.addWorkout(sw);

        System.out.println();
        user.showProfile();
        log.showLog();
    }
}
