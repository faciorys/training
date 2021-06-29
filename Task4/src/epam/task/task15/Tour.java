package epam.task.task15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Tour {
    public enum Type {
        REST, TREATMENT, EXCURSION, SHOPPING, CRUISE
    }

    public enum Transport {
        BUS, AIRPLANE, TRAIN
    }
    private Tour[] tours;
    private int capacity;
    private int size;

    public Tour(int capacity) {
        size = 0;
        this.capacity = capacity;
        tours = new Tour[capacity];
    }

    // По умолчанию массив размером 10
    public Tour() {
        this(10);
    }

    // Используем метод add по аналогии с ArrayList
    public void add(Tour tour) {
        if (size < capacity) {
            tours[size] = tour;
            size++;
        } else {
          Tour[] temp = new Tour[capacity + 5];
            for (int i = 0; i < size; ++i) {
                temp[i] = tours[i];
            }
            tours = temp;
            capacity = capacity + 5;
            tours[size] = tour;
            size++;
        }
    }

    private Type type_of_voucher;
    private int number_of_days;
    private String amount_of_food;
    private Transport transport;
    private Client client;

    public Tour(Client client, Type type_of_voucher, int number_of_days, String amount_of_food, Transport transport) {
        this.type_of_voucher = type_of_voucher;
        this.number_of_days = number_of_days;
        this.amount_of_food = amount_of_food;
        this.transport = transport;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Type getType_of_voucher() {
        return type_of_voucher;
    }

    public void setType_of_voucher(Type type_of_voucher) {
        this.type_of_voucher = type_of_voucher;
    }

    public int getNumber_of_days() {
        return number_of_days;
    }

    public void setNumber_of_days(int number_of_days) {
        this.number_of_days = number_of_days;
    }


    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public static Tour get(Scanner scanner) {
        Tour tour = new Tour(new Client("", "", 1), Type.CRUISE, 123, "",
                Transport.BUS);
        System.out.println("Введите Данные пушественника: ");
        tour.client = Client.get(scanner);
        System.out.println("Введите тип путевки: (отдых,круиз,экскурсия,лечение,шопинг)");
        while (true) {
            String value = scanner.next();
            if (value.equals("отдых")) {
                tour.type_of_voucher = Type.REST;
                break;
            }
            if (value.equals("круиз")) {
                tour.type_of_voucher = Type.CRUISE;
                break;
            }
            if (value.equals("экскурсия")) {
                tour.type_of_voucher = Type.EXCURSION;
                break;
            }
            if (value.equals("лечение")) {
                tour.type_of_voucher = Type.TREATMENT;
                break;
            }
            if (value.equals("шопинг")) {
                tour.type_of_voucher = Type.SHOPPING;
                break;
            }
            System.out.println("Введено неправильное значение, повторите ввод.");
        }
        System.out.print("Количество дней пребывания: ");
        tour.number_of_days = scanner.nextInt() ;
        System.out.println("Количество приемов пищи: 0 - без питания " +
                "1 - завтраки, 2 - all inclusive");
        while (true) {
            int value = scanner.nextInt();
            if (value == 0) {
                tour.amount_of_food = "без питания";
                break;
            }
            if (value == 1) {
                tour.amount_of_food = "только завтраки";
                break;
            }
            if (value == 2) {
                tour.amount_of_food = "all inclusive";
                break;
            }
            System.out.println("Введено неправильное значение, повторите ввод.");
        }
        System.out.println("Введи транспорт на котором желаете добраться до отдыха:" +
                " (автобус, самолет, поезд)");
        while (true) {
            String value = scanner.next();
            if (value.equals("автобус")) {
                tour.transport = Transport.BUS;
                break;
            }
            if (value.equals("самолет")) {
                tour.transport = Transport.AIRPLANE;
                break;
            }
            if (value.equals("поезд")) {
                tour.transport = Transport.TRAIN;
                break;
            }
            System.out.println("Введено неправильное значение, повторите ввод.");
        }
        return tour;
    }

    @Override
    public String toString() {
        String tour = "";
        tour = "Фамилия: " + client.getSurname() + ", Имя: " + client.getFirstname() +
                ", Возраст: " + client.getAge() + ", Вид путешествия: " + type_of_voucher +
        ", Количество дней отдыха - " + number_of_days + ", Вид питания: " + amount_of_food +
        ", Трансфер - " + transport;
        return tour;
    }
    public void print() {
        for (Tour t : tours) {
            if (t != null) {
                System.out.println(t.toString());
            }
        }
    }
    public void sort_type_voucher() {
        Arrays.sort(tours, 0, size, new Comparator<Tour>() {
            @Override
            public int compare(Tour o1, Tour o2) {
                return o1.getType_of_voucher().compareTo(o2.getType_of_voucher());
            }
        });
    }
}
