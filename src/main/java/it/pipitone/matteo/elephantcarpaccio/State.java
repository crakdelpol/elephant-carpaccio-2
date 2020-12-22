package it.pipitone.matteo.elephantcarpaccio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class State {

    Map<String, BigDecimal> taxes = new HashMap<>() {{
        put("UT", new BigDecimal("6.85"));
        put("NV", new BigDecimal("8.00"));
        put("TX", new BigDecimal("6.25"));
        put("AL", new BigDecimal("4.00"));
        put("CA", new BigDecimal("8.25"));
    }};

    private final String stateSymbol;

    public State(String stateSymbol) {
        this.stateSymbol = stateSymbol;
    }

    public Price calculateGrossPrice(Price price) {
        return price.multiply(evaluatePercentTaxes());
    }

    private BigDecimal evaluatePercentTaxes() {
        return taxes.get(stateSymbol).divide(new BigDecimal("100"), 6, RoundingMode.HALF_UP);
    }
}
