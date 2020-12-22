package it.pipitone.matteo.elephantcarpaccio2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CartUnitTest {

    @Test
    public void EndToEndTest() {

        FakePrinter printer = new FakePrinter();
        Cart cart = new Cart(printer, new FixedDiscounts());
        cart.addItem(new Item(new Price("10"), new State("CA")), new NumberOfItems("1"));
        cart.printTotal();
        assertThat(printer.value, is("10.830"));
    }

    @Test
    public void EndToEndTestWith40k() {

        FakePrinter printer = new FakePrinter();
        Cart cart = new Cart(printer, new FixedDiscounts());
        cart.addItem(new Item(new Price("4000"), new State("CA")), new NumberOfItems("10"));
        cart.printTotal();
        assertThat(printer.value, is("38988.00"));
    }



    private static class FakePrinter implements Printer {

        public String value;

        @Override
        public void print(String value) {
            this.value = value;
        }
    }
}