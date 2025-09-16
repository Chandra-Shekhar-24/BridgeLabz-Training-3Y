import java.util.*;

class Employee {
    private String name;
    public Employee(String name) { this.name = name; }
    public String getName() { return name; }
}

class Department {
    private String deptName;
    private List<Employee> employees = new ArrayList<>();
    public Department(String deptName) { this.deptName = deptName; }
    public void addEmployee(Employee e) { employees.add(e); }
    public void showEmployees() {
        System.out.println("Department: " + deptName);
        for (Employee e : employees) System.out.println(" - " + e.getName());
    }
}

class Company {
    private String companyName;
    private List<Department> departments = new ArrayList<>();
    public Company(String name) { this.companyName = name; }
    public void addDepartment(Department d) { departments.add(d); }
    public void showCompanyDetails() {
        System.out.println("Company: " + companyName);
        for (Department d : departments) d.showEmployees();
    }
}

public class CompanyCompositionDemo {
    public static void main(String[] args) {
        Company comp = new Company("TechCorp");
        Department d1 = new Department("IT");
        Department d2 = new Department("HR");

        d1.addEmployee(new Employee("Alice"));
        d1.addEmployee(new Employee("Bob"));
        d2.addEmployee(new Employee("Charlie"));

        comp.addDepartment(d1);
        comp.addDepartment(d2);

        comp.showCompanyDetails();
    }
}
