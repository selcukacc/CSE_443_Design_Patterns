package com.part4b;

public class OtherComonentFactory implements PlaneComponentFactory {
    @Override
    public EngineInjectionType createEngineInjectionType() {
        return new GearedTurbofanEngineInjection();
    }

    @Override
    public SeatingCover createSeatingCover() {
        return new LeatherSeatingCover();
    }
}
