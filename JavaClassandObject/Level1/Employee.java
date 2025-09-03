
class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String toString() {
        return "Employee Name: " + name +
               "\nEmployee ID: " + id +
               "\nEmployee Salary: " + salary;
    }

    public static void main(String[] args) {
        Employee emp = new Employee("Rohan", 1, 500000);
        System.out.println(emp);
    }
}