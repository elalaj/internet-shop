package bussines;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @BeforeEach
    public void setup() {
        shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(Product.builder().description("prod1").price(2.5).build());
        shoppingCart.addProduct(Product.builder().description("prod1").price(2.5).build());
        shoppingCart.addProduct(Product.builder().description("prod2").price(2.5).build());
        shoppingCart.addProduct(Product.builder().description("prod2").price(2.3).build());
    }

    @Test
    public void testGrupingSameProducts() {
        final Map<Product, Long> products = shoppingCart.getProducts();
        assertEquals(3, products.size());
    }

    @Test
    public void testRemoveProductOnlyOnce() {
        shoppingCart.removeProduct(Product.builder().description("prod1").price(2.5).build());
        final Map<Product, Long> products = shoppingCart.getProducts();
        assertEquals(3, products.size());
    }

    @Test
    public void testRemoveProductTwice() {
        shoppingCart.removeProduct(Product.builder().description("prod1").price(2.5).build());
        shoppingCart.removeProduct(Product.builder().description("prod1").price(2.5).build());
        final Map<Product, Long> products = shoppingCart.getProducts();
        assertEquals(2, products.size());
    }

    @Test
    public void testCountIncrementOnEquals() {
        final Map<Product, Long> products = shoppingCart.getProducts();
        final Product prod1 = Product.builder().description("prod1").price(2.5).build();
        assertEquals(2, products.get(prod1));
    }

    @Test
    public void testCountNoIncrementOnNotEquals() {
        final Map<Product, Long> products = shoppingCart.getProducts();
        final Product prod2 = Product.builder().description("prod2").price(2.3).build();
        assertEquals(1, products.get(prod2));
    }

}
