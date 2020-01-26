package com.part3;

public class Flamethrower extends AccessoryDecorator {
    Exoskeleton exoskeleton;

    public Flamethrower(Exoskeleton exoskeleton) {
        this.exoskeleton = exoskeleton;
    }

    @Override
    public String getDescription() {
        return exoskeleton.getDescription() + ", Flamethrower";
    }

    @Override
    public int cost() {
        return 50 + exoskeleton.cost();
    }

    @Override
    public double weight() {
        return 2 + exoskeleton.weight();
    }
}
