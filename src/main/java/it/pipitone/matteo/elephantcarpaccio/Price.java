package it.pipitone.matteo.elephantcarpaccio;

import java.math.BigDecimal;

public class Price {

    private final BigDecimal value;

    public Price(String price) {
        this.value= new BigDecimal(price);
    }

    public Price(BigDecimal price) {
        this.value = price;
    }

    public BigDecimal multiply(NumberOfItems numberOfItems) {
        return value.multiply(BigDecimal.valueOf(numberOfItems.number));
    }

    public Price multiply(BigDecimal taxes) {
        return valueOf(value.multiply(taxes));
    }

    public static Price valueOf(BigDecimal price) {
        return new Price(price);
    }

}
