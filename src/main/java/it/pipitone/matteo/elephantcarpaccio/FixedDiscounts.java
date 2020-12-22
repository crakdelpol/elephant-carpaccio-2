package it.pipitone.matteo.elephantcarpaccio;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FixedDiscounts implements Discounts{

    private final TreeMap<BigDecimal, BigDecimal> discounts;

    public FixedDiscounts() {
        discounts = new TreeMap<>(){{
            put(new BigDecimal(1000), new BigDecimal(".03"));
            put(new BigDecimal(5000), new BigDecimal(".05"));
            put(new BigDecimal(7000), new BigDecimal(".07"));
            put(new BigDecimal(10000), new BigDecimal(".10"));
            put(new BigDecimal(50000), new BigDecimal(".15"));
        }};
    }

    public BigDecimal calculateDiscount(BigDecimal amount){
        if(amount.compareTo(discounts.firstKey()) < 1){
            return amount;
        }
        if(amount.compareTo(discounts.lastKey()) >= 0){
            return amount.multiply(BigDecimal.valueOf(.85));
        }

        AtomicReference<BigDecimal> previous = new AtomicReference<>(BigDecimal.ZERO);
        AtomicReference<BigDecimal> result = new AtomicReference<>(BigDecimal.ZERO);
        AtomicBoolean enter = new AtomicBoolean(false);

        discounts.keySet().forEach(bigDecimal -> {
            if(previous.get().compareTo(BigDecimal.ZERO) == 0){
                previous.set(bigDecimal);
            }

            if(amount.compareTo(bigDecimal) < 0 && !enter.get()){
                enter.set(true);
                BigDecimal multiplier = BigDecimal.ONE.subtract(discounts.get(previous.get()));
                result.set(amount.multiply(multiplier));
            }

            previous.set(bigDecimal);

        });

        return result.get().setScale(2);
    }
}
