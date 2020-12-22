package it.pipitone.matteo.elephantcarpaccio2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item {
    private final Price price;
    private final State state;

    public Item(Price price,
                State state) {
        this.price = price;
        this.state = state;
    }

    public Price calculateTotalWithTax() {
        return price.multiply(BigDecimal.ONE.add(state.retrieveTaxes().divide(new BigDecimal("100"), 3, RoundingMode.HALF_UP)));
    }
}
