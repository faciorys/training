package task5.epam.task04;

import task5.epam.task04.cave.CaveDragon;

import java.util.Scanner;

/**
 * Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения
 * о 100 сокровищах в пещере дракона. Реализовать возможность просмотра
 * сокровищ, выбора самого дорогого по стоимости сокровища и выбора сокровищ на
 * заданную сумму.
 *
 * @author faciorys
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaveDragon dragon = new CaveDragon();
        System.out.println("Выберите действие:" +
                "\n1 - просмотр сокровищницы " + "\n2 - выбор самого дорогого по стоимости сокровища" +
                "\n3 - выбор сокровищ на определенную сумму");

        while (true) {
            int n = scanner.nextInt();
            if (n == 1) {
                System.out.println("Сокровища дракона: ");
                dragon.showTreasure();
                break;
            } else if (n == 2) {
                System.out.println("Самое дорогое сокровище дракона: ");
                dragon.mostPreciousTreasure();
                break;
            } else if (n == 3) {
                System.out.println("Введите сумму: ");
                dragon.chooseTreasure(scanner.nextInt());
                break;
            }
            if (n == 0) {
                break;
            }
            System.out.println("Не правильный ввод! Если желаете выйти нажмите 0");
        }
    }
}
