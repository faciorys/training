package epam.traning.unit01;

import java.math.BigInteger;
import java.util.Scanner;

public class Unit01 {
    public static void allTasks() {
//        task01 - task06  - linear programs (Линейные программы)
        task01();
        task02();
        task03();
        task04();
        task05();
        task06();
//        task10 - task14  - branch (Ветвления)
        task10();
        task11();
        task12();
        task13();
        task14();
//        task20 - task27  - cycles (Циклы)
        task20();
        task21();
        task22();
        task23();
        task24();
        task25();
        task26();
        task27();
    }

    //Найдите значение функции z = ((a-3)*b/2)+c.
    private static void task01() {
        double a, b, c, z;
        Scanner scan = new Scanner(System.in);
        a = scan.nextDouble();
        b = scan.nextDouble();
        c = scan.nextDouble();

        z = ((a - 3) * b / 2) + c;
        System.out.println("z = " + z);
    }

    // Вычислите значение выражения по формуле
    // ((b + Math.sqrt(Math.pow(b, 2)+ 4*a*c))/2*a) - Math.pow(a,3)*c+Math.pow(b,-2);
    private static void task02() {
        double a, b, c, z;

        Scanner scan = new Scanner(System.in);
        a = scan.nextDouble();
        b = scan.nextDouble();
        c = scan.nextDouble();

        z = ((b + Math.sqrt(Math.pow(b, 2) + 4 * a * c)) / 2 * a) - Math.pow(a, 3) * c + Math.pow(b, -2);
        System.out.println("z = " + z);
    }

