package OOPS50QUES;
import java.util.*;
class User {
    private String name;
    private String email;
    private String phone;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}

interface ISchedulable {
    void schedule();
    void reschedule(String newDate);
    void cancel();
}

abstract class Event implements ISchedulable {
    private static int counter = 1000;
    private final int eventId;
    private String eventName;
    private String location;
    private String date;
    private int attendees;
    private boolean catering;
    private boolean decoration;
    private double baseCost;
    private double discount;
    private double totalCost;
    private User organizer;

    public Event(String eventName, String location, String date, int attendees, User organizer) {
        this(eventName, location, date, attendees, organizer, false, false);
    }

    public Event(String eventName, String location, String date, int attendees, User organizer,
                 boolean catering, boolean decoration) {
        this.eventId = ++counter;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.attendees = attendees;
        this.organizer = organizer;
        this.catering = catering;
        this.decoration = decoration;
        this.baseCost = attendees * 500;
        this.discount = 0;
        calculateTotalCost();
    }

    protected void setDiscount(double discount) {
        this.discount = discount;
        calculateTotalCost();
    }

    private void calculateTotalCost() {
        double services = 0;
        if (catering) services += attendees * 200;
        if (decoration) services += 5000;
        this.totalCost = baseCost + services - discount;
    }

    public double getTotalCost() { return totalCost; }
    public int getEventId() { return eventId; }
    public String getEventName() { return eventName; }
    public String getDate() { return date; }
    public String getLocation() { return location; }

    public void showDetails() {
        System.out.println("Event ID: " + eventId + " | " + eventName + " at " + location +
                " on " + date + " | Attendees: " + attendees);
        System.out.println("Organizer: " + organizer.getName() + " | Email: " + organizer.getEmail());
        System.out.println("Total Cost: ₹" + totalCost);
    }

    @Override
    public void reschedule(String newDate) {
        this.date = newDate;
        System.out.println("Event " + eventName + " rescheduled to " + newDate);
    }

    @Override
    public void cancel() {
        System.out.println("Event " + eventName + " has been cancelled.");
    }
}

class BirthdayEvent extends Event {
    public BirthdayEvent(String eventName, String location, String date, int attendees, User organizer,
                         boolean catering, boolean decoration) {
        super(eventName, location, date, attendees, organizer, catering, decoration);
        setDiscount(1000);
    }

    @Override
    public void schedule() {
        System.out.println("🎉 Birthday Event scheduled: " + getEventName() +
                " on " + getDate() + " at " + getLocation());
    }
}

class ConferenceEvent extends Event {
    public ConferenceEvent(String eventName, String location, String date, int attendees, User organizer,
                           boolean catering, boolean decoration) {
        super(eventName, location, date, attendees, organizer, catering, decoration);
    }

    @Override
    public void schedule() {
        System.out.println("📢 Conference scheduled: " + getEventName() +
                " on " + getDate() + " at " + getLocation());
    }
}

public class EventEaseApp {
    public static void main(String[] args) {
        User user1 = new User("Aarav Sharma", "aarav@example.com", "9876543210");

        BirthdayEvent bday = new BirthdayEvent("Aarav's Birthday", "Mumbai Hall", "2025-10-10",
                50, user1, true, true);

        ConferenceEvent conf = new ConferenceEvent("Tech Conference 2025", "Bangalore Convention Center",
                "2025-11-15", 200, user1, true, false);

        bday.schedule();
        bday.showDetails();

        System.out.println();

        conf.schedule();
        conf.showDetails();

        System.out.println();

        conf.reschedule("2025-12-01");
        conf.cancel();
    }
}
