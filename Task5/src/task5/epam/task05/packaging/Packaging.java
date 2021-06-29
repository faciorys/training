package task5.epam.task05.packaging;

import task5.epam.task05.flowers.Flowers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Основной класс для создания объекта Цветочная композиция
 *
 * @author faciorys
 */
public abstract class Packaging {
    private List<Flowers> flowersList = new ArrayList<>();

    public Packaging(Flowers flowers) {
        flowersList.add(flowers);
    }

    public Packaging(List<Flowers> flowers) {
        flowersList.addAll(flowers);
    }

    public abstract double getMaxVolume();

    public abstract int getCost();

    public abstract String getTypePackaging();

    public void showInfoBouquet() {

        double cost = 0;
        double volume = 0;
        for (Flowers fl : flowersList) {

            cost += fl.getCost();
            volume += fl.getVolume();
        }
        System.out.println("Общий объем упаковки - " + volume + "\nЦена за букет - " + cost + " $" +
                "\nТип упаковки - " + getTypePackaging());
        bouquet_of_flowers();
    }

    public void bouquet_of_flowers() {
        System.out.println("Букет состоит из цветов: ");
        for (Flowers f : flowersList) {
            System.out.print(f.getCount() + " " + f.getName() + " ");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Packaging packaging = (Packaging) o;
        return Objects.equals(flowersList, packaging.flowersList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowersList);
    }
}
