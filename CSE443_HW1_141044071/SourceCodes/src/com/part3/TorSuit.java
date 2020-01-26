package com.part3;

public class TorSuit extends Exoskeleton {

    public TorSuit() {
        description = "Tor Suit";
    }

    @Override
    public int cost() {
        return 5000;
    }

    @Override
    public double weight() {
        return 50;
    }
}
