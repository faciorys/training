package epam.task.task07;

import java.util.Scanner;

/*
* 7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
* площади, периметра и точки пересечения медиан.
* */
public class Main {
    public static void main(String[] args) {
        Triangle one = new Triangle(3,4);
        one.createSquareTriangle();
        one.calculateArea();
        one.perimeter();
        Triangle three = new Triangle(1,2,3,4,5,4);
        three.calculateArea_Сoordinate();
        three.perimeter_Coordinate();
        three.median_intersection_point();
    }
}
