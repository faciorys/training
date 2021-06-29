package task06.epam.task4;

/**
 * Класс Порт со всеми характеристиками
 *
 * @author faciorys
 */
public class Port extends Thread {
    public static volatile int countContainer = 120;
    private int piers = 3;
    private int maxContainersPort = 600;

    public static void setCountContainer(int countContainer) {
        Port.countContainer = countContainer;
    }

    public static int getCountContainer() {
        return countContainer;
    }

    public int getPiers() {
        return piers;
    }

    public int getMaxContainersPort() {
        return maxContainersPort;
    }
}
