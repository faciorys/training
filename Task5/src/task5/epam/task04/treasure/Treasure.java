package task5.epam.task04.treasure;

/**
 * Интерфейс сокровищ.
 *
 * @author faciorys
 */
public interface Treasure {
    TreasureType getTreasureType();
    String getName();
    int getCost();
}
