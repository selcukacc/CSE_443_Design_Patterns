package com.part4b;

public class TPX200 extends Plane {
    PlaneComponentFactory componentFactory;

    public TPX200(PlaneComponentFactory componentFactory) {
        this.componentFactory = componentFactory;
        purpose = "Domestic and short international flights";
        skeleton = "Nickel Alloy";
        engine = "Twin Jet Engines";
        seating = "100 seats";
    }

    @Override
    public void assemble() {
        System.out.println("Assembling " + name);
        engineInjectionType = componentFactory.createEngineInjectionType();
        seatingCover = componentFactory.createSeatingCover();
    }
}
