package epam.task.task15;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tour tour1 = new Tour();
        tour1.add(new Tour(new Client("Малышева", "Фиона", 98), Tour.Type.CRUISE,
                1,"Полный фарш", Tour.Transport.TRAIN));
        tour1.add(new Tour(new Client("Сеонид","Миша", 22),
                Tour.Type.CRUISE,2," Полный пансион ", Tour.Transport.TRAIN));
        tour1.print();
        tour1.sort_type_voucher();
        tour1.add(Tour.get(scanner));

    }
}
