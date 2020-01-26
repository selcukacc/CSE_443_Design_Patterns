package com.part3;

public class Laser extends AccessoryDecorator {
    Exoskeleton exoskeleton;

    public Laser(Exoskeleton exoskeleton) {
        this.exoskeleton = exoskeleton;
    }

    @Override
    public String getDescription() {
        return exoskeleton.getDescription() + ", Laser";
    }

    @Override
    public int cost() {
        return 200 + exoskeleton.cost();
    }

    @Override
    public double weight() {
        return 5.5 + exoskeleton.weight();
    }
}
