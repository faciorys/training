package epam.task.task10;

public class Airlines {
    private Airline[] airlines;
    private int capacity;
    private int size;

    public Airlines(int capacity) {
        size = 0;
        this.capacity = capacity;
        airlines = new Airline[capacity];
    }

    public Airlines() {
        this(10);
    }

    public void add(Airline airline) {
        if (size < capacity) {
            airlines[size] = airline;
            size++;
        } else {
            Airline[] temp = new Airline[capacity + 5];
            for (int i = 0; i < size; ++i) {
                temp[i] = airlines[i];
            }
            airlines = temp;
            capacity = capacity + 5;
            airlines[size] = airline;
            size++;
        }
    }
    public void flight_list_for_destination (String destination_) {
        System.out.println("Список рейсов для пункта назначения: " + destination_);
        int count = 0;
        for (int i = 0; i < size; ++i) {
            if (airlines[i].getDestination().equals(destination_)) {
                count++;
                System.out.println(airlines[i].toString());
            }
        }
        if (count == 0) {
            System.out.println("Рейсов в " + destination_ + " нету.");
        }
    }
    public void flight_list_for_day_of_week (String day_of_week_) {
        System.out.println("Список рейсов на: " + day_of_week_);
        int count = 0;
        for (int i = 0; i < size; ++i) {
            if (airlines[i].getDay_of_week().equals(day_of_week_)) {
                count++;
                System.out.println(airlines[i].toString());
            }
        }
        if (count == 0) {
            System.out.println("Рейсов в " + day_of_week_ + " нету.");
        }
    }
    public void flight_list_for_day_of_week_number_flight_more(String day_of_week_, double num_flight) {
        System.out.println("Список рейсов на: " + day_of_week_ + " время вылета больше " + num_flight);
        int count = 0;
        for (int i = 0; i < size; ++i) {
            if (airlines[i].getDay_of_week().equals(day_of_week_)) {
                if (num_flight< airlines[i].getDeparture_time()) {
                count++;
                System.out.println(airlines[i].toString());}
            }
        }
        if (count == 0) {
            System.out.println("Рейсов в: " + day_of_week_ + " время вылета больше " + num_flight + " нету.");
        }
    }
}
