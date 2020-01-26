package com.part4a;

public abstract class Plane {
    String name;
    String purpose;
    String skeleton;
    String engine;
    String seating;

    public String getName() {
        return name;
    }

    public void constructSkeleton() {
        System.out.println("The " + skeleton + " skeleton was made.");
    }

    public void placeEngines() {
        System.out.println("The " + engine + " was made.");
    }

    public void placeSeats() {
        System.out.println("The " + seating + " were made.");
    }

    public String toString() {
        StringBuffer display = new StringBuffer();
        display.append("Name: " + name + "\n");
        display.append("Purpose: " + purpose + "\n");
        display.append("Skeleton: " + skeleton + "\n");
        display.append("Engine: " + engine + "\n");
        display.append("Seating: " + seating + "\n");
        return display.toString();
    }
}
