package AssistedProblems;
class Vehicle {
    int maxSpeed;
    String fuelType;

    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo() {
        System.out.println("Vehicle -> Max Speed: " + maxSpeed + " km/h, Fuel Type: " + fuelType);
    }
}

class Car extends Vehicle {
    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        System.out.println("Car -> Max Speed: " + maxSpeed + " km/h, Fuel Type: " + fuelType + ", Seat Capacity: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    int loadCapacity;

    Truck(int maxSpeed, String fuelType, int loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        System.out.println("Truck -> Max Speed: " + maxSpeed + " km/h, Fuel Type: " + fuelType + ", Load Capacity: " + loadCapacity + " tons");
    }
}

class Motorcycle extends Vehicle {
    boolean hasGear;

    Motorcycle(int maxSpeed, String fuelType, boolean hasGear) {
        super(maxSpeed, fuelType);
        this.hasGear = hasGear;
    }

    @Override
    void displayInfo() {
        System.out.println("Motorcycle -> Max Speed: " + maxSpeed + " km/h, Fuel Type: " + fuelType + ", Has Gear: " + hasGear);
    }
}

public class VehicleTransportSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 15);
        vehicles[2] = new Motorcycle(150, "Petrol", true);

        for (Vehicle v : vehicles) {
            v.displayInfo();
        }
    }
}
