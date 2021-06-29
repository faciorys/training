package epam.task.task08;

import java.util.Comparator;
import java.util.Scanner;

class Customer {
    private int id;
    private static int ID;
    private String surname, name, patronymic, address;
    private int credit_card_num, account_num;

    public Customer(String surname, String name, String patronymic, String address, int credit_card_num, int account_num) {
        id = ID++;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.credit_card_num = credit_card_num;
        this.account_num = account_num;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCredit_card_num() {
        return credit_card_num;
    }

    public void setCredit_card_num(int credit_card_num) {
        this.credit_card_num = credit_card_num;
    }

    public int getAccount_num() {
        return account_num;
    }

    public void setAccount_num(int account_num) {
        this.account_num = account_num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", credit_card_num=" + credit_card_num +
                ", account_num=" + account_num +
                '}';
    }

    public static Customer getCustomer(Scanner scanner) {
        System.out.println("Введите поочердно: Фамилию, Имя, Отчество, адресс, номер карточки, номер счёта");
        Customer customer = new Customer(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(),
                scanner.nextInt());
        return customer;
    }
    public static class NameComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            if (!o1.getSurname().equals(o2.getSurname()))
                return o1.getSurname().compareTo(o2.getSurname());
            if (!o1.getName().equals(o2.getName()))
                return o1.getName().compareTo(o2.getName());
            return o1.patronymic.compareTo(o2.patronymic);
        }
    }
}
