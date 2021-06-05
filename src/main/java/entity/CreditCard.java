package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CreditCard {
    GOLD(0.2),
    SILVER(0.1),
    NORMAL(0);

    private final double discount;
}
