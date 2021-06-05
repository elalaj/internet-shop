package bussines;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entity.CreditCard;
import entity.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentTest {

    private Map<Product, Integer> products;

    @BeforeEach
    public void  setup(){
        products = new HashMap<>();
        products.put(Product.builder().description("prod1").price(2.5).build(), 2);
        products.put(Product.builder().description("prod2").price(25).build(), 1);
        products.put(Product.builder().description("prod3").price(1).build(), 10);
    }

    @Test
    public void testCalculateTotalForGoldCard() {
        //(2*2.5 + 1*25 + 10*1) * (1-0.2) = 32
        final double total = Payment.calculateTotal(products, CreditCard.GOLD);
        assertEquals(32, total);
    }

    @Test
    public void testCalculateTotalForSilverCard() {
        //(2*2.5 + 1*25 + 10*1) * (1-0.1) = 36
        final double total = Payment.calculateTotal(products, CreditCard.SILVER);
        assertEquals(36, total);
    }

    @Test
    public void testCalculateTotalForNormalCard() {
        //(2*2.5 + 1*25 + 10*1) = 40
        final double total = Payment.calculateTotal(products, CreditCard.NORMAL);
        assertEquals(40, total);
    }
}
