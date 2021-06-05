package entity;

import java.util.Objects;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {

    private String description;
    private double price;

    public Product(final String description, final double price) {
        validatePrice(price);
        this.description = description;
        this.price = price;
    }

    private static void validatePrice(final double price) {
        if (price <= 0) {
            final String errorMessage = String.format("Price: %s is not a valid value!", price);
            throw new RuntimeException(errorMessage);
        }
    }

    @Override
    public boolean equals(final Object obj) {
        final Product productToCompare = (Product) obj;
        return productToCompare.getPrice() == price && productToCompare.getDescription().equals(description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price);
    }
}
