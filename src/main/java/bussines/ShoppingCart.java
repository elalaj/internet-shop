package bussines;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import entity.CreditCard;
import entity.Product;

public class ShoppingCart {

    private final List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public Map<Product, Long> addProduct(final Product product) {
        products.add(product);
        return getProducts();
    }

    public Map<Product, Long> removeProduct(final Product product) {
        products.remove(product);
        return getProducts();
    }

    public Map<Product, Long> deleteProduct(final Product product) {
        products.removeIf(p -> p.equals(product));
        return getProducts();
    }

    /**
     * Function will create and return a map of grouped records by product.
     * Map will contain product as key and counter of value.
     *
     * @return grouped list.
     */
    private Map<Product, Long> getProducts() {
        return products.stream().collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                )
        );
    }

    public double calculateTotal() {
        return calculateTotal(CreditCard.NORMAL);
    }

    public double calculateTotal(final CreditCard creditCard) {
        double total = 0;
        for (final Product product : products) {
            total += product.getPrice() * (1 - creditCard.getDiscount());
        }
        return total;
    }

}
