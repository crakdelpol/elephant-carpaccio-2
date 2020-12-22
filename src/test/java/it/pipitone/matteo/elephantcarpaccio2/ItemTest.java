package it.pipitone.matteo.elephantcarpaccio2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemTest {

    @Test
    void verifyCorrectCalculationWithTax() {
        Item item = new Item(new Price("100"), new State("CA"));
        Price price = item.calculateTotalWithTax();
        assertThat(price, is("108.300"));

    }
}