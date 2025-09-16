import java.util.*;

class Doctor {
    private String name;
    private List<Patient> patients = new ArrayList<>();
    public Doctor(String name){ this.name=name; }
    public String getName(){ return name; }
    public void consult(Patient p){
        patients.add(p);
        p.addDoctor(this);
        System.out.println("Doctor " + name + " consulted patient " + p.getName());
    }
}

class Patient {
    private String name;
    private List<Doctor> doctors = new ArrayList<>();
    public Patient(String name){ this.name=name; }
    public String getName(){ return name; }
    public void addDoctor(Doctor d){ doctors.add(d); }
}

class Hospital {
    private String name;
    public Hospital(String name){ this.name=name; }
}

public class HospitalAssociationDemo {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("Dr. Sharma");
        Doctor d2 = new Doctor("Dr. Gupta");
        Patient p1 = new Patient("Amit");
        Patient p2 = new Patient("Sneha");

        d1.consult(p1);
        d2.consult(p1);
        d2.consult(p2);
    }
}
