package task5.epam.task05.packaging;

import task5.epam.task05.flowers.Flowers;

import java.util.List;

/**
 * Класс Без упаковки
 *
 * @author faciorys
 */
public class OnHands extends Packaging {
    private final double maxVolume = 100000;
    private final int cost = 1;
    private final String typePackaging = "On hands";

    public OnHands(List<Flowers> flowers) {
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
