package com.part3;

public class ZirhSanProduction {

    public static void main(String[] args) {
        System.out.println("-------- Part 3 --------");

        Exoskeleton exoskeleton = new DecSuit();
        exoskeleton = new Flamethrower(exoskeleton);
        exoskeleton = new AutoRifle(exoskeleton);
        exoskeleton = new AutoRifle(exoskeleton);
        exoskeleton = new RocketLauncher(exoskeleton);

        System.out.println(exoskeleton.getDescription()
            + "\nCost: " + exoskeleton.cost() + "000TL"
            + "\nWeight: " + exoskeleton.weight() + "kg");


    }

}
