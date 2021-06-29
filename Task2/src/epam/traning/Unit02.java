package epam.traning;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Unit02 {
    public static void allTasks() {
//      task01() - task10() -  one-dimensional arrays (Одномерные массивы)
        task01();
        task02();
        task03();
        task04();
        task05();
        task06();
        task07();
        task08();
        task09();
        task10();
//      task11() - task26() -  arrays of arrays (Массивы массивов)
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
        task23();
        task24();
        task25();
        task26();
//       task27() - task34() -  one-dimensional arrays. Sorting. (Одномерные массивы. Сортировки)
        task27();
        task28();
        task29();
        task30();
        task31();
        task32();
        task33();
        task34();
//        task35() - task51() Decomposition using methods (Декомпозиция с использованием методов)
        task35();
        task36();
        task37();
        task38();
        task39();
        task40();
        task41();
        task42();
        task43();
        task44();
        task45();
        task46();
        task47();
        task48();
        task49();
        task50();
        task51();



    }

    // В массив А[N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному K.
    public static void task01() {
        int[] A = {23, 123, 434, 5, 56, 67, 8, 97, 9, 80, 122, 100, 678};
        int K = 7;
        int sum = 0;
        for (int a = 1; a < A.length; a++) {
            if (A[a] % a == 0) {
                sum += A[a];
            }
        }
        System.out.println("Сумма элементов кратных " + K + ": " + sum);
    }

    //Дана последовательность действительных чисел а1,a2, ... an. Заменить все ее члены, большие данного Z,
    //этим числом. Подсчитать количество замен.
    public static void task02() {
        int[] a = new int[30];
        int Z = 16;
        int countZ = 0;
        for (int b = 0; b < a.length; b++) {
            a[b] = b;
        }
        for (int c = 0; c < a.length; c++) {
            if (a[c] > Z) {
                a[c] = Z;
                countZ++;
            }
        }
        for (int c = 0; c < a.length; c++) {
            System.out.print(a[c] + " ");
        }
        System.out.println("\nКоличество замен: " + countZ);
    }

    //Дан массив действительных чисел, размерность которых N. Подсчитать, сколько в нем отрицательных,
    //положительных и нулевых элементов
    public static void task03() {
        Random random = new Random();
        int N = 30;
        int[] a = new int[N];
        int negativeNumbersCount = 0;
        int positiveNumbersCount = 0;
        int zeroNumbersCount = 0;
        for (int b = 0; b < a.length; b++) {
            a[b] = random.nextInt();
            if (a[b] > 0) {
                positiveNumbersCount++;
            }
            if (a[b] == 0) {
                zeroNumbersCount++;
            }
            if (a[b] < 0) {
                negativeNumbersCount++;
            }
        }
        System.out.println("Количество положительных элементов: " + positiveNumbersCount +
                "\nКоличество отрицательных элементов: " + negativeNumbersCount +
                "\nКоличество нулевых элементов: " + zeroNumbersCount);
    }

    //Даны действительные числа a1,a2... an. Поменять местами наибольший и наименьший элементы
    public static void task04() {
        int[] a = {5, 6, 3, 8, 9, 10, 22, 12};
        int minA = a[0], maxA = a[0];
        int minNum = 0, maxNum = 0;
        for (int b = 0; b < a.length; b++) {
            if (a[b] <= minA) {
                minA = a[b];
                minNum = b;
            }
            if (a[b] > maxA) {
                maxA = a[b];
                maxNum = b;
            }
        }
        int[] temp = new int[1];
        temp[0] = a[minNum];
        a[minNum] = a[maxNum];
        a[maxNum] = temp[0];
        for (int c = 0; c < a.length; c++) {
            System.out.print(a[c] + " ");
        }
    }

    //Даны целые числа a1,a2,...,an. Вывести на печать только те числа, для которых аi > i.
    public static void task05() {
        int[] a = {5, 6, 3, 8, 9, 10, 22, 1};
        int i = 7;
        System.out.print("Числа которые больше числа i: ");
        for (int b = 0; b < a.length; b++) {
            if (a[b] > i) {
                System.out.print(a[b] + " ");
            }
        }
    }

    //Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
    //являются простыми числами.
    public static void task06() {
        int[] a = {7, 841, 839, 2, 3, 8, 9, 10, 22, 1, 34, 79, 89, 131, 132, 150, 199, 70};
        int sum = 0;
        int count = 0;
        for (int b = 0; b < a.length; b++) {
            for (int c = 2; c < a[b]; c++) {
                if (a[b] % c != 0) {
                    count++;
                    if (count + 2 == a[b]) {
                        sum += a[b];
                        break;
                    }
                }
            }
            if (a[b] == 2) {
                sum += a[b];
            }
            count = 0;
        }
        System.out.println("Сумма простых чисел: " + sum);
    }

    //Даны действительные числа а1,a2,..., an. Найти max :(a(1) + a(2n), a(2)+a(2n-1), ..., a(n) + a(n+1).
    public static void task07() {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
            System.out.print(array[i] + " ");

        }
        System.out.println();
        int maxSum = array[0] + array[array.length - 1];
        for (int i = 1; i < array.length / 2; i++) {
            if ((array[i] + array[array.length - i - 1]) > maxSum) {
                maxSum = array[i] + array[array.length - i - 1];
            }

        }
        System.out.println(maxSum);
    }

    // Дана последовательность целых чисел a1,a2,... an. Образовать новую последовательность выбросив из исходной
    // те члены, которые равны min(a1,a2,.. an).
    public static void task08() {
        int n = 10;
        Random random = new Random();
        int[] num = new int[n];
        for (int i = 0; i < num.length; i++) {
            num[i] = random.nextInt(100);
            System.out.print(num[i] + " ");
        }
        System.out.println();
        int minA = num[0];
        int deleteCount = 0;
        for (int b = 0; b < num.length; b++) {
            if (num[b] < minA) {
                minA = num[b];
                deleteCount = 0;
            }
            if (minA == num[b]) {
                deleteCount++;
            }
        }
        boolean flaq = false;
        while (!flaq) {
            int count = 0;
            int[] temp = num;
            num = new int[temp.length - 1];

            for (int a = 0; a < temp.length; a++) {
                if (temp[a] == minA) {
                    deleteCount--;
                    break;
                } else
                    num[a] = temp[a];
                count++;
            }
            for (int b = count + 1; b < temp.length; b++) {
                num[b - 1] = temp[b];

            }
            if (deleteCount == 0) {
                flaq = true;
            }
        }
        for (int b = 0; b < num.length; b++) {
            System.out.print(num[b] + " ");
        }
    }

    // В массиве целых чисел с количеством элементов n найти наиболее часто встерчающееся число. Если таких чисел
    // несколькоб то определить наименьшее из них.
    public static void task09() {
        int n = 15;
        int num = 0, c = 0, numB = 0, max, numMax = 0, min;
        int[] array = new int[n];
        int[] b = new int[n];
        int[] d = new int[n];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] == array[j]) num++;
            }
            b[i] = num;
            num = 0;
        }

        for (int i = 0; i < b.length; i++) {
            if (b[i] == 1) numB++;
        }
        if (numB == b.length) System.out.println("Повторяющиеся элементы отсутствуют");

        else {
            max = b[0];
            for (int i = 0; i < b.length; i++) {
                if (max < b[i]) {
                    max = b[i];
                    c = i;
                }
            }
            for (int i = 0; i < b.length; i++) {
                if (max == b[i]) {
                    numMax++;
                }
            }
            if (numMax == 1) {
                System.out.println("Число " + array[c] + " встречается " + max + " раза");
            } else {
                for (int i = 0; i < b.length; i++) {
                    if (b[i] == max) {
                        d[i] = array[i];
                    }
                }
                min = d[0];
                c = 0;
                for (int i = 0; i < d.length; i++) {

                    if (min > d[i] && d[i] != 0) {
                        min = d[i];
                        c = i;
                    }
                }
                System.out.println("Число " + min + " встречается " + max + " раза");
            }
        }
    }

    // Дан целочисленный массив с количеством элементов n. Cжать массив, выбросив из него каждый второй элемент
    // (освободившиеся элементы заполнить нулями). Примечание: Дополнительный массив не использовать.
    public static void task10() {
        int n = 11;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int b = 0;
        for (int c = 0; c < array.length; c += 2) {
            array[b] = array[c];
            System.out.print(array[b] + " ");
            b++;
        }
        for (int t = b; t < n; t++) {
            array[b] = 0;
            System.out.print(array[b] + " ");
        }
    }

    // Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
    public static void task11() {
        int n = 5;
        int j = 5;
        int[][] matrixA = new int[n][j];
        Random random = new Random();
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < j; b++) {
                matrixA[a][b] = random.nextInt(100);
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }

        for (int b = 1; b < j; b += 2) {
            if (matrixA[0][b] > matrixA[n - 1][b]) {
                System.out.println("\nЧисла со столбца " + b + ": ");
                for (int c = 0; c < n; c++) {
                    System.out.print(matrixA[c][b] + "\t");
                }
            }
        }
    }

    //Дана квадратная матрица. Выести на экран элементы, стоящие на диоганали
    public static void task12() {
        int n = 5;
        int j = 5;
        int[][] matrixA = new int[n][j];
        Random random = new Random();
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < j; b++) {
                matrixA[a][b] = random.nextInt(100);
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
        System.out.println("Элементы диагонали слева на право: ");
        for (int c = 0; c < n; c++) {
            System.out.print(matrixA[c][c] + "\t");
        }
        System.out.println("\nЭлементы диагонали справа на лево: ");
        int count = j - 1;
        for (int c = 0; c < n; c++) {
            System.out.print(matrixA[c][count] + "\t");
            count--;
        }
    }

    // Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
    public static void task13() {
        int k = 2, p = 2;
        int n = 5;
        int j = 5;
        int[][] matrixA = new int[n][j];
        Random random = new Random();
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < j; b++) {
                matrixA[a][b] = random.nextInt(100);
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
        System.out.println("Cтрока " + k + " и ее элементы: ");
        for (int c = 0; c < n; c++) {
            System.out.print(matrixA[k][c] + "\t");
        }
        System.out.println("\nСтолбец " + p + " и его элементы: ");
        for (int c = 0; c < n; c++) {
            System.out.print(matrixA[c][p] + "\t");
        }
    }

    // Сформировать квадратную матрицу порядка n по заданному образцу
    public static void task14() {
        int n = 5;
        int j = 5;
        int[][] matrixA = new int[n][j];
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < j; b++) {
                matrixA[a][b] = n - b;
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
    }

    //  Сформировать квадратную матрицу порядка n  по заданному образцу
    public static void task15() {
        int n = 5;
        int j = 5;
        int[][] matrixA = new int[n][j];
        for (int a = 0; a < n; a++) {
            int s = a;
            for (int b = 0; b < j; b++) {
                if (b > j - a - 1) {
                    matrixA[a][b] = 0;
                    System.out.print(matrixA[a][b] + "\t");
                } else {
                    matrixA[a][b] = s + 1;
                    System.out.print(matrixA[a][b] + "\t");
                }
            }
            System.out.println();
        }
    }

    //  Сформировать квадратную матрицу порядка n  по заданному образцу
    public static void task16() {
        int n = 7;
        int j = 7;
        int[][] matrixA = new int[n][j];
        for (int a = 0; a <= n / 2; a++) {
            for (int b = a; b < j; b++) {
                if (b == a && a != 0) {
                    j -= 1;
                }
                matrixA[a][b] = 1;
            }
        }
        j = 0;
        for (int a = n - 1; a > n / 2; a--) {
            for (int b = a; b >= j; b--) {
                if (b == a && a != n - 1) {
                    j += 1;
                }
                matrixA[a][b] = 1;
            }
        }
        n = matrixA.length;
        j = matrixA.length;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < j; b++) {
                if (matrixA[a][b] != 1) {
                    matrixA[a][b] = 0;
                }
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
    }

    // Сформировать квадратную матрицу и подсчитать кол-во положительных элементов в ней.
    public static void task17() {
        double I = 6, J = 6;
        double N = 4;
        double[][] A = new double[(int) I][(int) J];
        int positiveElement = 0;
        for (int a = 0; a < I; a++) {
            for (int b = 0; b < J; b++) {
                double s = Math.sin(Math.toRadians((a * a - b * b) / N));
                A[a][b] = s;
                if (s > 0) {
                    positiveElement++;
                }
                System.out.printf("%.3f\t", A[a][b]);
            }
            System.out.println();
        }
        System.out.println("Количество положительных элементов " + positiveElement);
    }

    // В числовой матрице поменять местами два любых столбца, т.е. все элементы одного столбца поставить
    // на соответствующие им позиции другого, а его элементы второго переместить в первый.
    // Номера столбцов вводит пользователь с клавиатуры
    public static void task18() {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int j = 7, h = 7;
        int[][] matrixA = new int[j][h];
        for (int a = 0; a < j; a++) {
            for (int b = 0; b < h; b++) {
                matrixA[a][b] = random.nextInt(100);
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
        int[][] matrixExchange = new int[h][1];
        boolean flaq = false;
        int q = 0, s = 0;
        System.out.println("Введите номера столбцов которые желаете поменять местами от 0 до " + (h - 1));
        while (!flaq) {
            try {
                q = scan.nextInt();
                s = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Нужно вводить цифры  - ошибка " + e);
                break;
            }
            if ((q | s) >= h || (q | s) < 0) {
                System.out.println("Введите существующие столбцы!!!");
            } else if (q == s) {
                System.out.println("Введите не одинаковые столбцы!");
            } else flaq = true;
        }
        if (flaq) {
            for (int c = 0; c < h; c++) {
                matrixExchange[c][0] = matrixA[c][q];
                matrixA[c][q] = matrixA[c][s];
                matrixA[c][s] = matrixExchange[c][0];
            }
            for (int a = 0; a < j; a++) {
                for (int b = 0; b < h; b++) {
                    System.out.print(matrixA[a][b] + "\t");
                }
                System.out.println();
            }
        }
    }

    // Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце.
    // Определить, какой столбец содержит максимальную сумму
    public static void task19() {
        Random random = new Random();
        int j = 7, h = 7;
        int[][] matrixA = new int[j][h];
        int[] num = new int[j];
        int count;
        for (int a = 0; a < j; a++) {
            for (int b = 0; b < h; b++) {
                matrixA[a][b] = random.nextInt(20);
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
        System.out.println("Сумма каждого столбца: ");
        for (int a = 0; a < j; a++) {
            count = 0;
            for (int b = 0; b < h; b++) {
                count += matrixA[b][a];
            }
            num[a] = count;
            System.out.print(num[a] + "\t");
        }

        int max = 0;
        int maxColumn = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
                maxColumn = i;
            }
        }
        System.out.println("\nСтолбец " + maxColumn + " содержит максимальную сумму = " + max);
    }

    //Найти положительные элементы главной диагонали квадратной матрицы.
    public static void task20() {
        Random random = new Random();
        int j = 5, h = 5;
        int[][] matrixA = new int[j][h];
        for (int a = 0; a < j; a++) {
            for (int b = 0; b < h; b++) {
                matrixA[a][b] = (random.nextInt(40) - 20);
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
        System.out.println("\nПоложительные элементы главной диагонали: ");
        for (int c = 0; c < matrixA.length; c++) {
            if (matrixA[c][c] > 0) {
                System.out.print(matrixA[c][c] + " ");
            }
        }
    }

    //    Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк,
//    в которых число 5 встерчается три и более раз.
    public static void task21() {
        Random random = new Random();
        int j = 10, h = 20;
        int[][] matrixA = new int[j][h];
        for (int a = 0; a < j; a++) {
            for (int b = 0; b < h; b++) {
                matrixA[a][b] = random.nextInt(15);
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
        int count = 0;
        for (int a = 0; a < j; a++) {
            for (int b = 0; b < h; b++) {
                if (matrixA[a][b] == 5) {
                    count++;
                }
            }
            if (count >= 3) {
                System.out.println("В строке " + a + " число 5 повторяется " + count + " раз.");
            }
            count = 0;
        }
    }

    //Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
    public static void task22() {
        Random random = new Random();
        int j = 5, h = 5;
        int[][] matrixA = new int[j][h];
        System.out.println("Изначальная матрица: ");
        for (int a = 0; a < j; a++) {
            for (int b = 0; b < h; b++) {
                matrixA[a][b] = random.nextInt(30);
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
        int buf;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int a = 0; a < j; a++) {
                for (int b = 0; b < h - 1; b++) {
                    if (matrixA[a][b] > matrixA[a][b + 1]) {
                        isSorted = false;
                        buf = matrixA[a][b];
                        matrixA[a][b] = matrixA[a][b + 1];
                        matrixA[a][b + 1] = buf;
                    }
                }
            }
        }
        System.out.println("Сортировка по возрастанию: ");
        for (int a = 0; a < j; a++) {
            for (int b = 0; b < h; b++) {
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
        isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int a = 0; a < j; a++) {
                for (int b = 0; b < h - 1; b++) {
                    if (matrixA[a][b] < matrixA[a][b + 1]) {
                        isSorted = false;
                        buf = matrixA[a][b];
                        matrixA[a][b] = matrixA[a][b + 1];
                        matrixA[a][b + 1] = buf;
                    }
                }
            }
        }
        System.out.println("Сортировка по убыванию: ");
        for (int a = 0; a < j; a++) {
            for (int b = 0; b < h; b++) {
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
    }

    //Отсортировать столбцов матрицы по возрастанию и убыванию значений элементов.
    public static void task23() {
        Random random = new Random();
        int j = 5, h = 5;
        int[][] matrixA = new int[j][h];
        System.out.println("Изначальная матрица: ");
        for (int a = 0; a < j; a++) {
            for (int b = 0; b < h; b++) {
                matrixA[a][b] = random.nextInt(30);
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
        int buf;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int a = 0; a < j - 1; a++) {
                for (int b = 0; b < h; b++) {
                    if (matrixA[a][b] > matrixA[a + 1][b]) {
                        isSorted = false;
                        buf = matrixA[a][b];
                        matrixA[a][b] = matrixA[a + 1][b];
                        matrixA[a + 1][b] = buf;
                    }
                }
            }
        }
        System.out.println("Сортировка по возрастанию: ");
        for (int a = 0; a < j; a++) {
            for (int b = 0; b < h; b++) {
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
        isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int a = 0; a < j - 1; a++) {
                for (int b = 0; b < h; b++) {
                    if (matrixA[a][b] < matrixA[a + 1][b]) {
                        isSorted = false;
                        buf = matrixA[a][b];
                        matrixA[a][b] = matrixA[a + 1][b];
                        matrixA[a + 1][b] = buf;
                    }
                }
            }
        }
        System.out.println("Сортировка по убыванию: ");
        for (int a = 0; a < j; a++) {
            for (int b = 0; b < h; b++) {
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
    }

    //Сформировать случайную матрицу МxN, состоящую из 0 и 1 причем в каждом столбце число 1 равно номеру столбца.
    public static void task24() {
        Random random = new Random();
        int j = 8, h = 5;
        int[][] matrixA = new int[j][h];
        System.out.println("Не случайная Матрица из 0 и 1: ");
        for (int a = 0; a < j; a++) {
            for (int b = 0; b < h; b++) {
                if (b >= a) {
                    matrixA[a][b] = 1;
                } else {
                    matrixA[a][b] = 0;
                }
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
        int buf;
        for (int a = 0; a < j - 1; a++) {
            for (int b = 0; b < h; b++) {
                int ranNum = random.nextInt(j - a);
                if (ranNum == b) {
                    buf = matrixA[a][b];
                    matrixA[a][b] = matrixA[a + ranNum][b];
                    matrixA[a + ranNum][b] = buf;
                }
            }
        }
        System.out.println("Случайная Матрица из 0 и 1: ");
        for (int a = 0; a < j; a++) {
            for (int b = 0; b < h; b++) {
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
    }

    //Найдите наибольший элемент матрицы и заменить все нечетные элементы на него
    public static void task25() {
        Random random = new Random();
        int j = 5, h = 5;
        int[][] matrixA = new int[j][h];
        int[] max = new int[1];
        for (int a = 0; a < j; a++) {
            for (int b = 0; b < h; b++) {
                matrixA[a][b] = random.nextInt(100);
                if (matrixA[a][b] >= max[0]) {
                    max[0] = matrixA[a][b];
                }
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
        System.out.println("Заменяем все нечетные элементы на наибольший элемент матрицы");
        for (int a = 0; a < j; a++) {
            for (int b = 0; b < h; b++) {
                if (matrixA[a][b] % 2 != 0) {
                    matrixA[a][b] = max[0];
                }
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
    }

    // Магическим квадратом порядка n называется квадратная матрица размера N*N, составленая из чисел 1,2,3 ... , n*n
    // так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между собой.
    // Построить такой квадрат.
    public static void task26() {
        int countA = 1;
        int h = 3;
        int j = 3;
        int n = h * (h * h + 1) / 2;
        int[][] matrixA = new int[h][j];
        System.out.println("Построим обычный квадрат");
        for (int a = 0; a < h; a++) {
            for (int b = 0; b < j; b++) {
                matrixA[a][b] = countA;
                countA++;
                System.out.print(matrixA[a][b] + "\t");
            }
            System.out.println();
        }
        System.out.println("Используем метод Ромб: в ромб попадют все четные цифры и цифра 5, " +
                "разворачиваем ромб на 45 градусов против часов." + "\nНечетные цифры (не попавшие в ромб)" +
                " заменяем на 0");
        int[][] matrixB = new int[h][j];
        int countB = 2;
        for (int a = 0; a < h; a++) {
            for (int b = 0; b < j; b++) {
                if ((a & b) == 1) {
                    matrixB[b][a] = matrixA[b][a];
                    System.out.print(matrixB[b][a] + "\t");
                    continue;
                }
                if (matrixA[b][a] % 2 != 0) {
                    matrixB[b][a] = countB;
                    System.out.print(matrixB[b][a] + "\t");
                    countB += 2;
                } else {
                    matrixB[b][a] = 0;
                    System.out.print(matrixB[b][a] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println("Заменяем 0 на недостающие цифры и получаем: ");
        // Проходимся по столбцам
        for (int a = 0; a < h; a++) {
            for (int b = 0; b < j; b++) {
                if (matrixB[b][a] == 0 && b == 1) {
                    matrixB[b][a] = n - matrixB[b - 1][a] - matrixB[b + 1][a];
                }
            }
        }
        // Проходимся по строкам:
        for (int a = 0; a < h; a++) {
            for (int b = 0; b < j; b++) {
                if (matrixB[b][a] == 0) {
                    matrixB[b][a] = n - matrixB[b][a - 1] - matrixB[b][a + 1];
                }
            }
        }
        // Вывод готового магического квадрата
        for (int a = 0; a < h; a++) {
            for (int b = 0; b < j; b++) {
                System.out.print(matrixB[a][b] + "\t");
            }
            System.out.println();
        }
        //Проверка условия по строкам
        int countN = 0;
        int check = 0;
        for (int a = 0; a < h; a++) {
            for (int b = 0; b < j; b++) {
                countN += matrixB[a][b];
                if (b == 2 && countN == n) {
                    check++;
                    countN = 0;
                }
            }
        }
        countN = 0;
        //Проверка условия по столбцам
        for (int a = 0; a < h; a++) {
            for (int b = 0; b < j; b++) {
                countN += matrixB[b][a];
                if (b == 2 && countN == n) {
                    check++;
                    countN = 0;
                }
            }
        }
        //Проверка условия по диагоналям
        countN = 0;
        for (int c = 0; c < h; c++) {
            countN += matrixB[c][c];
            if (c == 2 && countN == n) {
                check++;
                countN = 0;
            }
        }
        countN = 0;
        int countH = h - 1;
        for (int c = 0; c < h; c++) {
            countN += matrixB[c][countH];
            countH--;
            if (c == 2 && countN == n) {
                check++;
                countN = 0;
            }
        }
        if (check == 8) {
            System.out.println("Магический квадрат построен правильно ");
        } else System.out.println("Магический квадрат построен НЕ правильно ");
    }

    // Заданы два одномерх массива с различным количеством элементов и натуральное число k.
    // Объеденить их в один массив, включив второй массив между k-м и (к+1) - м элементами первого
    public static void task27() {
        int k = 5;
        int[] masOne = {1, 123, 435, 354, 645, 23, 12, 2, 7};
        int[] masTwo = {2, 12, 5, 6, 9, 3, 123, 4, 77, 25};
        int[] masOneTwo = new int[masOne.length + masTwo.length];
        int count = 0;
        for (int a = 0; a < masOne.length; a++) {
            if (a == k - 1) {
                for (int i = 0; i < masTwo.length; i++) {
                    masOneTwo[a] = masTwo[i];
                    a++;
                    count++;
                }
                a = k - 1;
            }
            masOneTwo[a + count] = masOne[a];
        }
        masOne = masOneTwo;
        for (int i = 0; i < masOne.length; i++) {
            System.out.print(masOne[i] + " ");
        }
    }

    // Даны две последовательности a1<=a2<=a3...<=an и b1<=b2<=b3...<=bn. Образовать из них новую
    // последовательность чисел так, что бы она тоже была не убывающейю
    public static void task28() {
        int[] masOne = {1, 3, 5, 6, 7, 10, 11, 66, 66};
        int[] masTwo = {1, 6, 8, 9, 10, 11, 55, 66, 66, 77, 77};
        for (int a = 0; a < 1; a++) {
            int[] temp = masOne;
            masOne = new int[masOne.length + masTwo.length];
            int countTemp = 0;
            int countMasTwo = 0;
            boolean flaq = false;
            for (int i = 0; i < masOne.length; i++) {
                if (countTemp >= temp.length) {
                    masOne[i] = masTwo[countMasTwo];
                    countMasTwo++;
                    flaq = true;
                    if (i == masOne.length - 1) {
                        break;
                    }
                }
                if (countMasTwo >= masTwo.length) {
                    masOne[i] = temp[countTemp];
                    countTemp++;
                    flaq = true;
                    if (i == masOne.length - 1) {
                        break;
                    }
                }
                if (!flaq) {
                    if (temp[countTemp] < masTwo[countMasTwo]) {
                        masOne[i] = temp[countTemp];
                        countTemp++;
                    } else if (temp[countTemp] > masTwo[countMasTwo]) {
                        masOne[i] = masTwo[countMasTwo];
                        countMasTwo++;
                    } else {
                        if (temp[countTemp] == masTwo[countMasTwo]) {
                            masOne[i] = temp[countTemp];
                            i++;
                            masOne[i] = masTwo[countMasTwo];
                            countTemp++;
                            countMasTwo++;
                        }
                    }
                }
            }
        }
        // Вывод массива на экран
        for (int a = 0; a < masOne.length; a++) {
            System.out.print(masOne[a] + " ");
        }
    }

    // Сортировка выбором. Дана последовательность чисел a1<=a2<=a3...<=an. Необходимо переставить элементы так,
    // что бы они были расположены по убыванию  a1>=a2>=a3...>=an.
    public static void task29() {
        int[] mas = {1, 5, 7, 10, 11, 66, 66};
        for (int a = 0; a < mas.length; a++) {
            int pos = a;
            int max = mas[a];
            // цикл выбора наибольшего элемента
            for (int j = a + 1; j < mas.length; j++) {
                if (mas[j] > max) {
                    pos = j;    // pos - индекс наибольшего элемента
                    max = mas[j];
                }
            }
            mas[pos] = mas[a];
            mas[a] = max;    // меняем местами наибольшим с mas[i]
        }
        for (int a = 0; a < mas.length; a++) {
            System.out.print(mas[a] + " ");
        }
    }

    //Сортировка обменами. Необходимо переставить числа в порядке возрастания + подсчитать количество перестановок.
    public static void task30() {
        int[] array = {1, 32, 7, 230, 11, 66, 66, 5, 1, 5, 5};
        int amount = 0;
        for (int i = 0; i < array.length - 1; i++) {
            // внутренний цикл прохода
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                    amount++;
                }
            }
        }
        System.out.println("Количество перестановок - " + amount);
        for (int a = 0; a < array.length; a++) {
            System.out.print(array[a] + " ");
        }
    }

    // Сортировка вставками. Дана последовательность чисел а1,а2,...,ат.
    // Переставить числа в порядке возрастания
    public static void task31() {
        int[] array = {1, 32, 7, 230, 11, 66, 66, 5, 1, 5, 5};
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
        for (int a = 0; a < array.length; a++) {
            System.out.print(array[a] + " ");
        }
    }

    // Сортировка Шелла. Упорядочить по возрастанию
    public static void task32() {
        int[] a = {1, 32, 7, 230, 11, 66, 66, 5, 1, 5, 5};
        int temp;
        int h = 0;//величина интервала

        //вычисляем исходное значение интервала
        while (h <= a.length / 3) {
            h = 3 * h + 1;
        }
        for (int k = h; k > 0; k = (k - 1) / 3) {
            for (int i = k; i < a.length; i++) {
                temp = a[i];
                int j;
                for (j = i; j >= k; j -= k) {
                    if (temp < a[j - k])
                        a[j] = a[j - k];
                    else
                        break;
                }
                a[j] = temp;
            }
        }
        for (int b = 0; b < a.length; b++) {
            System.out.print(a[b] + " ");
        }
    }

    // Даны две последовательности a1<=a2<=a3...<=an и b1<=b2<=b3...<=bn. Требуеться указать те места,
    // на которые нужно вставлять элементы последовательности, что бы последовательность оставалась возрастающей.
    public static void task33() {
        int[] masOne = {1, 3, 5, 6, 7, 10, 12, 66, 68};
        int[] masTwo = {1, 6, 8, 9, 10, 11, 55, 66, 66, 77, 77};
        int countMasOne = 0;
        int countMasTwo = 0;
        for (int a = 0; a < masOne.length; a++) {
            if (masOne[countMasOne] < masTwo[countMasTwo]) {
                countMasOne++;
            } else if (masOne[countMasOne] > masTwo[countMasTwo]) {
                System.out.println("Элемент " + masTwo[countMasTwo] + " перед элементом " + masOne[countMasOne]);
                countMasTwo++;
            } else if (masOne[countMasOne] == masTwo[countMasTwo]) {
                System.out.println("Элемент " + masTwo[countMasTwo] + " следует после элемента " + masOne[countMasOne]);
                countMasOne++;
                countMasTwo++;
            }
        }
    }

    // Даны дроби. Составить программуб которая приводит эти дроби к общему знаменателю и упорядочивает их
    // в порядке возрастания.
    public static void task34() {
        int mas = 5;
        Random random = new Random();
        int[] p = new int[5];
        int[] q = new int[5];
        //  присваиваем дробям рандомные числа
        for (int i = 0; i < mas; i++) {
            p[i] = random.nextInt(6) + 1;
            q[i] = random.nextInt(7) + 1;
        }
        num(p);
        System.out.print(" - Числитель\n");
        num(q);
        System.out.print(" - Знаменатель ");
        // находим наибольший элемент в знаменателе
        int numberMaxQ = q[0];
        for (int a = 0; a < q.length; a++) {
            if (q[a] > numberMaxQ) {
                numberMaxQ = q[a];
            }
        }
        // создаем доп.массив в который помещаем число множителя
        int[] numberFactor = new int[5];
        int numberFactorQ = 1;
        int MaxNumberFactorQ = 0;
        for (int i = 0; i < q.length; i++) {
            if (numberMaxQ % q[i] == 0) {
                numberFactorQ = 1;
            } else if (numberMaxQ % 2 == 0 && numberMaxQ % 3 == 0 && q[i] % 2 == 0 && q[i] % 3 == 0) {
                numberFactorQ = 1;
            } else if (numberMaxQ % 2 == 0 && q[i] % 2 == 0 && numberMaxQ % 3 != 0 && q[i] % 3 == 0) {
                numberFactorQ = 3;
            } else if (numberMaxQ % 2 == 0 && q[i] % 2 == 0 && numberMaxQ % 3 == 0 && q[i] % 3 != 0) {
                numberFactorQ = 2;
            } else if (numberMaxQ % 2 == 0 && q[i] % 2 != 0 && numberMaxQ % 3 == 0 && q[i] % 3 == 0) {
                numberFactorQ = 5;
            } else if (numberMaxQ % 2 != 0 && q[i] % 2 == 0 && numberMaxQ % 3 == 0 && q[i] % 3 == 0) {
                numberFactorQ = 4;
            } else if ((numberMaxQ % 2 == 0 || numberMaxQ % 3 == 0) && q[i] % 2 != 0 && q[i] % 3 != 0) {
                numberFactorQ = q[i];
            } else if (numberMaxQ % 2 != 0 && numberMaxQ % 3 != 0 && q[i] % 2 != 0 && q[i] % 3 != 0) {
                numberFactorQ = q[i];
            } else if (numberMaxQ % 2 != 0 && numberMaxQ % 3 != 0 && q[i] % 2 == 0 && q[i] % 3 != 0) {
                numberFactorQ = q[i];
            } else if (numberMaxQ % 2 != 0 && numberMaxQ % 3 != 0 && q[i] % 2 != 0 && q[i] % 3 == 0) {
                numberFactorQ = q[i];
            } else if (numberMaxQ % 2 != 0 && numberMaxQ % 3 != 0 && q[i] % 2 == 0 && q[i] % 3 == 0) {
                numberFactorQ = q[i];
            }
            numberFactor[i] = numberFactorQ;
            //  ищем минимальное число на которое надо изначально умножить
            if (MaxNumberFactorQ < numberFactorQ) {
                MaxNumberFactorQ = numberFactorQ;
            }
        }
        System.out.println("\n" + MaxNumberFactorQ + " - минимальное число на которое надо изначально умножить");
        boolean flaq = false;
        int coefficient = 1;
        int numeric = 0;
        //Поиск общего знаменателя
        while (!flaq) {
            for (int a = 0; a < q.length; a++) {
                if (numberMaxQ * MaxNumberFactorQ * coefficient % q[a] == 0) {
                    numeric = numberMaxQ * MaxNumberFactorQ * coefficient;
                    flaq = true;
                } else {
                    flaq = false;
                    coefficient++;
                    break;
                }
            }
        }
        System.out.println(numeric + " - Общий знаменатель");
        for (int i = 0; i < q.length; i++) {
            p[i] = p[i] * (numeric / q[i]);
            q[i] = numeric;
        }
        for (int i = 0; i < p.length - 1; i++) {
            for (int j = p.length - 1; j > i; j--) {
                if (p[j - 1] > p[j]) {
                    int tmp = p[j - 1];
                    p[j - 1] = p[j];
                    p[j] = tmp;
                }
            }
        }
        System.out.println("Дроби после сортировки и в порядке возрастания: ");
        num(p);
        System.out.print(" - Числитель\n");
        num(q);
        System.out.print(" - Знаменатель ");
    }

    public static void num(int[] ints) {
        for (int a = 0; a < ints.length; a++) {
            System.out.print(ints[a] + "\t");
        }
    }

    //Написать методы для нахождения наибольшего общего делителя и наименьшего кратного двух натуральных чисел.
    public static void task35() {
        Random random = new Random();
        int A = random.nextInt(100) + 1;
        int B = random.nextInt(100) + 1;
        System.out.println("A - " + A + "\nB - " + B);
        int minNum;
        if (A > B) {
            minNum = B;
        } else {
            minNum = A;
        }
        int divider = 1;
        for (int i = 1; i <= minNum; i++) {
            if (A % i == 0 && B % i == 0) {
                divider = i;
            }
        }
        System.out.println("НОД чисел A и B - " + divider);
        System.out.println("НОK чисел A и B - " + A * B / divider);
    }

    // Написать метод для нахождения НОДа 4 натуральных чисел
    public static void task36() {
        Random random = new Random();
        int[] fourNum = new int[4];
        int maxNum = fourNum[0];
        System.out.println("Четыре числа: ");
        for (int i = 0; i < fourNum.length; i++) {
            fourNum[i] = random.nextInt(100) + 1;
            System.out.print(fourNum[i] + " ");
            if (maxNum <= fourNum[i]) {
                maxNum = fourNum[i];
            }
        }
        int divider = 1;
        int count;
        for (int i = 1; i <= maxNum; i++) {
            count = 0;
            for (int z = 0; z < fourNum.length; z++) {
                if (fourNum[z] % i == 0) {
                    count++;
                    if (count == fourNum.length) {
                        divider = i;
                    }
                } else break;
            }
        }
        System.out.println("\nНОД четырех чисел - " + divider);
    }

    public static void task37() {
        int sideOfHexagon = 7;
        // т.к. правильный шестиугольник можно разделить на 4 треугольника
        // (два с синусом 120 градусов и два с синусом 90 градусов
        // находим площадь 2-x 120 градусных треугольников
        double S = 2 * (0.5 * sideOfHexagon * sideOfHexagon * Math.sin(Math.toRadians(120)));
        //Определяем гипотенузу 120 градусного треугольника, она же является катетом 90 градусного треугольника
        double hypotenuse120OfTriangle = Math.sqrt(Math.pow(sideOfHexagon, 2) + Math.pow(sideOfHexagon, 2) -
                (2 * sideOfHexagon * sideOfHexagon * Math.cos(Math.toRadians(120))));
        // Находим площадь оствашихся двух 90 градусных треугольника
        double S2 = 2 * (0.5 * sideOfHexagon * hypotenuse120OfTriangle * Math.sin(Math.toRadians(90)));
        System.out.println((S + S2) + "  - Площадь правильного шестиугольника с длиной стороны " + sideOfHexagon);
    }

    // На плоскости заданы своими координатами n точек. Написать метод, определяющий, между какими
    // из пар точек самое большое расстояние. Координаты точек занести в массив;
    public static void task38() {
        Random random = new Random();
        int x = 5;
        int y = 2;
        int[][] points = new int[x][y];
        //  Заносим произвольные координаты в массив
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                points[i][j] = random.nextInt(10) + 1;
            }
        }
        int[][] masAB = new int[2][2];
        double maxLength = 0;
        double AB;
        for (int i = 0; i < x; i++) {
            for (int a = 0; a < x; a++) {
                AB = Math.sqrt(Math.pow(points[a][0] - points[i][0], 2) + Math.pow(points[a][1] - points[i][1], 2));
                if (AB > maxLength) {
                    maxLength = AB;
                    masAB[0][0] = points[a][0];
                    masAB[1][0] = points[i][0];
                    masAB[0][1] = points[a][1];
                    masAB[1][1] = points[i][1];
                }
                System.out.println(AB);
            }
        }
        System.out.println("Координаты точек между которыми самое большое расстояние " + maxLength);
        for (int i = 0; i < masAB.length; i++) {
            System.out.print("x = " + masAB[i][0] + "  y = " + masAB[i][1] + "\n");
        }
    }

    // Составить программу, которая в массиве A[N] находит второе по величине число (Вывести его на печать)
    public static void task39() {
        int[] A = {1, 5435, 657, 8, 67, 9, 890, 890, 90, 3123, 325, 3456, 456, 456, 456, 23, 45, 6};
        int MaxFirstNumber = A[0];
        int MaxFirstNumberPos = 0;
        int MaxSecondNumber = A[0];
        for (int i = 0; i < A.length; i++) {
            if (MaxFirstNumber < A[i]) {
                MaxFirstNumber = A[i];
                MaxFirstNumberPos = i;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (i != MaxFirstNumberPos) {
                if (MaxSecondNumber < A[i]) {
                    MaxSecondNumber = A[i];
                }
            }
        }
        System.out.println("Второе по величине число = " + MaxSecondNumber);
    }

    //Написать методы, проверяющие, являються ли данные три числа взаимно простыми
    public static void task40() {
        Random random = new Random();
        int[] array = {random.nextInt(150) + 1, random.nextInt(100) + 1, random.nextInt(200) + 1};
        int count = 0;
        for (int b = 0; b < array.length; b++) {
            if (array[b] >= 2) {
                if (array[b] == 3) {
                    count++;
                } else if (array[b] == 2) {
                    count++;
                } else if (array[b] % 2 != 0 && array[b] % 3 != 0) {
                    count++;
                }
            }
        }
        if (count == 3) {
            System.out.println("Числа: " + array[0] + " " + array[1] + " " + array[2] + " взаимно простые");
        } else System.out.println("Числа: " + array[0] + " " + array[1] + " " + array[2] + " НЕ! взаимно простые");
    }

    // Сумма факториалов всех нечетных чисел от 1 до 9.
    public static void task41() {
        int[] factorialNum = {1, 3, 5, 7, 9};
        int factorial = 1;
        for (int a = 0; a < factorialNum.length; a++) {
            for (int i = 1; i <= factorialNum[a]; i++) {
                factorial = factorial * i;
            }
            System.out.println(factorial);
            factorial = 1;
        }
    }

    //Задан массив D. Определит суммы: D[1]+D[2]+D[3]; D[3]+D[4]+D[5]; D[5]+D[6]+D[7].
    //Составить метод для вычисления суммы трех последовательно расположеных элементов массива с номерами от k до m.
    public static void task42() {
        int[] D = {1, 54343, 623, 31, 3, 5, 4, 57, 567, 8, 7, 9789, 789, 789, 7829, 56, 7, 8, 3, 13, 4, 124};
        int k = 3;
        int m = 13;
        int sum = 0;
        for (int i = k; i <= m; i += 2) {
            sum = D[i] + D[i + 1] + D[i + 2];
            if (i + 1 > m || i + 2 > m) {
                break;
            } else
                System.out.println("Сумма трех элементов с " + i + " по " + (i + 2) + " = " + sum);
        }

    }

    //    Даны числа X,Y,Z,T - длины сторон четырехугольника. Написать метод вычисления его площади
    public static void task43() {
        int[][] X = {{0, 0}};
        int[][] Y = {{0, 8}};
        int[][] Z = {{10, 0}};
        int[][] T = {{6, 4}};
//        Находим расстояния между точками
        double distanceXY = Math.sqrt(Math.pow(Y[0][0] - X[0][0], 2) + Math.pow(Y[0][1] - X[0][1], 2));
        double distanceXZ = Math.sqrt(Math.pow(Z[0][0] - X[0][0], 2) + Math.pow(X[0][1] - Z[0][1], 2));
        double distanceYT = Math.sqrt(Math.pow(Y[0][0] - T[0][0], 2) + Math.pow(Y[0][1] - T[0][1], 2));
        double distanceZT = Math.sqrt(Math.pow(Z[0][0] - T[0][0], 2) + Math.pow(T[0][1] - Z[0][1], 2));
//        Разделяем четырехугольник на 2 треугольника (XYZ,YZT)
//        Находим гипотенузу треугольника XYZ, она же гипотенуза треугольника YZT
        double distanceYZ = Math.sqrt(Math.pow(distanceXY, 2) + Math.pow(distanceXZ, 2));
//       По формуле Герона находим площади 2 треугольников
//       Но сначала находим периметр треугольника XYZ и YZT
        double pXYZ = (distanceXY + distanceXZ + distanceYZ) / 2;
        double pYZT = (distanceYT + distanceYZ + distanceZT) / 2;
        double S = (Math.sqrt(pXYZ * (pXYZ - distanceXY) * (pXYZ - distanceXZ) * (pXYZ - distanceYZ))) +
                (Math.sqrt(pYZT * (pYZT - distanceYT) * (pYZT - distanceYZ) * (pYZT - distanceZT)));
        System.out.println("Площадь четырехугольника - " + S);
    }

    //Дано натуральное число N. Написать метод для формирования массиваб элементами которого являються цифры числа N.
    public static void task44() {
        Random random = new Random();
        int N = random.nextInt(100000);
        System.out.println(N);
        String n = String.valueOf(N);
        String[] strings = new String[n.length()];
        int[] array = new int[n.length()];
        for (int i = 0; i < array.length; i++) {
            strings[i] = String.valueOf(n.charAt(i));
            array[i] = Integer.parseInt(strings[i]);
            System.out.print(array[i] + " ");
        }
    }

    //Написать метод, определяющий, в каком из данных двух чисел больше цифр
    public static void task45() {
        Random random = new Random();
        int N = random.nextInt(100000);
        int K = random.nextInt(100000);
        String n = String.valueOf(N);
        String k = String.valueOf(K);
        if (n.length() > k.length()) {
            System.out.println("В числе " + N + " больше цифр, чем в числе " + K);
        } else if (n.length() < k.length()) {
            System.out.println("В числе " + K + " больше цифр, чем в числе " + N);
        } else System.out.println("В числе " + K + " одинаковое количество цифр, как в числе " + N);
    }

    //Даны натуральные числа K и N. Написать метод формирования массива, элементами которого
    // являются числа, сумма цифр которых равна K и котроые не больше N.
    public static void task46() {
        Random random = new Random();
        int N = random.nextInt(9) + 1;
        int K = random.nextInt(1000);
        System.out.println("Число N - " + N + "\nЧисло K - " + K);
        int[] A = new int[N + 1];
        String[] Anew = new String[0];
        int count = 0;
        for (int b = 0; b <= N; b++) {
            A[b] = b;
        }
        boolean flaq = true;
        String[] q;
        int c;
        for (int i = 0; i <= K; i++) {
            if (!flaq) {
                break;
            }
            for (int s = 0; s <= N; s++) {
                if (i >= 10) {
                    q = new String[5];
                    String[] m = String.valueOf(i).split("");
                    for (int a = 0; a < m.length; a++) {
                        q[a] = m[a];
                    }
                    q[m.length] = String.valueOf(s);

                } else {
                    q = new String[]{String.valueOf(i), String.valueOf(s)};
                }
                c = 0;
                for (int p = 0; p < q.length; p++) {
                    if (q[p] != null) {
                        c += Integer.parseInt(q[p]);
                    }
                }
                if (c == N) {
                    String e;
                    if (i == 0) {
                        e = String.valueOf(s);
                    } else {
                        e = String.valueOf(i) + String.valueOf(s);
                    }
                    if (Integer.parseInt(e) > K) {
                        flaq = false;
                        break;
                    }
                    count++;
                    String[] temp = Anew;
                    Anew = new String[count];
                    Anew[count - 1] = e;
                    for (int d = 0; d < temp.length; d++) {
                        Anew[d] = temp[d];
                    }
                }
            }
        }
        int[] array = new int[Anew.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(Anew[i]);
            System.out.print(array[i] + " ");
        }
    }

    //Два простых числа называются "близнецами", если они отличаются друг от друга на 2(например 41 и 43).
    // Найти и напечатать все пары близнецов из отрезка [2, 2n], где n - натуральное число больше 2.
    public static void task47() {
        Random random = new Random();
        int n = random.nextInt(1000) + 2;
        int m = 2 * n;
        int count = 0;
        System.out.println("Числа близнецы от: " + n + " до " + m);
        for (int i = n; i < m; i++) {
            for (int a = i + 2; a == i + 2; a++) {
                if (a > m) {
                    break;
                }
                for (int b = i - 1; b > 1; b--) {
                    if (i % b != 0 && i % b != 0 && a % b != 0 && a % b != 0) {
                        count++;
                        if (count + 2 == i) {
                            System.out.println(i + " " + (i + 2));
                        }
                    }
                }
            }
            count = 0;
        }
    }

    //Число АРМСТРОНГА
    public static void task48() {
        int k = 1000000;
        int degree = 0;
        String[] strings;
        int sum = 0;
        System.out.println("Числа армстронга: ");
        for (int i = 1; i <= k; i++) {
            strings = new String[]{String.valueOf(i)};
            String[] m = String.valueOf(i).split("");
            for (String s : m) {
                degree++;
            }
            for (String s : m) {
                sum += Math.pow(Integer.parseInt(s), degree);
            }
            if (Integer.parseInt(strings[0]) == sum) {
                System.out.print(i + " ");
            }
            sum = 0;
            degree = 0;
        }
    }

    // Найти все натуральные n - значные числа, цифры в которых образуют
    // строго возрастающую последовательность(например 123, 56789).
    public static void task49() {
        Random random = new Random();
        int n = random.nextInt(10000);
        String[] strings;
        for (int i = 1; i < n; i++) {
            strings = new String[]{String.valueOf(i)};
            String[] m = String.valueOf(i).split("");
            int count = 0;
            for (int a = 0; a < m.length - 1; a++) {
                if ((Integer.parseInt(m[a]) + 1) == Integer.parseInt(m[a + 1])) {
                    count++;
                    if (count == m.length - 1) {
                        System.out.print(strings[0] + "  ");
                    }
                }
            }
        }
    }

    //Написать программу, определяющую сумму n - значных чисел. Определить сумму четных и нечетных цифр
    public static void task50() {
        int n = 4;
        int sumEven = 0;
        int sumUnEven = 0;
        for (int a = 0; a < Integer.MAX_VALUE; a++) {
            String str = String.valueOf(a);
            String[] count = str.split("");
            if (count.length < n) {
                a += 9;
            }
            if (count.length == n) {
                if (a % 2 == 0) {
                    sumEven += a;
                } else
                    sumUnEven += a;
            }
            if (count.length > n) {
                break;
            }
        }
        System.out.println("Сумма четных " + n + " - значных чисел = " + sumEven + "\n" +
                "Сумма нечетных " + n + " - значных чисел = " + sumUnEven);
    }

    // Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д.
    // Сколько таких действий надо произвести, чтобы получился нуль?
    public static void task51() {
        int n = 3200000;
        int sum = 0;
        int numberOfActions = 0;
        System.out.println("Из числа " + n + " каждый раз вычитаем сумму его цифр, что бы получить нуль");
        while (n > 0) {
            String N = String.valueOf(n);
            String[] num = N.split("");

            for (String cif : num) {
                sum += Integer.parseInt(cif);
            }
            n -= sum;
            sum = 0;
            numberOfActions++;
        }
        System.out.println(numberOfActions + " - действий необходимо произвести ");
    }
}