    // Вычислите значение выражения по формуле
    // ((Math.sin(x) + Math.cos(y))/ (Math.cos(x) - Math.sin(y))) * Math.tan(x*y);
    private static void task03() {
        double x, y, z;

        Scanner scanner = new Scanner(System.in);
        x = scanner.nextDouble();
        y = scanner.nextDouble();

        z = ((Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y))) * Math.tan(x * y);
        System.out.println("z = " + z);
    }

    // Поменять местами дробную и целую часть (где R вида nnn.ddd)
    private static void task04() {
        double R = 341.223;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        String stringR = String.valueOf(R);
        String[] stringsSplit = stringR.split("");
        for (int a = 4; a < stringR.length(); a++) {
            sb.append(stringsSplit[a]);
            count++;
            if (count == 3) {
                sb.append(stringsSplit[count]);
                count++;
                a = -1;
            }
            if (count == 7) {
                break;
            }
        }
        double newR = Double.parseDouble(String.valueOf(sb));
        System.out.println(newR);
    }

    //   Дано натуральное число T, которое представляет длительность прошедшего времени в секундах.
    //   Вывести данное значение длительности в часах, минутах, секундах.
    private static void task05() {
        int T = 3662;
        int HH = T / 3600;
        int MM = (T - HH * 3600) / 60;
        int SS = (T - HH * 3600 - MM * 60);
        System.out.println(HH + "ч " + MM + "мин " + SS + "с.");
    }

    // Составить линейную программу, которая печатает true если точка в закрашенной области, иначе false
    private static void task06() {
        Scanner scanner = new Scanner(System.in);
        int numberX = scanner.nextInt();
        int numberY = scanner.nextInt();
        if ((!(-4 < numberX & numberX < 4)) || (!(-3 < numberY & numberY < 4))) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }

    // Даны два угла треугольника. Определить, существует ли такой треугольник, если да,
    // то будет ли он прямоугольным.
    private static void task10() {
        Scanner scan = new Scanner(System.in);
        boolean flaq = true;
        int a = scan.nextInt();
        int b = scan.nextInt();
        if ((a | b) <= 0 || a + b >= 180) {
            System.out.println("Треугольник не существует");
            flaq = false;
        }
        if (flaq) {
            int c = 180 - a - b;
            if (c == 90 || b == 90 || a == 90) {
                System.out.println("Треугольник Прямоугольный");
            } else System.out.println("Треугольник существует");
        }
    }

    // Найти max{min(a,b),min(c,d)}
    private static void task11() {
        double a = 1, b = 12, c = 111, d = 2;

        if ((a > b) && (c > d)) {
            if (b > d) {
                System.out.println(b);
            } else System.out.println(d);
        }
        if ((a > b) && (c < d)) {
            if (b > c) {
                System.out.println(b);
            } else System.out.println(c);
        }
        if ((a < b) && (c < d)) {
            if (a > c) {
                System.out.println(a);
            } else System.out.println(c);
        }
        if ((a < b) && (c > d)) {
            if (a > d) {
                System.out.println(a);
            } else System.out.println(d);
        }
// System.out.println(Math.max(Math.min(a, b), Math.min(c, d)));
    }

    // Определить, будет ли точки расположены на одной прямой.
    private static void task12() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите x1: ");
        int x1 = scanner.nextInt();
        System.out.print("Введите y1: ");
        int y1 = scanner.nextInt();
        System.out.print("Введите x2: ");
        int x2 = scanner.nextInt();
        System.out.print("Введите y2: ");
        int y2 = scanner.nextInt();
        System.out.print("Введите x3: ");
        int x3 = scanner.nextInt();
        System.out.print("Введите y3: ");
        int y3 = scanner.nextInt();


        if ((x3 - x1) / (x2 - x1) == (y3 - y1) / (y2 - y1)) {
            System.out.println("Точки расположены на одной прямой");
        } else System.out.println("Точки НЕ расположены на одной прямой");
    }

    // Заданы размеры точки А, В прямоугольного отверстия и размеры x,y,z кирпича.
    // Определить пройдет ли кирпич в отверстие.
    private static void task13() {
        int[] AB = {10, 10};
        int[] xyz = {11, 10, 5};
        int minAB;
        if (AB[0] >= AB[1]) {
            minAB = AB[1];
        } else {
            minAB = AB[0];
        }
        if ((xyz[0] <= minAB) && (xyz[1] <= minAB)) {
            System.out.println("Кирпич пройдет");
        } else if ((xyz[0] <= minAB) && (xyz[2] <= minAB)) {
            System.out.println("Кирпич пройдет");
        } else if ((xyz[1] <= minAB) && (xyz[2] <= minAB)) {
            System.out.println("Кирпич пройдет");
        } else {
            System.out.println("Кирпич не пройдет");
        }
    }

    //Вычислить значение функции (Math.pow(x, 2) - 3 * x + 9), если значение x<=3, иначе 1 / (Math.pow(x, 3) + 6);
    private static void task14() {
        double x = 3;
        double Fx;
        if (x <= 3) {
            Fx = (Math.pow(x, 2) - 3 * x + 9);
        } else {
            Fx = 1 / (Math.pow(x, 3) + 6);
        }
    }

    //Программа, где пользователь вводит любое положительное число. А программа суммирует
    //все числа от 1 до введенного числа.
    private static void task20() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int summ = 0;
        for (int a = 1; a <= num; a++) {
            summ += a;
        }
        System.out.println(summ);
    }

    //   Вычислить значения функции y = x, если x > 2 и y = -x, если x =< 2 на заданном отрезке с шагом h
    private static void task21() {
        double h = 0.2;
        double a = 1.2;
        double b = 2.5;
        double z;
        for (double x = a; x <= b; x = x + h) {
            if (x > 2) {
                z = x;
            } else {
                z = -x;
            }
            System.out.println(x + " " + z);
        }
    }

    //    Найти сумму квадратов первых ста чисел
    private static void task22() {
        int summ = 0;
        for (int a = 1; a <= 100; a++) {
            summ += Math.pow(a, 2);
        }
        System.out.println(summ);
    }

    // Программа нахождения произведения квадратов первых двухсот чисел
    private static void task23() {
        BigInteger s = BigInteger.valueOf(1);
        for (int i = 2; i <= 200; i++) {
            s = s.multiply(BigInteger.valueOf((long) i * i));
        }
        System.out.println(s);
    }

    // Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен заданному е.
    // a = (1 / (Math.pow(2, b))) + (1 / (Math.pow(3, b)));
    private static void task24() {
        double n = 0.1;
        double summ = 0;
        for (int b = 1; b < 100; b++) {
            double a = (1 / (Math.pow(2, b))) + (1 / (Math.pow(3, b)));
            if (a >= n) {
                summ += a;
            } else break;
        }
        System.out.println(summ);
    }

    // Вывести на экран соответствия между символами и их численными обозначениями в памяти компьютера
    private static void task25() {
        int[] aSCII = new int[128];
        for (int a = 1; a < aSCII.length; a++) {
            System.out.println((char) a + " " + a);
        }
    }

    // Для каждого натурального числа в промежутке от m до n вывести все делители, кроме еденицы и самого числа.
    // m и n вводятся с клавиатуры
    private static void task26() {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        if (m >= n) {
            for (int a = n; a <= m; a++) {
                System.out.print("\nЧисло " + a + " делители: ");
                for (int b = 2; b < a; b++) {
                    if (a % b == 0) {
                        System.out.print(b + " ");
                    }
                }
            }
        } else {
            for (int a = m; a <= n; a++) {
                System.out.print("\nЧисло " + a + " делители: ");
                for (int b = 2; b < a; b++) {
                    if (a % b == 0) {
                        System.out.print(b + " ");
                    }
                }
            }
        }
    }

    //Даны два числа.Определить цифры,входящие в запись как первого так и второго числа
    private static void task27() {
        boolean flaq = true;
        int A = 1024622133;
        int B = 1887205444;
        String numA = String.valueOf(A);
        String numB = String.valueOf(B);
        String[] numberA = numA.split("");
        String[] numberB = numB.split("");
        StringBuilder numsCongruence = new StringBuilder();
        for (int a = 0; a < 10; a++) {
            flaq = true;
            for (int c = 0; c < numA.length(); c++) {
                if (!flaq) {
                    break;
                }
                for (int d = 0; d < numB.length(); d++) {
                    if (Integer.parseInt(numberA[c]) == a && Integer.parseInt(numberB[d]) == a) {
                        numsCongruence.append(a + " ");
                        flaq = false;
                        break;

                    }
                }
            }
        }
        System.out.println("Цифры входящие в запись чисел А и B: " + numsCongruence);
    }
}
