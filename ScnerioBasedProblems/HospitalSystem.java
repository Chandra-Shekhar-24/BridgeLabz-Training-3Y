package OOPS50QUES;

interface Payable {
    double calculatePayment();
}

class Patient{
    private String name;
    private int age;
    private String medicalhistory;
    protected String admissiontype;

    public Patient(String name,int age){
        this.name = name;
        this.age = age;
        this.admissiontype = "Normal";
    }
    public Patient(String name,int age,String medicalhistory){
        this.name = name;
        this.age = age;
        this.medicalhistory = medicalhistory;
        this.admissiontype = "Emergency";
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void setMedicalhistory(){
        this.medicalhistory = medicalhistory;
    }

    private String getMedicalhistory(){
        return medicalhistory;
    }

    public String getSummary(){
        return "Patient: " + name + ", age: " + age + ", Admission: " + admissiontype;
    }

    public void displayInfo(){
        System.out.println(getSummary());
    }
}

class InPatient extends Patient{
    private int roomnumber;

    public InPatient(String name,int age,int roomnumber){
        super(name,age);
        this.roomnumber = roomnumber;
    }

    public void displayInfo(){
        System.out.println(getSummary() + "room: " + roomnumber);
    }
}

class OutPatient extends Patient{
    private String appointmentdate;

    public OutPatient(String name,int age,String appointmentdate){
        super(name,age);
        this.appointmentdate = appointmentdate;
    }

    public void displayInfo(){
        System.out.println(getSummary() + " appointment date: " + appointmentdate);
    }
}

class Doctor{
    private String name;
    private String specilization;

    public Doctor(String name,String specilization){
        this.name = name;
        this.specilization = specilization;
    }

    public void displayInfo(){
        System.out.println("Doctor: " + name + specilization);
    }
}

class Bill implements Payable{
    private double baseamount;
    private double discount;

    public Bill(double baseamount ,double discount){
        this.baseamount = baseamount;
        this.discount = discount;
    }

    public double calculatePayment(){
        double discountmoney = baseamount - (baseamount*discount/100);
        return discountmoney;
    }

    public void displayBill(){
        System.out.println("Final bill amount is" + calculatePayment());
    }
}
public class HospitalSystem {
    public static void main(String[] args) {

        Patient p1= new InPatient("Ravi", 45, 204);
        Patient p2= new OutPatient("Kavi", 55, "2025-09-21");
        Patient p3= new Patient("Ravi", 45, "Heart Disease");

        Doctor d1 = new Doctor("Dr. Sharma","Cardiology");
        Bill b1 = new Bill(500,10);

        p1.displayInfo();
        p2.displayInfo();
        p3.displayInfo();

        d1.displayInfo();

        b1.displayBill();
    }
}