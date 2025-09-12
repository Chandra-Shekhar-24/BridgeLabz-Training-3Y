package HierarchicalInheritance;
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayRole() {
        System.out.println("Person -> Name: " + name + ", Age: " + age);
    }
}

class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    void displayRole() {
        System.out.println("Teacher -> Name: " + name + ", Age: " + age + ", Subject: " + subject);
    }
}

class Student extends Person {
    int grade;

    Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    void displayRole() {
        System.out.println("Student -> Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }
}

class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    void displayRole() {
        System.out.println("Staff -> Name: " + name + ", Age: " + age + ", Department: " + department);
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Teacher t = new Teacher("Mr. Sharma", 40, "Mathematics");
        Student s = new Student("Amit", 16, 10);
        Staff st = new Staff("Ravi", 35, "Administration");

        t.displayRole();
        s.displayRole();
        st.displayRole();
    }
}
