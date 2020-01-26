package com.part4b;

public class TPX100 extends Plane {
    PlaneComponentFactory componentFactory;

    public TPX100(PlaneComponentFactory componentFactory) {
        this.componentFactory = componentFactory;
        purpose = "Domestic Flights";
        skeleton = "Aluminum Alloy";
        engine = "Single Jet Engine";
        seating = "50 seats";
    }

    @Override
    public void assemble() {
        System.out.println("Assembling " + name);
        engineInjectionType = componentFactory.createEngineInjectionType();
        seatingCover = componentFactory.createSeatingCover();
    }
}
