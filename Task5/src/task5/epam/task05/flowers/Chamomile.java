package task5.epam.task05.flowers;

/**
 * Класс Ромашки
 *
 * @author faciorys
 */
public class Chamomile implements Flowers {
    private final String name = "Chamomile";
    private final int cost = 1;
    private int count;
    private final double volume = 0.2;

    public Chamomile(int count) {
        this.count = count;
    }

    public Chamomile() {
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
        return "Сhamomile{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", count=" + count +
                ", volume=" + volume +
                '}';
    }
}
