package HybridInheritance;
interface Refuelable {
    void refuel();
}

class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    void displayInfo() {
        System.out.println("Vehicle -> Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends Vehicle {
    int batteryCapacity;

    ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        System.out.println("Electric Vehicle " + model + " is charging. Battery Capacity: " + batteryCapacity + " kWh");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelTankCapacity;

    PetrolVehicle(int maxSpeed, String model, int fuelTankCapacity) {
        super(maxSpeed, model);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println("Petrol Vehicle " + model + " is refueling. Tank Capacity: " + fuelTankCapacity + " liters");
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(160, "Tesla Model 3", 75);
        PetrolVehicle pv = new PetrolVehicle(200, "Toyota Supra", 55);

        ev.displayInfo();
        ev.charge();

        pv.displayInfo();
        pv.refuel();
    }
}
