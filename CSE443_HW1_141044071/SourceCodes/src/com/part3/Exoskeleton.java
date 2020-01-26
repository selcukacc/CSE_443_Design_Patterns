package com.part3;

public abstract class Exoskeleton {
    String description = "Skeleton of Exoskeleton";

    public String getDescription() {
        return description;
    }

    /**
     * Calculates exoskeleton cost according to the accessories and skeleton.
     * @return cost of armor.
     */
    protected abstract int cost();

    public abstract double weight();
}
