package it.pipitone.matteo.elephantcarpaccio;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class Cart {

    private final Printer printer;
    private final Discounts discounts;
    HashMap<Item, NumberOfItems> items = new HashMap<>();

    public Cart(Printer printer, Discounts discounts) {
        this.printer = printer;
        this.discounts = discounts;
    }

    public void printTotal() {
        AtomicReference<BigDecimal> total = new AtomicReference<>(BigDecimal.ZERO);

        items.forEach((item, numberOfItems) -> {
            Price price = item.calculateTotalWithTax();

            BigDecimal add = total.get().add(price.multiply(numberOfItems));
            total.set(add);
        });

        BigDecimal result = discounts.calculateDiscount(total.get()).setScale(2);
        printer.print(result.toPlainString());

    }

    public void addItem(Item item, NumberOfItems numberOfItems) {
        this.items.put(item, numberOfItems);
    }
}
