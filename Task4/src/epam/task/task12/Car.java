package epam.task.task12;

import java.util.Scanner;

public class Car {
    private Wheel[] wheels;
    private Engine engine;
    private String brand;
    private double consumption;
    private double fuel_level;

    public Car(String brand, int consumption, Engine engine, Wheel[] wheels, int fuel_level) {
        this.wheels = wheels;
        this.engine = engine;
        this.brand = brand;
        this.consumption = consumption;
        this.fuel_level = fuel_level;
    }

    public String toString() {
        String string = "";
        string += brand + engine.toString() + ";" + consumption + "L/100km { " + fuel_level + "}; [";
        for (int i = 0; i < 4; ++i) {
            string += wheels[i].toString() + " ";
        }
        return string + "]";
    }

    public static Car get(Scanner scanner) {
        Car object = new Car("", 0, new Engine(1, 2), new Wheel[4], 0);
        System.out.print("Введи марку автомобиля: ");
        object.brand = scanner.next();
        System.out.print("Введи расход топлива на 100км: ");
        object.consumption = scanner.nextDouble();
        System.out.print("Введи текущий уровень топлива:");
        object.fuel_level = scanner.nextDouble();
        System.out.println("Введи колеса:");
        for (int i = 0; i < 4; ++i) {
            System.out.println("колесо #" + i);
            object.wheels[i] = Wheel.get(scanner);
        }
        object.engine = Engine.get(scanner);
        return object;
    }

    public void move() {
        if (fuel_level <= 0) {
            System.out.println("Нет бензина, машина не может двигаться");
            return;
        }
        for (int i = 1; i < 4; ++i) {
            if (wheels[i].getDiameter() != wheels[i - 1].getDiameter()) {
                System.out.println("Колеса разных диаметров, машина не может двигаться");
                return;
            }
        }
        double distance = fuel_level / consumption;
        System.out.println("машина проехала " + distance * 100 + "км.");
        fuel_level = 0;
    }

    public void add_fuel(double value) {
        fuel_level += value;
    }

    public void change_wheel(Scanner scanner) {
        System.out.println("Введи номер колеса [0-3]:");
        int number;
        while (true) {
            number = scanner.nextInt();
            if (number >= 0 && number <= 3)
                break;
            System.out.println("Неправильный номер, повтори ввод");
        }
        wheels[number] = Wheel.get(scanner);
    }
}
