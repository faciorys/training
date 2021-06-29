package epam.task.task08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer one = new Customer("Demidov", "Dima", "Ivanovich", "Moskva",
                3, 2213999);

        Customers customers = new Customers();
        customers.add(one);
        customers.add(new Customer("Bisha", "Istanbul", "Vods", "Iran",
                2, 41231));
        customers.add(Customer.getCustomer(scanner));
        customers.sortByName();
        customers.print_if_card_in(1,4);
    }
}