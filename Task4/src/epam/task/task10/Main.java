package epam.task.task10;

/*
* 10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
методами. Задать критерии выбора данных и вывести эти данные на консоль.
Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
Найти и вывести:
a) список рейсов для заданного пункта назначения;
b) список рейсов для заданного дня недели;
c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
* */
public class Main {
    public static void main(String[] args) {
        Airline one = new Airline("Гомель", 747, "Boeing", 12.01,
                "Вторник");
        Airlines two = new Airlines();
        two.add(one);
        two.add(new Airline("Минск", 748, "BoeingMAX", 12.43,
                "Вторник"));
        two.add(new Airline("Витебск", 758, "BoeingMAX737", 12.52,
                "Вторник"));
        two.flight_list_for_destination("Минск");
        two.flight_list_for_day_of_week("Вторник");
        two.flight_list_for_day_of_week("Среду");
        two.flight_list_for_day_of_week_number_flight_more("Вторник",12.10);
    }
}
