package epam.task.task13;

// Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
//столицу, количество областей, площадь, областные центры.
public class Main {
    public static void main(String[] args) {
        Country country = new Country("Беларусь", "Минск");
        country.addCity(new City("Минск"));

        City city = new City("Витебск");
        country.addCity(city);

        country.addDistrict(new District("Гомельский район"));
        country.addDistrict(new District("Минский район"));

        country.addRegion(new Region("Гомельская область", 133));
        country.addRegion(new Region("Минская область", 132));
        country.addCity(new City("Нью-Йорк"));
        country.addCity(city);

        System.out.println(country.toString());
    }
}
