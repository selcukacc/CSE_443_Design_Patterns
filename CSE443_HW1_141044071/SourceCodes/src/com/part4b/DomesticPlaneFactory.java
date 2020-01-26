package com.part4b;

public class DomesticPlaneFactory extends PlaneFactory {
    @Override
    protected Plane createPlane(String item) {
        Plane plane = null;
        PlaneComponentFactory componentFactory =
                new DomesticComponentFactory();

        if(item.equals("TPX100")) {
            plane = new TPX100(componentFactory);
            plane.setName("TPX100 Plane for DOMESTIC Market");
        }
        else if(item.equals("TPX200")) {
            plane = new TPX200(componentFactory);
            plane.setName("TPX200 Plane for DOMESTIC Market");
        }
        else if(item.equals("TPX300")) {
            plane = new TPX300(componentFactory);
            plane.setName("TPX300 Plane for DOMESTIC Market");
        }

        return plane;
    }
}
