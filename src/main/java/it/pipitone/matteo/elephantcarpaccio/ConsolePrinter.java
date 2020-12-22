package it.pipitone.matteo.elephantcarpaccio;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String value) {
        System.out.println(value);
    }
}
