package com.part4b;

public abstract class Plane {
    String name;
    String purpose;
    String skeleton;
    String engine;
    String seating;

    EngineInjectionType engineInjectionType;
    SeatingCover seatingCover;

    public abstract void assemble();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        display.append("\nName: " + name + "\n");
        display.append("Purpose: " + purpose + "\n");
        display.append("Skeleton: " + skeleton + "\n");
        display.append("Engine: " + engine + "\n");
        display.append("Seating: " + seating + "\n");
        display.append("/// Market specific components \\\\\\\n");
        display.append("Engine Injection Type: " + engineInjectionType.toString() + "\n");
        display.append("Seating Cover: " + seatingCover.toString() + "\n");
        display.append("--------------------------------------------------------");
        return display.toString();
    }

}
