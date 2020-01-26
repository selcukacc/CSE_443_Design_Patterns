package com.part4b;

public class EurasiaComponentFactory implements PlaneComponentFactory {
    @Override
    public EngineInjectionType createEngineInjectionType() {
        return new TurbofanEngineInjection();
    }

    @Override
    public SeatingCover createSeatingCover() {
        return new LinenSeatingCover();
    }
}
