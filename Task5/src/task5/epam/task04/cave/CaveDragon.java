package task5.epam.task04.cave;

import task5.epam.task04.treasure.MetalType;
import task5.epam.task04.treasure.Treasure;
import task5.epam.task04.treasure.TreasureDragon;
import task5.epam.task04.treasure.TreasureType;

import java.util.*;

/**
 * Основной класс и основные методы
 *
 * @author faciorys
 */
public class CaveDragon {
    private Treasure treasure;
    private List<Treasure> treasureList;

    public CaveDragon() {
        treasureList = new ArrayList<>();
        generatorTreasure();

    }

    /**
     * Метод вывода всех драгоценностей.
     */
    public void showTreasure() {
        treasureList.forEach(System.out::println);
    }

    /**
     * Метод вывода самого ценного сокровища.
     */
    public void mostPreciousTreasure() {
        int tmp = 0;
        int c = 0;
        for (int i = 0; i < treasureList.size(); i++) {
            if (tmp < treasureList.get(i).getCost()) {
                tmp = treasureList.get(i).getCost();
                c = i;
            }
        }
        System.out.println(treasureList.get(c));
    }

    /**
     * Метод вывода сокровищ на определенную сумму
     */
    public void chooseTreasure(int sum) {
        List<Treasure> tr = new ArrayList<>();
        int summa = sum;
        System.out.println("Сокровища на сумму до - " + sum);
        for (Treasure treas : treasureList) {
            if (summa > treas.getCost()) {
                summa -= treas.getCost();
                tr.add(treas);
            }
        }
        for (Treasure t : tr) {
            System.out.println(t);
        }
    }

    /**
     * Метод - генератор сокровищ
     */
    private void generatorTreasure() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            String name = "treasure description ";
            MetalType r = randomEnum(MetalType.class);
            if (MetalType.GOLD.equals(r)) {
                treasureList.add(new TreasureDragon(randomEnum(TreasureType.class),
                        r, name, random.nextInt(300) + 100));
            }
            if (MetalType.SILVER.equals(r)) {
                treasureList.add(new TreasureDragon(randomEnum(TreasureType.class),
                        r, name, random.nextInt(150) + 20));
            }
        }
    }

    private <T extends Enum<?>> T randomEnum(Class<T> tClass) {
        Random random = new Random();
        int x = random.nextInt(tClass.getEnumConstants().length);
        return tClass.getEnumConstants()[x];
    }
}
