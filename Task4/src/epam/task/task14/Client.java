package epam.task.task14;

import java.util.Comparator;
import java.util.Random;

public class Client {
    private static int ID;
    private int id_person;
    private String person_name;
    private int number_account;
    private double sum_account;

    Random random = new Random();

    public Client(String person_name, int number_account, double sum_account) {
        id_person = ID++;
        this.person_name = person_name;
        this.number_account = number_account;
        this.sum_account = sum_account;
    }

    public Client() {
    }

    public int getId_person() {
        return id_person;
    }

    public String getPerson_name() {
        return person_name;
    }

    public int getNumber_account() {
        return number_account;
    }

    public double getSum_account() {
        return sum_account;
    }

    public void addMoney(int num) {
        sum_account += num;
        System.out.println("Зачислено на счет " + num + " $");
        System.out.println("Баланс составляет " + sum_account + " $");
    }

    public void to_spend_money(int num) {
        if (sum_account <= 0) {
            System.out.println("Счет заблокирован, ваш баланс " + sum_account + " $");
        } else
            sum_account -= num;
    }


    @Override
    public String toString() {
        String s = "";
        s = "Клиент - " + person_name + ", номер счета - " + number_account
                + ", баланс на счете " + sum_account + " $";
        return s;
    }

    public static class NameComparator implements Comparator<Client> {
        @Override
        public int compare(Client o1, Client o2) {
            return o1.getNumber_account() - o2.getNumber_account();
        }
    }
}
