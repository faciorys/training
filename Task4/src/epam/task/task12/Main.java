package epam.task.task12;

import java.util.Scanner;

// Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
//менять колесо, вывести на консоль марку автомобиля.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car = Car.get(scanner);
        System.out.println(car.toString());
        car.add_fuel(100);
        car.change_wheel(scanner);
        car.move();
    }
}
