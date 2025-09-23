package OOPS50QUES;

abstract class Vehicle {
    private String vehicleNumber;
    private int capacity;
    private String type;

    public Vehicle(String vehicleNumber, int capacity, String type) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public int getCapacity() { return capacity; }
    public String getType() { return type; }

    public abstract double calculateFare(double distance);


    public void showVehicleDetails() {
        System.out.println("Vehicle: " + type + " | Number: " + vehicleNumber + " | Capacity: " + capacity);
    }
}

class Mini extends Vehicle {
    private static final double rate = 8.0;   // per km
    private static final double baseFare = 50;

    public Mini(String number, int capacity) {
        super(number, capacity, "Mini");
    }

    @Override
    public double calculateFare(double distance) {
        return baseFare + (distance * rate); // Operator used
    }
}

class Sedan extends Vehicle {
    private static final double rate = 12.0;
    private static final double baseFare = 100;

    public Sedan(String number, int capacity) {
        super(number, capacity, "Sedan");
    }

    @Override
    public double calculateFare(double distance) {
        return baseFare + (distance * rate);
    }
}

class SUV extends Vehicle {
    private static final double rate = 15.0;
    private static final double baseFare = 150;

    public SUV(String number, int capacity) {
        super(number, capacity, "SUV");
    }

    @Override
    public double calculateFare(double distance) {
        return baseFare + (distance * rate);
    }
}

class Driver {
    private String name;
    private String licenseNumber;
    private double rating;  // private for encapsulation

    // Constructor
    public Driver(String name, String licenseNumber, double rating) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
    }

    public double getRating() { return rating; }

    public void showDriverDetails() {
        System.out.println("Driver: " + name + " | License: " + licenseNumber + " | Rating: " + rating);
    }
}

interface IRideService {
    void bookRide(double distance);
    void endRide();
}
class Ride implements IRideService {
    private Vehicle vehicle;
    private Driver driver;
    private double fare;  // encapsulated (private)

    public Ride(Vehicle vehicle, Driver driver) {
        this.vehicle = vehicle;
        this.driver = driver;
    }

    @Override
    public void bookRide(double distance) {
        fare = vehicle.calculateFare(distance);  // polymorphism in action
        System.out.println("\nRide Booked!");
        driver.showDriverDetails();
        vehicle.showVehicleDetails();
        System.out.println("Estimated Fare: ₹" + fare);
    }

    @Override
    public void endRide() {
        System.out.println("Ride Ended! Please pay: ₹" + fare);
    }
}

public class CabbyGoApp {
        Driver d1 = new Driver("Rahul", "DL-12345", 4.7);
        Driver d2 = new Driver("Sneha", "DL-67890", 4.9);

        Vehicle v1 = new Mini("MH12AB1234", 4);
        Vehicle v2 = new SUV("MH14XY5678", 6);
        Ride ride1 = new Ride(v1, d1);
        ride1.bookRide(10.5); // distance in km
        ride1.endRide();

        Ride ride2 = new Ride(v2, d2);
        ride2.bookRide(20);
        ride2.endRide();
    }
}
