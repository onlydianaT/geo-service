package netology.geo;

import netology.entity.Country;
import netology.entity.Location;

public class GeoServiceImplMock extends GeoServiceImpl {

    private String city;

    private Country country;

    private String street;

    private int builing;
    private Location location=new Location(city,country, street,builing);


    @Override
    public Location byIp(String ip) {
        return location;
    }

    public void setValue (Location location){
        this.location=location;
    }

    @Override
    public Location byCoordinates(double latitude, double longitude) {
        throw new RuntimeException("Not implemented");
    }
}
