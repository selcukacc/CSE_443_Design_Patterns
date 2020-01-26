package com.part4b;

public class TPX300 extends Plane {
    PlaneComponentFactory componentFactory;

    public TPX300(PlaneComponentFactory componentFactory) {
        this.componentFactory = componentFactory;
        purpose = "Transatlantic Flights";
        skeleton = "Titanium Alloy";
        engine = "Quadro Jet Engines";
        seating = "250 seats";
    }

    @Override
    public void assemble() {
        System.out.println("Assembling " + name);
        engineInjectionType = componentFactory.createEngineInjectionType();
        seatingCover = componentFactory.createSeatingCover();
    }
}
