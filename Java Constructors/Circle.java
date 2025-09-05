public class Circle {
    private double radius;

    public Circle() {
        this.radius = 1.0;
        System.out.println("Default constructor called!");
    }

    public Circle(double radius) {
        this();
        this.radius = radius;
        System.out.println("Parameterized constructor called!");
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public void display() {
        System.out.println("Radius        : " + radius);
        System.out.println("Area          : " + calculateArea());
        System.out.println("Circumference : " + calculateCircumference());
        System.out.println("-------------------------------");
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.display();

        Circle c2 = new Circle(5.5);
        c2.display();
    }
}
