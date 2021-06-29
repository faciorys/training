package epam.task.task01;

//Создайте класс Test1 с двумя пременными. Добавьте методы вывода на экран и методы изменения этих переменных.
//Добавьте метод, который находит сумму значений этих переменных, и метод, который находит значение из этих
//двух переменных
public class Test1 {
    static int a = 1;
    static int b = 2;

    public static void main(String[] args) {
        Test1 one = new Test1();
        System.out.println(one.sum(a, b));
        System.out.println(one.greatest_Value(a, b));
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int greatest_Value(int a, int b) {
        return Math.max(a, b);
    }
}

