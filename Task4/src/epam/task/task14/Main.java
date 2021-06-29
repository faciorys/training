package epam.task.task14;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client one = new Client("Камушкин", 103, 300);

        Accounts accounts = new Accounts();
        accounts.add(one);
        accounts.add(new Client("Цветков", 101, 310));
        accounts.add(new Client("Стрижов", 102, -780));
        System.out.println(one.toString());
        accounts.get(scanner).addMoney(1213);
        System.out.println(accounts.get(scanner).toString());
        one.to_spend_money(10000);
        one.to_spend_money(1000);
        accounts.sort_number_account();
        accounts.print();
    }
}
