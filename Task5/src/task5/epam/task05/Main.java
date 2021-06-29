package task5.epam.task05;

import task5.epam.task05.flowers.Chamomile;
import task5.epam.task05.flowers.Flowers;
import task5.epam.task05.flowers.Lily;
import task5.epam.task05.flowers.Rose;
import task5.epam.task05.packaging.*;

import java.util.ArrayList;
import java.util.List;

/*
* Создать консольное приложение, удовлетворяющее следующим требованиям:
- Корректно спроектируйте и реализуйте предметную область задачи.
- Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов
проектирования.
- Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
- для проверки корректности переданных данных можно применить регулярные выражения.
- Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
- Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().
*
Вариант A. Цветочная композиция. Реализовать приложение, позволяющее создавать цветочные композиции (объект,
*  представляющий собой цветочную композицию). Составляющими цветочной композиции являются цветы и упаковка.
* */
public class Main {
    private static Packaging packaging;
    private static List<Flowers> flowersList = new ArrayList<>();

    public static void main(String[] args) {
        //имитация/заглушка меню
        choosingFlowers("Rose, Lily, Chamomile");
        packaging = choosingPackaging(flowersList);

        packaging.showInfoBouquet();
    }

    private static void choosingFlowers(String str) {
        if (str.toLowerCase().contains("chamomile")) {
            flowersList.add(new Chamomile(200));
        }
        if (str.toLowerCase().contains("lily")) {
            flowersList.add(new Lily(3));
        }
        if (str.toLowerCase().contains("rose")) {
            flowersList.add(new Rose(10));
        }
    }

    private static Packaging choosingPackaging(List<Flowers> flow) {
        double volume = 0;
        for (Flowers fl : flow) {
            volume += fl.getVolume();
        }
        if (volume <= 20) {
            return new PackagingSmall(flow);
        } else if (volume <= 50) {
            return new PackagingMiddle(flow);
        } else if (volume <= 100) {
            return new PackagingBig(flow);
        }
        return new OnHands(flow);
    }
}

