
public class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(2.5);

        System.out.printf("Area of circle: %.4f\n", circle.area());
        System.out.printf("Circumference of circle: %.4f\n", circle.circumference());
    }
}
