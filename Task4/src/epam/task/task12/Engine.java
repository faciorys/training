package epam.task.task12;

import java.util.Scanner;

public class Engine {
    private int number;
    private double power;

    public Engine(int number, double power) {
        this.number = number;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "number=" + number +
                ", power=" + power +
                '}';
    }

    public static Engine get(Scanner scanner) {
        Engine object = new Engine(0, 0);
        System.out.println("Номер двигателя");
        object.number = scanner.nextInt();
        System.out.println("Мощность двигателя");
        object.power = scanner.nextDouble();
        return object;
    }

}
