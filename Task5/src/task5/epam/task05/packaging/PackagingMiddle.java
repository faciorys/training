package task5.epam.task05.packaging;

import task5.epam.task05.flowers.Flowers;

import java.util.List;

/**
 * Класс Средняя упаковка
 *
 * @author faciorys
 */
public class PackagingMiddle extends Packaging {
    private final double maxVolume = 50;
    private final int cost = 5;
    private final String typePackaging = "Middle packaging";

    public PackagingMiddle(List<Flowers> flowers) {
        super(flowers);
    }

    @Override
    public double getMaxVolume() {
        return maxVolume;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String getTypePackaging() {
        return typePackaging;
    }
}
