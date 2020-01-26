package com.part4a;

public abstract class PlaneFactory {

    /**
     * Factory method for TPX type planes.
     * @param item Tpx model
     * @return Wanted and assembled plane.
     */
    public abstract Plane createPlane(String item);

    public Plane orderPlane(String type) {
        Plane plane = createPlane(type);
        System.out.println(">>> Building a " + plane.getName() + " <<<");
        plane.constructSkeleton();
        plane.placeEngines();
        plane.placeSeats();
        return plane;
    }
}
