package task5.epam.task05.flowers;

/**
 * Класс Роза
 *
 * @author faciorys
 */
public class Rose implements Flowers {
    private final String name = "Rose";
    private final int cost = 5;
    private int count;
    private final double volume = 1.5;

    public Rose(int count) {
        this.count = count;
    }

    public Rose() {
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
        return "Rose{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", count=" + count +
                ", volume=" + volume +
                '}';
    }
}
