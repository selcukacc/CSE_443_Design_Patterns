package com.part3;

public class DecSuit extends Exoskeleton {

    public DecSuit() {
        description = "Dec Suit";
    }

    @Override
    public int cost() {
        return 500;
    }

    @Override
    public double weight() {
        return 25;
    }

}
