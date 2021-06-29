package epam.task.task02;

//Создайте класс Test2 c двумя переменными. Добавьте конструктор с входными параметрами.
//Добавьите конструктор, инициализирующий члены класса по умолчанию. Добавить сетер и гетер
//для полей экземпляра класса.
public class Test2 {
    int a = 1;
    int b = 2;

    public Test2(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Test2() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public static void main(String[] args) {
        Test2 d = new Test2();
        System.out.println(d.getB());
        d.setB(55);
        System.out.println(d.getB());
        Test2 s = new Test2(1, 3);
        System.out.println(s.getB());
    }
}