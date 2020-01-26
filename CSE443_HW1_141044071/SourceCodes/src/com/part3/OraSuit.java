package com.part3;

public class OraSuit extends Exoskeleton{

    public OraSuit() {
        description = "Ora Suit";
    }

    @Override
    public int cost() {
        return 1500;
    }

    @Override
    public double weight() {
        return 30;
    }
}
