package HybridInheritance;
interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Person -> Name: " + name + ", ID: " + id);
    }
}

class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Chef " + name + " is cooking " + specialty + " dishes.");
    }
}

class Waiter extends Person implements Worker {
    int tableCount;

    Waiter(String name, int id, int tableCount) {
        super(name, id);
        this.tableCount = tableCount;
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter " + name + " is serving " + tableCount + " tables.");
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Worker w1 = new Chef("Arjun", 101, "Italian");
        Worker w2 = new Waiter("Ravi", 102, 5);

        ((Person) w1).displayInfo();
        w1.performDuties();

        ((Person) w2).displayInfo();
        w2.performDuties();
    }
}
