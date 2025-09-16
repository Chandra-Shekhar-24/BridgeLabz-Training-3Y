import java.util.*;

class Faculty {
    private String name;
    public Faculty(String name){ this.name = name; }
    public String getName(){ return name; }
}

class DepartmentU {
    private String deptName;
    public DepartmentU(String name){ this.deptName = name; }
    public String getDeptName(){ return deptName; }
}

class University {
    private String name;
    private List<DepartmentU> departments = new ArrayList<>();
    private List<Faculty> faculties = new ArrayList<>();
    public University(String name){ this.name = name; }
    public void addDepartment(DepartmentU d){ departments.add(d); }
    public void addFaculty(Faculty f){ faculties.add(f); }
    public void showDetails(){
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for(DepartmentU d: departments) System.out.println(" - " + d.getDeptName());
        System.out.println("Faculties:");
        for(Faculty f: faculties) System.out.println(" - " + f.getName());
    }
}

public class UniversityCompositionAggregationDemo {
    public static void main(String[] args) {
        University u = new University("Delhi University");
        u.addDepartment(new DepartmentU("CS"));
        u.addDepartment(new DepartmentU("Physics"));
        u.addFaculty(new Faculty("Dr. Mehta"));
        u.addFaculty(new Faculty("Prof. Rao"));

        u.showDetails();
    }
}
