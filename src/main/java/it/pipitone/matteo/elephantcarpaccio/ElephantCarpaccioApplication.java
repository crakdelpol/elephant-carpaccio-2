package it.pipitone.matteo.elephantcarpaccio;


public class ElephantCarpaccioApplication {

    private static final Discounts discounts = new FixedDiscounts();
    private static final ConsolePrinter printer = new ConsolePrinter();
    private static final Cart cart = new Cart(printer, discounts);

    public static void main(String[] args) {

        NumberOfItems numberOfItems = new NumberOfItems(args[0]);
        Price price = new Price(args[1]);
        State state = new State(args[2]);

        Item item = new Item(price, state);
        cart.addItem(item, numberOfItems);
        cart.printTotal();
    }

}
