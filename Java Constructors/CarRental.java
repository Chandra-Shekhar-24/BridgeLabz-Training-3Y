public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double costPerDay;

    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Standard";
        this.rentalDays = 0;
        this.costPerDay = 1000.0;
    }

    public CarRental(String customerName, String carModel, int rentalDays, double costPerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.costPerDay = costPerDay;
    }

    public CarRental(CarRental other) {
        this.customerName = other.customerName;
        this.carModel = other.carModel;
        this.rentalDays = other.rentalDays;
        this.costPerDay = other.costPerDay;
    }

    public double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    public void display() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Car Model     : " + carModel);
        System.out.println("Rental Days   : " + rentalDays);
        System.out.println("Cost/Day      : ₹" + costPerDay);
        System.out.println("Total Cost    : ₹" + calculateTotalCost());
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental();
        System.out.println("Default Rental:");
        rental1.display();

        CarRental rental2 = new CarRental("Aman Verma", "Toyota Fortuner", 5, 2500.0);
        System.out.println("Parameterized Rental:");
        rental2.display();

        CarRental rental3 = new CarRental(rental2);
        System.out.println("Copied Rental:");
        rental3.display();
    }
}
