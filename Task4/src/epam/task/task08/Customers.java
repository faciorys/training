package epam.task.task08;

import java.util.Arrays;

public class Customers {
    private Customer[] customers;
    private int capacity;
    private int size;

    public Customers(int capacity) {
        size = 0;
        this.capacity = capacity;
        customers = new Customer[capacity];
    }

    // По умолчанию массив размером 10
    public Customers() {
        this(10);
    }

    // Используем метод add по аналогии с ArrayList
    public void add(Customer customer) {
        if (size < capacity) {
            customers[size] = customer;
            size++;
        } else {
            Customer[] temp = new Customer[capacity + 5];
            for (int i = 0; i < size; ++i) {
                temp[i] = customers[i];
            }
            customers = temp;
            capacity = capacity + 5;
            customers[size] = customer;
            size++;
        }
    }

    public void print_if_card_in(int a, int b) {
        System.out.println("Список покупателей, номер кредитной карточки в интервале от " + a + " до " + b);
        for (int i = 0; i < size; ++i) {
            if (customers[i].getCredit_card_num() >= a &&
                    customers[i].getCredit_card_num() <= b) {
                System.out.println(customers[i].getSurname() + " " + customers[i].getName() + " " +
                        customers[i].getCredit_card_num());
            }
        }
    }

    public void sortByName() {
        Arrays.sort(customers, 0, size, new Customer.NameComparator());
    }
}