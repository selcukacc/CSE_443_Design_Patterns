package com.part4a;

public class TPXPlaneFactory extends PlaneFactory {
    /**
     * Creates planes according to the model.
     * @param item Tpx model
     * @return
     */
    @Override
    public Plane createPlane(String item) {
        if(item.equals("TPX100")) {
            return new TPX100();
        }
        else if(item.equals("TPX200")) {
            return new TPX200();
        }
        else if(item.equals("TPX300")) {
            return new TPX300();
        }
        else {
            return null;
        }
    }
}
