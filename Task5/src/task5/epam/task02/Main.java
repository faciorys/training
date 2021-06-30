package task5.epam.task02;

/*
* Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
* нескольких товаров.
* */
public class Main {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.add(new Payment.Product("Груша", 3,3));
        payment.add(new Payment.Product("Яблоко",5));
        payment.add(new Payment.Product("Слива",5,10));
        System.out.println(payment.toString());
    }
}
