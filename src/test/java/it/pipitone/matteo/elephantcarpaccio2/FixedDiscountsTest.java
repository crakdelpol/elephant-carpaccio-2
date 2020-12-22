package it.pipitone.matteo.elephantcarpaccio2;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class FixedDiscountsTest {

    private final FixedDiscounts fixedDiscounts = new FixedDiscounts();

    @Test
    void with800NoDiscount() {
        assertThat(fixedDiscounts.calculateDiscount(new BigDecimal("800")),comparesEqualTo(new BigDecimal("800")));
    }

    @Test
    void with1200TotalIs1164() {
        assertThat(fixedDiscounts.calculateDiscount(new BigDecimal("1200")),comparesEqualTo(new BigDecimal("1164")));
    }

    @Test
    void with5500TotalIs5225() {
        assertThat(fixedDiscounts.calculateDiscount(new BigDecimal("5500")),comparesEqualTo(new BigDecimal("5225")));
    }

    @Test
    void with7500TotalIs6975() {
        assertThat(fixedDiscounts.calculateDiscount(new BigDecimal("7500")),comparesEqualTo(new BigDecimal("6975")));
    }

    @Test
    void with15000TotalIs13500() {
        assertThat(fixedDiscounts.calculateDiscount(new BigDecimal("15000")),comparesEqualTo(new BigDecimal("13500")));
    }

    @Test
    void with50000TotalIs42500() {
        assertThat(fixedDiscounts.calculateDiscount(new BigDecimal("50000")),comparesEqualTo(new BigDecimal("42500")));
    }
}