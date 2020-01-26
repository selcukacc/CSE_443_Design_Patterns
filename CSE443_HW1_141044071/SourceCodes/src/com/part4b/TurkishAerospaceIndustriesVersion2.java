package com.part4b;

public class TurkishAerospaceIndustriesVersion2 {

    public static void main(String[] args) {
        System.out.println("-------- Part 4b(Abstract Factory) --------");

        PlaneFactory domesticFactory = new DomesticPlaneFactory();
        PlaneFactory eurasiaFactory = new EurasiaPlaneFactory();

        Plane plane = domesticFactory.orderPlane("TPX200");
        System.out.println(plane.toString());

        plane = eurasiaFactory.orderPlane("TPX300");
        System.out.println(plane.toString());
    }
}
