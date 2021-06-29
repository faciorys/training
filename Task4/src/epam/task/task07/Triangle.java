package epam.task.task07;

import java.util.Scanner;

public class Triangle {
    double a;
    double b;
    double c;
    double aX, bX, cX;

    public Triangle(double aX, double aY, double bX, double bY, double cX, double cY) {
        this.aX = aX;
        this.bX = bX;
        this.cX = cX;
        this.aY = aY;
        this.bY = bY;
        this.cY = cY;
    }

    public double get_aX() {
        return aX;
    }

    public void set_aX(double aX) {
        this.aX = aX;
    }

    public double get_bX() {
        return bX;
    }

    public void set_bX(double bX) {
        this.bX = bX;
    }

    public double get_cX() {
        return cX;
    }

    public void set_cX(double cX) {
        this.cX = cX;
    }

    public double get_aY() {
        return aY;
    }

    public void set_aY(double aY) {
        this.aY = aY;
    }

    public double get_bY() {
        return bY;
    }

    public void set_bY(double bY) {
        this.bY = bY;
    }

    public double get_cY() {
        return cY;
    }

    public void set_cY(double cY) {
        this.cY = cY;
    }

    double aY, bY, cY;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public Triangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle() {

    }

    static Triangle read(Scanner scanner) {
        Triangle triangle = new Triangle();

        System.out.println("a: ");
        triangle.setA(scanner.nextInt());

        System.out.println("b: ");
        triangle.setB(scanner.nextInt());

        System.out.println("c: ");
        triangle.setC(scanner.nextInt());
        if (triangle.getC() >= triangle.getA() + triangle.getB() ||
                triangle.getC() <= Math.abs(triangle.getA() - triangle.getB())) {
            return triangle.triangleDoesNotExist();
        } else
            return triangle;
    }

    public void createSquareTriangle(int a, int b) {
        c = Math.sqrt(a * a + b * b);
        System.out.println("Создан прямоугольный треугольник с длинами сторон : "
                + "\na = " + a + "\nb = " + b + "\nc = " + String.format("%.3f", c));
    }

    public void createSquareTriangle() {
        c = Math.sqrt(a * a + b * b);
        System.out.println("Создан прямоугольный треугольник с длинами сторон : "
                + "\na = " + a + "\nb = " + b + "\nc = " + String.format("%.3f", c));
    }

    public Triangle triangleDoesNotExist() {
        System.out.println("Треугольник не существует");
        return null;
    }

    public void calculateArea() {
        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println("Площадь треугольника: " + s);
    }

    public void perimeter() {
        double p = (a + b + c) / 2;
        System.out.println("Периметр треугольника: " + p);
    }

    public void median_intersection_point() {
        double m2 = (aX + bX + cX) / 3;
        double m3 = (aY + bY + cY) / 3;
        System.out.println("Точка пересечения медиан: (" + m2 + ", " + m3 + ")");
    }

    public void calculateArea_Сoordinate() {
        double S = 0.5 * Math.abs(Math.abs(aX - cX) * Math.abs(bY - cY) - Math.abs(bX - bY) * Math.abs(aY - cY));
        System.out.println("Площадь треугольника: " + S);
    }

    public void perimeter_Coordinate() {
        a = Math.sqrt(Math.pow(aX - bX, 2) + Math.pow(aY - bY, 2));
        b = Math.sqrt(Math.pow(aX - cX, 2) + Math.pow(aY - cY, 2));
        c = Math.sqrt(Math.pow(cX - bX, 2) + Math.pow(cY - bY, 2));
        perimeter();
    }
}
