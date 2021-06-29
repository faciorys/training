package task06.epam.task4;

import java.util.Random;

/**
 * Класс Корабли и основной метод run
 *
 * @author faciorys
 */
public class Ships extends Thread {
    public static volatile int countShip = 0;
    private int countContainersShip;
    private TypeLoad load;
    private int maxContainersShip;
    private static boolean mayCome = true;

    public int getMaxContainersShip() {
        return maxContainersShip;
    }

    public void setCountContainersShip(int countContainersShip) {
        this.countContainersShip = countContainersShip;
    }

    public int getCountContainersShip() {
        return countContainersShip;
    }

    public void setMaxContainersShip(int maxContainersShip) {
        this.maxContainersShip = maxContainersShip;
    }

    public Ships(String nameShip, int countContainersShip, TypeLoad load, int maxContainersShip) {
        super(nameShip);
        this.countContainersShip = countContainersShip;
        this.load = load;
        this.maxContainersShip = maxContainersShip;
    }

    @Override
    public void run() {
        Random r = new Random();
        Port p = new Port();
//        кол-во кораблей всего (в пирсах)
        countShip++;
//        Если пирсы заняты, то корабли ожидают
        if (countShip > p.getPiers()) {
            countShip--;
            while ((countShip >= p.getPiers()) || mayCome) {
                System.out.println("Корабль " + getName() + " ожидает захода в порт");
                try {
                    Thread.sleep(r.nextInt(2500) + 2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mayCome = true;
            countShip++;
        }
//        Если пирсы свободен, то
        if (countShip <= p.getPiers()) {
//           если на загрузку в порт то :
            if (load == TypeLoad.LOADING) {

                try {
                    while (getCountContainersShip() <= getMaxContainersShip() || Port.getCountContainer() == 0) {
                        if (Port.getCountContainer() > 2) {
                            method2();
                        } else {
                            Thread.sleep(r.nextInt(1000) + 3000);
                            if (Port.getCountContainer() == 0) {
                                break;
                            }
                            method2();
                        }
                    }
                    countShip--;
                    mayCome = false;
                    System.out.println("Корабль " + getName() + " вышел из порта");
                    System.out.println("В порту " + Port.getCountContainer() + " контейнеров");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//           если на разгрузку в порт то :
            } else if (load == TypeLoad.UNLOADING) {
                boolean fl = true;
                try {
//                    если количество контейнеров на корабле 0 то корабль уходит
                    while (getCountContainersShip() >= 0 || (p.getMaxContainersPort() == Port.getCountContainer())) {
                        if (Port.getCountContainer() < p.getMaxContainersPort() - 3) {
                            method1();
                        } else {
                            Thread.sleep(r.nextInt(6000) + 1000);
                            if (Port.getCountContainer() == p.getMaxContainersPort()) {
                                break;
                            }
                            method1();
                        }
                    }
                    countShip--;
                    mayCome = false;
                    System.out.println("Корабль " + getName() + " вышел из порта");
                    System.out.println("В порту " + Port.getCountContainer() + " контейнеров");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void method1() throws InterruptedException {
        System.out.println("Корабль " + getName() + " разгружает контейнеры");
        System.out.println("Осталось разгурзить " + (getCountContainersShip()) + " контейнеров");
        Thread.sleep(2000);
        setCountContainersShip(getCountContainersShip() - 1);
        Port.setCountContainer(Port.getCountContainer() + 1);
    }

    private synchronized void method2() throws InterruptedException {
        System.out.println("Корабль " + getName() + " загружает контейнеры");
        System.out.println("Осталось загрузить " + (getMaxContainersShip() - getCountContainersShip()) + " контейнеров");
        Thread.sleep(1000);
        setCountContainersShip(getCountContainersShip() + 1);
        Port.setCountContainer(Port.getCountContainer() - 1);
    }
}
