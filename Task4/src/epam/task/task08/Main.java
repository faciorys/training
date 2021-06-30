package epam.task.task08;

import java.util.Scanner;

/*
* 8. Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
*и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
*и методами. Задать критерии выбора данных и вывести эти данные на консоль.
*Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
*Найти и вывести:
*a) список покупателей в алфавитном порядке;
*b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
* */
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
