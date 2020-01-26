package com.part3;

public class RocketLauncher extends AccessoryDecorator {
    Exoskeleton exoskeleton;

    public RocketLauncher(Exoskeleton exoskeleton) {
        this.exoskeleton = exoskeleton;
    }

    @Override
    public String getDescription() {
        return exoskeleton.getDescription() + ", Rocket Launcher";
    }

    @Override
    public int cost() {
        return 150 + exoskeleton.cost();
    }

    @Override
    public double weight() {
        return 7.5 + exoskeleton.weight();
    }
}
