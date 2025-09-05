class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void updateSalary(double newSalary) {
        if (newSalary > 0) {
            salary = newSalary;
            System.out.println("Salary updated successfully for Employee ID: " + employeeID);
        } else {
            System.out.println("Invalid salary amount!");
        }
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: ₹" + salary);
        System.out.println("------------------------");
    }
}

class Manager extends Employee {
    private int teamSize;

    public Manager(int employeeID, String department, double salary, int teamSize) {
        super(employeeID, department, salary);
        this.teamSize = teamSize;
    }

    public void displayManagerDetails() {
        System.out.println("Manager ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: ₹" + getSalary());
        System.out.println("Team Size: " + teamSize);
        System.out.println("------------------------");
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "IT", 45000);
        Manager m1 = new Manager(201, "HR", 75000, 8);

        e1.displayEmployeeDetails();
        m1.displayManagerDetails();

        e1.updateSalary(50000);
        System.out.println("Updated Salary of Employee ID " + e1.employeeID + ": ₹" + e1.getSalary());
    }
}
