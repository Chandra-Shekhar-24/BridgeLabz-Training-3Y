package OOPS50QUES;


import java.util.Random;

abstract class Pet {
    private String name;
    private String type;
    private int age;
    private int hunger;
    private int mood;
    private int energy;

    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
        Random rand = new Random();
        this.hunger = rand.nextInt(50) + 50;
        this.mood = rand.nextInt(50) + 50;
        this.energy = rand.nextInt(50) + 50;
    }

    public Pet(String name, String type, int age, int hunger, int mood, int energy) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.hunger = hunger;
        this.mood = mood;
        this.energy = energy;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getType() { return type; }

    protected void changeHunger(int value) {
        hunger = Math.max(0, Math.min(100, hunger + value));
    }

    protected void changeMood(int value) {
        mood = Math.max(0, Math.min(100, mood + value));
    }

    protected void changeEnergy(int value) {
        energy = Math.max(0, Math.min(100, energy + value));
    }

    public void showStatus() {
        System.out.println(type + " " + name + " | Age: " + age +
                " | Hunger: " + hunger +
                " | Mood: " + mood +
                " | Energy: " + energy);
    }

    public abstract void makeSound();
}

interface IInteractable {
    void feed();
    void play();
    void sleep();
}

class Dog extends Pet implements IInteractable {
    public Dog(String name, int age) {
        super(name, "Dog", age);
    }

    @Override
    public void feed() {
        changeHunger(-20);
        changeMood(10);
        System.out.println(getName() + " enjoyed the meal!");
    }

    @Override
    public void play() {
        changeMood(20);
        changeEnergy(-15);
        changeHunger(10);
        System.out.println(getName() + " is playing fetch happily!");
    }

    @Override
    public void sleep() {
        changeEnergy(30);
        changeHunger(10);
        System.out.println(getName() + " is sleeping peacefully.");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof Woof!");
    }
}

class Cat extends Pet implements IInteractable {
    public Cat(String name, int age) {
        super(name, "Cat", age);
    }

    @Override
    public void feed() {
        changeHunger(-15);
        changeMood(5);
        System.out.println(getName() + " nibbled the food.");
    }

    @Override
    public void play() {
        changeMood(15);
        changeEnergy(-10);
        changeHunger(10);
        System.out.println(getName() + " is chasing a toy mouse!");
    }

    @Override
    public void sleep() {
        changeEnergy(25);
        changeHunger(10);
        System.out.println(getName() + " curled up and is sleeping.");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow Meow!");
    }
}

class Bird extends Pet implements IInteractable {
    public Bird(String name, int age) {
        super(name, "Bird", age);
    }

    @Override
    public void feed() {
        changeHunger(-10);
        changeMood(5);
        System.out.println(getName() + " pecked at some seeds.");
    }

    @Override
    public void play() {
        changeMood(10);
        changeEnergy(-5);
        changeHunger(5);
        System.out.println(getName() + " is flapping around happily!");
    }

    @Override
    public void sleep() {
        changeEnergy(20);
        changeHunger(5);
        System.out.println(getName() + " is resting in the cage.");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Chirp Chirp!");
    }
}

public class PetPalApp {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3);
        Cat cat = new Cat("Whiskers", 2);
        Bird bird = new Bird("Tweety", 1);

        dog.showStatus();
        dog.makeSound();
        dog.feed();
        dog.play();
        dog.sleep();
        dog.showStatus();

        System.out.println();

        cat.showStatus();
        cat.makeSound();
        cat.play();
        cat.sleep();
        cat.showStatus();

        System.out.println();

        bird.showStatus();
        bird.makeSound();
        bird.feed();
        bird.sleep();
        bird.showStatus();
    }
}
