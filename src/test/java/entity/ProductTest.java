package entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    public void testEqualProduct()  {
        final Product product1 = new Product("prod", 10);
        final Product product2 = new Product("prod", 10);
        assertEquals(product1, product2);
    }

    @Test
    public void testNotEqualProduct_descriptionDifference()  {
        final Product product1 = new Product("prod", 10);
        final Product product2 = new Product("prod2", 10);
        assertNotEquals(product1, product2);
    }

    @Test
    public void testNotEqualProduct_priceDifference()  {
        final Product product1 = new Product("prod", 10);
        final Product product2 = new Product("prod", 12);
        assertNotEquals(product1, product2);
    }

    @Test
    public void testThrowsRunTimeException_whenNegativePrice()  {
        assertThrows(
                RuntimeException.class,
                () -> new Product("prod", -1)
        );
    }
}
