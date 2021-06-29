package task5.epam.task04.treasure;

/**
 * Класс для драгоценностей.
 *
 * @author faciorys
 */
public class TreasureDragon implements Treasure {
    private TreasureType treasureType;
    private MetalType metalType;
    private String name;
    private int cost;

    public TreasureDragon(TreasureType treasureType, MetalType metalType, String name, int cost) {
        this.treasureType = treasureType;
        this.metalType = metalType;
        this.name = name;
        this.cost = cost;
    }

    @Override
    public TreasureType getTreasureType() {
        return treasureType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Драгоценность - " + treasureType +
                ", тип металла - " + metalType +
                ", стоимость - " + cost;
    }
}
