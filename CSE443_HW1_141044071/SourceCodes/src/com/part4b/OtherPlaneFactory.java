package com.part4b;

public class OtherPlaneFactory extends PlaneFactory {
    @Override
    Plane createPlane(String item) {
        Plane plane = null;
        PlaneComponentFactory componentFactory =
                new OtherComonentFactory();

        if(item.equals("TPX100")) {
            plane = new TPX100(componentFactory);
            plane.setName("TPX100 Plane for OTHER Market");
        }
        else if(item.equals("TPX200")) {
            plane = new TPX200(componentFactory);
            plane.setName("TPX200 Plane for OTHER Market");
        }
        else if(item.equals("TPX300")) {
            plane = new TPX300(componentFactory);
            plane.setName("TPX300 Plane for OTHER Market");
        }

        return plane;
    }
}
