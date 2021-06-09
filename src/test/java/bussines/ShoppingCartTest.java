package bussines;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entity.CreditCard;
import entity.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    @Test
    public void addOneProductToEmptyShoppingCart_increaseSizeToOne() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        Map<Product, Long> shoppingCardProducts = shoppingCart.addProduct(prod1);
        assertEquals(1, shoppingCardProducts.size());
    }

    @Test
    public void addTwoProductsToEmptyShoppingCart_increaseSizeToTwo() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        final Product prod2 = new Product("prod2", 9);
        shoppingCart.addProduct(prod1);
        final Map<Product, Long> shoppingCardProducts = shoppingCart.addProduct(prod2);
        assertEquals(2, shoppingCardProducts.size());
    }

    @Test
    public void addTwiceSameProduct_shouldIncreaseSizeByOne() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        shoppingCart.addProduct(prod1);
        final Map<Product, Long>  shoppingCardProducts = shoppingCart.addProduct(prod1);
        assertEquals(1, shoppingCardProducts.size());
    }

    @Test
    public void addNProductsToEmptyShoppingCart_increaseSizeToN() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        final Product prod2 = new Product("prod2", 9);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod2);
        final Map<Product, Long> shoppingCardProducts = shoppingCart.addProduct(prod2);
        assertEquals(2, shoppingCardProducts.size());
    }

    @Test
    public void addProductTwiceToNonEmptyShoppingCart_increaseSizeByOne() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        final Product prod2 = new Product("prod2", 9);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod2);
        final Map<Product, Long> shoppingCardProducts = shoppingCart.addProduct(prod2);
        assertEquals(2, shoppingCardProducts.size());
    }

    @Test
    public void removeOneProductFromShoppingCart_decreasesSizeZero() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        shoppingCart.addProduct(prod1);
        final Map<Product, Long> shoppingCardProducts = shoppingCart.removeProduct(prod1);
        assertEquals(0, shoppingCardProducts.size());
    }

    @Test
    public void removeTwoProductsFromShoppingCart_decreasesSizeZero() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        final Product prod2 = new Product("prod2", 9);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod2);
        shoppingCart.removeProduct(prod1);
        final Map<Product, Long> shoppingCardProducts = shoppingCart.removeProduct(prod2);
        assertEquals(0, shoppingCardProducts.size());
    }

    @Test
    public void removeProductFromEmptyShoppingCart_sizeRemainsTheSame() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        final Map<Product, Long> shoppingCardProducts = shoppingCart.removeProduct(prod1);
        assertEquals(0, shoppingCardProducts.size());
    }

    @Test
    public void removeNonExistingProductFromShoppingCart_sizeRemainsTheSame() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        final Product prod2 = new Product("prod2", 9);
        shoppingCart.addProduct(prod1);
        final Map<Product, Long> shoppingCardProducts = shoppingCart.removeProduct(prod2);
        assertEquals(1, shoppingCardProducts.size());
    }

    //////
    @Test
    public void deleteOneProductFromShoppingCart_whenAddedOnce_decreasesSizeZero() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        shoppingCart.addProduct(prod1);
        final Map<Product, Long> shoppingCardProducts = shoppingCart.deleteProduct(prod1);
        assertEquals(0, shoppingCardProducts.size());
    }

    @Test
    public void deleteTwoProductsFromShoppingCart_whenAddedOncePerProduct_decreasesSizeZero() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        final Product prod2 = new Product("prod2", 9);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod2);
        shoppingCart.removeProduct(prod1);
        final Map<Product, Long> shoppingCardProducts = shoppingCart.deleteProduct(prod2);
        assertEquals(0, shoppingCardProducts.size());
    }

    @Test
    public void deleteProductFromEmptyShoppingCart_sizeRemainsTheSame() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        final Map<Product, Long> shoppingCardProducts = shoppingCart.deleteProduct(prod1);
        assertEquals(0, shoppingCardProducts.size());
    }

    @Test
    public void deleteNonExistingProductFromShoppingCart_sizeRemainsTheSame() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        final Product prod2 = new Product("prod2", 9);
        shoppingCart.addProduct(prod1);
        final Map<Product, Long> shoppingCardProducts = shoppingCart.removeProduct(prod2);
        assertEquals(1, shoppingCardProducts.size());
    }

    @Test
    public void deleteProductFromShoppingCart_whenAddedMulitpleTime_sizeRemainsTheSame() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod1);
        final Map<Product, Long> shoppingCardProducts = shoppingCart.deleteProduct(prod1);
        assertEquals(0, shoppingCardProducts.size());
    }

    @Test
    public void calculateTotalOnEmptyShoppingCard_shouldBeZero_NormalCard() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final double total = shoppingCart.calculateTotal();
        assertEquals(0, total);
    }

    @Test
    public void calculateTotalOnEmptyShoppingCard_shouldBeZero_GoldCard() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final double total = shoppingCart.calculateTotal(CreditCard.GOLD);
        assertEquals(0, total);
    }

    @Test
    public void calculateTotalOnEmptyShoppingCard_shouldBeZero_SilverCard() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final double total = shoppingCart.calculateTotal(CreditCard.SILVER);
        assertEquals(0, total);
    }



    @Test
    @DisplayName("One product in the shoppingCard, 0% discount should be applied to total when no Credit Card used")
    public void calculateTotalNoCardUsed_oneProduct() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        shoppingCart.addProduct(prod1);
        final double total = shoppingCart.calculateTotal();
        assertEquals(2.5, total);
    }

    @Test
    @DisplayName("Two different products in the shoppingCard, 0% discount should be applied to total when no Credit Card used")
    public void calculateTotalNoCardUsed_twoProducts() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        final Product prod2 = new Product("prod2", 9);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod2);
        final double total = shoppingCart.calculateTotal();
        assertEquals(11.5, total);
    }

    @Test
    @DisplayName("Two same products in the shopping card, 0% discount should be applied to total when no Credit Card used")
    public void calculateTotalNoCardUsed_twoSameProducts() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod1);
        final double total = shoppingCart.calculateTotal();
        assertEquals(5, total);
    }

    @Test
    @DisplayName("2x same product in the shopping card, 0% discount should be applied to total when no Credit Card used")
    public void calculateTotalNoCardUsed_severalAndSameProducts() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        final Product prod2 = new Product("prod2", 9);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod2);
        shoppingCart.addProduct(prod2);
        final double total = shoppingCart.calculateTotal();
        assertEquals(23, total);
    }

    @Test
    @DisplayName("One product in the shoppingCard, 10% discount should be applied to total when no Credit Card used")
    public void calculateTotalSilverCardUsed_oneProduct() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        shoppingCart.addProduct(prod1);
        final double total = shoppingCart.calculateTotal(CreditCard.SILVER);
        assertEquals(2.25, total);
    }

    @Test
    @DisplayName("Two different products in the shoppingCard, 10% discount should be applied to total when no Credit Card used")
    public void calculateTotalSilverCardUsed_twoProducts() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        final Product prod2 = new Product("prod2", 9);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod2);
        final double total = shoppingCart.calculateTotal(CreditCard.SILVER);
        assertEquals(10.35, total);
    }

    @Test
    @DisplayName("Two same products in the shopping card, 10% discount should be applied to total when no Credit Card used")
    public void calculateTotalSilverCardUsed_twoSameProducts() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod1);
        final double total = shoppingCart.calculateTotal(CreditCard.SILVER);
        assertEquals(4.5, total);
    }

    @Test
    @DisplayName("2x same product in the shopping card, 10% discount should be applied to total when no Credit Card used")
    public void calculateTotalSilverCardUsed_severalAndSameProducts() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        final Product prod2 = new Product("prod2", 9);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod2);
        shoppingCart.addProduct(prod2);
        final double total = shoppingCart.calculateTotal(CreditCard.SILVER);
        assertEquals(20.7, total);
    }

    @Test
    @DisplayName("One product in the shoppingCard, 20% discount should be applied to total when no Credit Card used")
    public void calculateTotalGoldCardUsed_oneProduct() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        shoppingCart.addProduct(prod1);
        final double total = shoppingCart.calculateTotal(CreditCard.GOLD);
        assertEquals(2, total);
    }

    @Test
    @DisplayName("Two different products in the shoppingCard, 20% discount should be applied to total when no Credit Card used")
    public void calculateTotalGoldCardUsed_twoProducts() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        final Product prod2 = new Product("prod2", 9);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod2);
        final double total = shoppingCart.calculateTotal(CreditCard.GOLD);
        assertEquals(9.2, total);
    }

    @Test
    @DisplayName("Two same products in the shopping card, 20% discount should be applied to total when no Credit Card used")
    public void calculateTotalGoldCardUsed_twoSameProducts() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod1);
        final double total = shoppingCart.calculateTotal(CreditCard.GOLD);
        assertEquals(4, total);
    }

    @Test
    @DisplayName("2x same product in the shopping card, 20% discount should be applied to total when no Credit Card used")
    public void calculateTotalGoldCardUsed_severalAndSameProducts() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Product prod1 = new Product("prod1", 2.5);
        final Product prod2 = new Product("prod2", 9);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod1);
        shoppingCart.addProduct(prod2);
        shoppingCart.addProduct(prod2);
        final double total = shoppingCart.calculateTotal(CreditCard.GOLD);
        assertEquals(18.4, total);
    }

}
