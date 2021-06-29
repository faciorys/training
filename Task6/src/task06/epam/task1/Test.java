package task06.epam.task1;

import task06.epam.task1.role.Admin;
import task06.epam.task1.role.User;

import java.io.IOException;
import java.util.Scanner;

/**
 * Задание 1 : Создать консольное приложение "Учет книг в домашней библиотеке".
 * <p>
 * Общие требования к заданию:
 * - Система учитывает книги как в электронном, так и в бумажном варианте
 * - Существующие роли: пользователь, администратор
 * - Пользователь может просматривать книги в каталоге книг, осуществить поиск книг в каталоге
 * - Администратор может модифицировать каталог
 * - *При добавлении описания книги в каталог оповещение о ней рассылается на e-mail пользователям
 * - **При просмотре каталога желательно реализовать постраничный просмотр
 * - ***Пользователь может предложить добавить книгу в библиотеку, переслав её администратору на е-mail
 * - Каталог книг храниться в текстовом файле
 * - Данные аутентификации пользователей храняться в текстовом файле. Пароль не храниться в открытом виде
 *
 *  @author faciorys
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в библиотеку!");
        System.out.println("Вы новый пользователь? (Да или Нет)");
        while (true) {
            String s = scanner.next();
            if (s.equals("Да")) {
                System.out.println("Желаете зарегестрироваться? (Да или Нет)");
                String d = scanner.next();
                if (d.equals("Да")) {
                    User user = User.getRegistration(scanner);
                    break;
                } else System.out.println("Досвидания :)");
                break;
            }
            break;
        }

        System.out.println("Введите свой логин и пароль для входа в аккаунт");
        User user1 = new User();
        Admin admin = new Admin();
        boolean flags = false;
        while (!flags) {
            System.out.println("Введите логин");
            String one = scanner.next();
            System.out.println("Введите пароль");
            String two = scanner.next();
            user1.findUser(one, two);
            admin.findAdmin(one, two);
            if (User.open == false && Admin.open_admin == false) {
                System.out.println("Неправильный логин или пароль. Желаете повторить? (Да или Нет)");
                String ye = scanner.next();
                if (ye.equals("Да")) {
                    break;
                } else {
                    System.out.println("Досвидания");
                    flags = true;
                }
            } else
                flags = true;
        }
        if (User.open == true) {
            System.out.println("Что желаете выполнить: " + "1 - просмотреть весь каталог книг " +
                    "\n2- Найти книгу(и) по названию " + "\n3 - Найти книгу(и) по автору " +
                    "\n4 - Найти книгу(и) по типу" +
                    "\n5 - Желаете добавить книгу в библиотеку (переслав её админу на е-mail)" +
                    "\n0 - выйти из аккаунта");
            boolean flag = false;
            while (!flag) {
                System.out.println("Введите цифру: от 0 до 5");
                int num = scanner.nextInt();
                switch (num) {
                    case 1:
                        user1.showAllBooks();
                        break;
                    case 2:
                        user1.searchBookByTitle(scanner);
                        break;
                    case 3:
                        user1.searchBookByAuthor(scanner);
                        break;
                    case 4:
                        user1.searchBookByType(scanner);
                        break;
                    case 5:
                        user1.wishAddBook(scanner);
                        break;
                    case 0:
                        System.out.println("Досвидания");
                        flag = true;
                        break;
                }
            }
        }
        if (Admin.open_admin == true) {
            System.out.println("Что желаете выполнить: " + "1 - Отсортировать книги по названию " +
                    "\n2- Отсортировать книги по автору " + "\n3 - Отсортировать книги по жанру " +
                    "\n4 - Добавить книги на рассмотрении в общий каталог книг" +
                    "\n5 - Просмотреть все книги на рассмотрении " +
                    "\n0 - выйти из аккаунта");
            boolean flag = false;
            while (!flag) {
                System.out.println("Введите цифру: от 0 до 4 ");
                int num = scanner.nextInt();
                switch (num) {
                    case 1:
                        admin.sortBookTitle();
                        break;
                    case 2:
                        admin.sortBookAuthor();
                        break;
                    case 3:
                        admin.sortBookType();
                        break;
                    case 4:
                        admin.addBook();
                        break;
                    case 5:
                        admin.catalogBooksPending();
                        break;
                    case 0:
                        System.out.println("Досвидания");
                        flag = true;
                        break;
                }
            }
        }
    }
}
