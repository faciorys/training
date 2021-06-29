package epam.task.task15;

import java.util.Scanner;

public class Client {
    private String surname;
    private String firstname;
    private int age;

    public Client(String surname, String firstname, int age) {
        this.surname = surname;
        this.firstname = firstname;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getAge() {
        return age;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public static Client get(Scanner scanner) {
        Client client = new Client("","", 1);
        System.out.println("Введите Фамилию: ");
        client.surname = scanner.next();
        System.out.println("Введите Имя: ");
        client.firstname = scanner.next();
        System.out.println("Введите Возраст: ");
        client.age = scanner.nextInt();
        return client;
    }

}
