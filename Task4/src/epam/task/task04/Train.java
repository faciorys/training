package epam.task.task04;

import java.util.*;

/*
* 4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
* Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
* номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
* Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
* назначения должны быть упорядочены по времени отправления.
* */
public class Train {
    String destination;
    int number_train;
    double departure_time;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumber_train() {
        return number_train;
    }

    public void setNumber_train(int number_train) {
        this.number_train = number_train;
    }

    public double getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(double departure_time) {
        this.departure_time = departure_time;
    }

    public Train(String destination, int number_train, double departure_time) {
        this.destination = destination;
        this.number_train = number_train;
        this.departure_time = departure_time;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Train> trains = new ArrayList<>();
        trains.add(new Train("Гомель", 100, 14.30));
        trains.add(new Train("Минск", 103, 10.15));
        trains.add(new Train("Витебск", 102, 18.50));
        trains.add(new Train("Минск", 101, 10.13));
        trains.add(new Train("Костюковка", 104, 23.59));
        trains.sort(new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                return o1.getNumber_train() - o2.getNumber_train();
            }
        });
        trains.get(1).about();
        System.out.print("Введите номре поезда: ");
        int str = scanner.nextInt();
        for (int i = 0; i < trains.size(); i++) {
            if (trains.get(i).getNumber_train() == str) {
                trains.get(i).about();
            }
        }
        trains.sort(new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                int res = o1.getDestination().compareTo(o2.getDestination());
                if (res != 0) return res;
                res = Double.compare(o1.getDeparture_time(), o2.getDeparture_time());
                if (res != 0) return res;
                return o1.getDestination().compareTo(o2.getDestination());
            }
        });
        for (int i = 0; i < trains.size(); i++) {
            trains.get(i).about();
        }

    }

    void about() {
        System.out.printf("Пункт назначения: %s  Номер поезда: %s Время отправления %s\n", destination,
                number_train, departure_time);
    }
}
