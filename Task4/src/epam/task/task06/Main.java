package epam.task.task06;

import java.util.Scanner;

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
