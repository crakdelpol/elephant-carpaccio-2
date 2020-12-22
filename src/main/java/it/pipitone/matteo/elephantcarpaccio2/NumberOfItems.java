package it.pipitone.matteo.elephantcarpaccio2;

public class NumberOfItems {
    int number;

    public NumberOfItems(String itemNumber) {
        this.number = Integer.parseInt(itemNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
