package task5.epam.task05.packaging;

import task5.epam.task05.flowers.Flowers;

import java.util.List;

/**
 * Класс Большая упаковка
 *
 * @author faciorys
 */
public class PackagingBig extends Packaging {
    private final double maxVolume = 100;
    private final int cost = 10;
    private final String typePackaging = "Big packaging";

    public PackagingBig(List<Flowers> flowers) {
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
