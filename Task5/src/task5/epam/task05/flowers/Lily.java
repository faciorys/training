package task5.epam.task05.flowers;

/**
 * Класс Лилия
 *
 * @author faciorys
 */
public class Lily implements Flowers {
    private final String name = "Lily";
    private final int cost = 8;
    private int count;
    private final double volume = 2.2;

    public Lily(int count) {
        this.count = count;
    }

    public Lily() {
        this.count = 1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double getVolume() {
        return volume * count;
    }

    @Override
    public int getCost() {
        return cost * count;
    }

    @Override
    public String toString() {
        return "Lily{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", count=" + count +
                ", volume=" + volume +
                '}';
    }
}
