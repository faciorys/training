package task5.epam.task05.packaging;

import task5.epam.task05.flowers.Flowers;

import java.util.List;

/**
 * Класс Маленькая упаковка
 *
 * @author faciorys
 */
public class PackagingSmall extends Packaging {
    private final double maxVolume = 20;
    private final int cost = 3;
    private final String typePackaging = "Small packaging";

    public PackagingSmall(List<Flowers> flowers) {
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
