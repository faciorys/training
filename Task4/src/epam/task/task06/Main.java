package epam.task.task06;

import java.util.Scanner;

/*
* 6. Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
* изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
* недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
* заданное количество часов, минут и секунд.
* */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Time a = new Time(13,1,1);
        a.print();
        a.add_hours(6);
        a.add_seconds(1000);
        a.print();
        Time b = new Time(23,44,111);
        b.print();
        Time c = Time.read(scanner);
        c.print();
    }
}
