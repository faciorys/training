package epam.task.task10;

public class Airline {
    private String destination;
    private int number_flight;
    private String type_airplane;
    private double departure_time;
    private String day_of_week;

    public Airline(String destination, int number_flight, String type_airplane,
                   double departure_time, String day_of_week) {
        this.destination = destination;
        this.number_flight = number_flight;
        this.type_airplane = type_airplane;
        this.departure_time = departure_time;
        this.day_of_week = day_of_week;
    }

    public Airline() {
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumber_flight() {
        return number_flight;
    }

    public void setNumber_flight(int number_flight) {
        this.number_flight = number_flight;
    }

    public String getType_airplane() {
        return type_airplane;
    }

    public void setType_airplane(String type_airplane) {
        this.type_airplane = type_airplane;
    }

    public double getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(double departure_time) {
        this.departure_time = departure_time;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "destination='" + destination + '\'' +
                ", number_flight=" + number_flight +
                ", type_airplane='" + type_airplane + '\'' +
                ", departure_time=" + departure_time +
                ", day_of_week='" + day_of_week + '\'' +
                '}';
    }
}
