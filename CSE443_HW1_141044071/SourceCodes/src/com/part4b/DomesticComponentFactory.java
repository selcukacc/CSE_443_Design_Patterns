package com.part4b;

public class DomesticComponentFactory implements PlaneComponentFactory {
    @Override
    public EngineInjectionType createEngineInjectionType() {
        return new TurbojetEngineInjection();
    }

    @Override
    public SeatingCover createSeatingCover() {
        return new VelvetSeatingCover();
    }
}
