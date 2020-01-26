package com.part3;

public class AutoRifle extends AccessoryDecorator {
    Exoskeleton exoskeleton;

    public AutoRifle(Exoskeleton exoskeleton) {
        this.exoskeleton = exoskeleton;
    }

    @Override
    public String getDescription() {
        return exoskeleton.getDescription() + ", Auto Rifle";
    }

    @Override
    public int cost() {
        return 30 + exoskeleton.cost();
    }

    @Override
    public double weight() {
        return 1.5 + exoskeleton.weight();
    }
}
