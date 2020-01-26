package com.part4a;

public class TurkishAerospaceIndustries {

    public static void main(String[] args) {
        System.out.println("-------- Part 4a(Factory Method) --------");
        PlaneFactory tpxFactory = new TPXPlaneFactory();

        Plane plane = tpxFactory.orderPlane("TPX100");
        System.out.println(plane.toString());

        plane = tpxFactory.orderPlane("TPX200");
        System.out.println(plane.toString());

        plane = tpxFactory.orderPlane("TPX300");
        System.out.println(plane.toString());
    }

}
