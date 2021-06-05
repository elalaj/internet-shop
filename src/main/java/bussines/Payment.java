package bussines;

import java.util.Map;

import entity.CreditCard;
import entity.Product;

public final class Payment {

    private Payment() {
    }

    public static double calculateTotal(final Map<Product, Integer> products, final CreditCard creditCard) {
        double total = 0;
        for (final Map.Entry<Product, Integer> entry : products.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue() * (1 - creditCard.getDiscount());
        }
        return total;
    }
}
