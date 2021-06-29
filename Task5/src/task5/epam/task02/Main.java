package task5.epam.task02;

public class Main {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.add(new Payment.Product("Груша", 3,3));
        payment.add(new Payment.Product("Яблоко",5));
        payment.add(new Payment.Product("Слива",5,10));
        System.out.println(payment.toString());
    }
}
