package epam.task.task14;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Accounts {
    private Client[] clients;
    private int capacity;
    private int size;

    public Accounts(int capacity) {
        size = 0;
        this.capacity = capacity;
        clients = new Client[capacity];
    }

    // По умолчанию массив размером 10
    public Accounts() {
        this(10);
    }

    // Используем метод add по аналогии с ArrayList
    public void add(Client client) {
        if (size < capacity) {
            clients[size] = client;
            size++;
        } else {
            Client[] temp = new Client[capacity + 5];
            for (int i = 0; i < size; ++i) {
                temp[i] = clients[i];
            }
            clients = temp;
            capacity = capacity + 5;
            clients[size] = client;
            size++;
        }
    }

    public void accountsAllSum() {
        System.out.println("Сумма по всем счетам: ");
        double sum = 0;
        for (int i = 0; i < size; ++i) {
            sum += clients[i].getSum_account();
        }
        System.out.println(sum + " $");
    }

    public void accountsWithPositiveBalance() {
        System.out.println("Сумма по положительному балансу на счетах: ");
        double sum = 0;
        for (int i = 0; i < size; ++i) {
            if (clients[i].getSum_account() > 0) {
                sum += clients[i].getSum_account();
            }
        }
        System.out.println(sum + " $");
    }

    public void accountsWithNegativeBalance() {
        System.out.println("Сумма по отрицательному балансу на счетах: ");
        double sum = 0;
        for (int i = 0; i < size; ++i) {
            if (clients[i].getSum_account() < 0) {
                sum += clients[i].getSum_account();
            }
        }
        System.out.println(sum + " $");
    }

    public void find_number_account(Scanner scanner) {
        System.out.println("Введите номер счета: ");
        int num = scanner.nextInt();
        String client = "";
        double sum = 0;
        for (int i = 0; i < size; ++i) {
            if (clients[i].getNumber_account() == num) {
                client = clients[i].getPerson_name();
                sum += clients[i].getSum_account();
            }
        }
        System.out.println("Клиент - " + client + ". Сумма на счете - " + sum + " $");
    }

    public void sort_number_account() {
        Arrays.sort(clients, 0, size, new Client.NameComparator());
    }

    public Client get(Scanner scanner) {
        System.out.println("Введите номер счета");
        while (true) {
            int s = scanner.nextInt();
            for (int i = 0; i < size; ++i) {
                if (clients[i].getNumber_account() == s) {
                    return clients[i];
                }
            }
            System.out.println("Номер счета отсутствует, введите еще раз");
        }
    }

    public void print() {
        for (Client cl : clients) {
            if (cl != null) {
                System.out.println(cl);
            }
        }
    }
}
