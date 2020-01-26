package com.part4b;

public abstract class PlaneFactory {

    abstract Plane createPlane(String item);

    public Plane orderPlane(String type) {
        Plane plane = createPlane(type);
        System.out.println("--------------------------------------------------------");
        System.out.println(">>> Building a " + plane.getName() + " <<<");
        plane.constructSkeleton();
        plane.placeEngines();
        plane.placeSeats();
        plane.assemble();
        return plane;
    }
}
