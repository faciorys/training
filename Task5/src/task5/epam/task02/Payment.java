package task5.epam.task02;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    List<Product> products;

    public Payment() {
        this(null);

    }

    public Payment(List<Product> products) {
        if (products != null) {
            this.products = products;
        } else {
            this.products = new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        if (products.size() < 1) return "Список товаров пуст.";
        //Общая стоимость
        int totalCost = 0;
        StringBuilder result = new StringBuilder("Список товаров:\n");
        for (Product pr: products) {
            totalCost += pr.cost();
            result.append(pr).append('\n');
        }
        result.append("Общая стоимость: ").append(totalCost);
        return result.toString();
    }

    public boolean add(Product product) {
        return products.add(product);
    }

    public int totalCost() {
        int result = 0;
        for (Product pr : products) {
            result += pr.cost();
        }
        return result;
    }

    public static class Product {
        public final String name;
        public final int price;
        private int quantity;

        public Product(String name, int price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public Product(String name, int price) {
            this(name, price, 1);
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            if (quantity > 0) {
                this.quantity = quantity;
            } else this.quantity = 0;
        }

        public int cost() {
            return price * quantity;
        }
        public String toString() {
            StringBuilder result = new StringBuilder(name);
            result.append(" (").append(price).append(" x ");
            result.append(quantity).append(" шт = ");
            result.append(cost()).append(')');
            return result.toString();
        }
    }
}
