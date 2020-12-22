package it.pipitone.matteo.elephantcarpaccio;

public class Item {

    private final Price price;
    private final State state;

    public Item(Price price,
                State state) {
        this.price = price;
        this.state = state;
    }

    public Price calculateTotalWithTax() {
        return state.calculateGrossPrice(price);
    }
}
