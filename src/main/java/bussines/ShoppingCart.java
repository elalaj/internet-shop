package bussines;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import entity.Product;

public class ShoppingCart {

    private final List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(final Product product) {
        products.add(product);
    }

    public boolean removeProduct(final Product product) {
        return products.remove(product);
    }

    public Map<Product, Long> getProducts() {
        return products.stream().collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                )
        );
    }

}
