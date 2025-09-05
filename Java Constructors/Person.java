public class Person {
    private String name;
    private int age;
    private String gender;

    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.gender = "Not specified";
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
        this.gender = other.gender;
    }

    public void display() {
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Gender : " + gender);
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        Person p1 = new Person("Rahul", 25, "Male");
        System.out.println("Original Person:");
        p1.display();

        Person p2 = new Person(p1);
        System.out.println("Cloned Person:");
        p2.display();
    }
}
