package OOPS50QUES;

interface Rentable {
    double calculateRent(int days);
}

abstract class Vehicle implements Rentable {
    protected String model;
    protected double baserate;

    public Vehicle(String model, double baserate) {
        this.model = model;
        this.baserate = baserate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getBaserate() {
        return baserate;
    }

    public void setBaserate(double baserate) {
        this.baserate = baserate;
    }

    public abstract void displayInfo();

    public static class Bike extends Vehicle {
        public Bike(String model, double baserate) {
            super(model, baserate);
        }

        public double calculateRent(int days) {
            return baserate * days;
        }

        public void displayInfo() {
            System.out.println("Bike Model: " + model + ", Rate/day: Rs. " + baserate);
        }
    }

    public static class Car extends Vehicle {
        private double extracharge;

        public Car(String model, double baserate, double extracharge) {
            super(model, baserate);
            this.extracharge = extracharge;
        }

        public double calculateRent(int days) {
            return (baserate * days) + extracharge;
        }

        public void displayInfo() {
            System.out.println("Car Model: " + model + ", Rate/day: Rs. " + baserate + ", extraCharge: " + extracharge);
        }
    }

    public static class Truck extends Vehicle {
        private double loadcharge;

        public Truck(String model, double baserate, double loadcharge) {
            super(model, baserate);
            this.loadcharge = loadcharge;
        }

        public double calculateRent(int days) {
            return (baserate * days) + loadcharge;
        }

        public void displayInfo() {
            System.out.println("Truck Model: " + model + ", Rate/day: Rs. " + baserate + "load charge: " + loadcharge);
        }
    }
}
    class Customer{
        private String name;
        private String licensenumber;

        public Customer(String name,String licensenumber){
            this.name = name;
            this.licensenumber = licensenumber;
        }

        public void displayInfo(){
            System.out.println("Customer: " + name + ", LicenseNo. : " + licensenumber);
    }
}
public class VehicleRental {
    public static void main(String[] args) {
        Vehicle bike = new Vehicle.Bike("Hero Splendor", 300);
        Vehicle car = new Vehicle.Car("Honda City", 1500, 500);
        Vehicle truck = new Vehicle.Truck("Tata Heavy", 2000, 1000);

        Customer c1 = new Customer("Ravi Kumar", "MH12AB1234");

        c1.displayInfo();
        bike.displayInfo();
        car.displayInfo();
        truck.displayInfo();

        System.out.println("Bike Rent (3 days): Rs. " + bike.calculateRent(3));
        System.out.println("Car Rent (5 days): Rs. " + car.calculateRent(5));
        System.out.println("Truck Rent (2 days): Rs. " + truck.calculateRent(2));
    }
}