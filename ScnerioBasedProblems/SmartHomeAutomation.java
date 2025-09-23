package OOPS50QUES;
interface Controllable {
    void turnOn();
    void turnOff();
}

class Appliance implements Controllable {
    private String name;
    private int power;
    private boolean isOn;

    public Appliance(String name, int power) {
        this.name = name;
        this.power = power;
        this.isOn = false;
    }

    public int getPower() {
        return power;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println(name + " is ON. Power: " + power + "W");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println(name + " is OFF.");
    }
}

public class SmartHomeAutomation {
    public static void main(String[] args) {
        Appliance light = new Appliance("Light", 10);
        Appliance fan = new Appliance("Fan", 60);
        Appliance ac = new Appliance("AC", 1500);

        light.turnOn();
        fan.turnOn();
        ac.turnOn();

        System.out.println("\nComparing Power:");
        System.out.println("AC > Fan ? " + (ac.getPower() > fan.getPower()));
        System.out.println("Light == Fan ? " + (light.getPower() == fan.getPower()));

        fan.turnOff();
        ac.turnOff();
    }
}
