package task06.epam.task4;

/*
* Задание 4. Многопоточность. Порт . Корабли заходят в порт для
разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент
в порту и на корабле, должно быть неотрицательным и превышающим заданную
грузоподъемность судна и вместимость порта. В порту работает несколько причалов.
У одного причала может стоять один корабль. Корабль может загружаться у причала
или разгружаться.
* */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Ships one = new Ships("Rose", 20,
                TypeLoad.LOADING, 30);
        Ships two = new Ships("Anka", 22, TypeLoad.LOADING, 42);
        Ships three = new Ships("Sea", 22, TypeLoad.LOADING, 32);
        Ships four = new Ships("Treachery", 0, TypeLoad.LOADING, 12);
        Ships five = new Ships("Alone", 14, TypeLoad.LOADING, 124);
        one.start();
        Thread.sleep(123);
        two.start();
        Thread.sleep(1130);
        three.start();
        Thread.sleep(1323);
        four.start();
        Thread.sleep(5000);
        five.start();
    }
}
