package epam.task.task12;

import java.util.Scanner;

public class Wheel {
    public enum Type {WINTER, SUMMER}

    private double diameter;
    private String brand;
    private Type type;

    public Wheel(double diameter, String brand, Type type) {
        this.diameter = diameter;
        this.brand = brand;
        this.type = type;
    }

    public double getDiameter() {
        return diameter;
    }

    public static Wheel get(Scanner scanner) {
        Wheel object = new Wheel(0, "", Type.WINTER);
        System.out.println("Название бренда ");
        object.brand = scanner.next();
        System.out.println("Размер диаметра ");
        object.diameter = scanner.nextDouble();
        System.out.println("Тип резины ");
        System.out.println("1 - лето, 2 - зима ");
        while (true) {
            int value = scanner.nextInt();
            if (value == 1) {
                object.type = Type.SUMMER;
                break;
            }
            if (value == 2) {
                object.type = Type.WINTER;
                break;
            }
            System.out.print("Введено неправильное значение, повтори ввод.");
        }
        return object;
    }
        @Override
        public String toString () {
            if (type == Type.WINTER) {
                return "Wheel{" +
                        "diameter=" + diameter +
                        ", brand='" + brand + '\'' +
                        ", type=" + Type.WINTER +
                        '}';
            }
            return "Wheel{" +
                    "diameter=" + diameter +
                    ", brand='" + brand + '\'' +
                    ", type=" + Type.SUMMER +
                    '}';
        }
    }
