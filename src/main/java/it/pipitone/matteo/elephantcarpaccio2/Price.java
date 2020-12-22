package it.pipitone.matteo.elephantcarpaccio2;

import java.math.BigDecimal;

public class Price extends BigDecimal {

    public Price(String price) {
        super(price);
    }

    public Price(BigDecimal price) {
        super(String.valueOf(price));
    }

    public BigDecimal multiply(NumberOfItems numberOfItems) {
        return super.multiply(BigDecimal.valueOf(numberOfItems.number));
    }

    public Price multiply(BigDecimal taxes) {
        return valueOf(super.multiply(taxes));
    }

    public static Price valueOf(BigDecimal price) {
        return new Price(price);
    }

}
