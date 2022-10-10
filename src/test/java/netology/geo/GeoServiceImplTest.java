package netology.geo;

import netology.entity.Country;
import netology.entity.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    private GeoServiceImpl geoService = new GeoServiceImpl();

    @ParameterizedTest
    @ValueSource(strings = {"172.0.32.11"})
    void byIpMoscow(String ip) {
        Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Country country = location.getCountry();
        String city = location.getCity();
        int building = location.getBuiling();

        Location location1 = geoService.byIp(ip);
        Country country1 = location1.getCountry();
        String city1 = location1.getCity();
        int building1 = location1.getBuiling();
        Assertions.assertEquals(country, country1);
        Assertions.assertEquals(city, city1);
        Assertions.assertEquals(building, building1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"96.44.183.149"})
    void byIpNewYork(String ip) {
        Location location = new Location("New York", Country.USA, " 10th Avenue", 32);
        Country country = location.getCountry();
        String city = location.getCity();
        int building = location.getBuiling();

        Location location1 = geoService.byIp(ip);
        Country country1 = location1.getCountry();
        String city1 = location1.getCity();
        int building1 = location1.getBuiling();
        Assertions.assertEquals(country, country1);
        Assertions.assertEquals(city, city1);
        Assertions.assertEquals(building, building1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"96.00.000.000"})
    void byIpUSA(String ip) {
        Location location = new Location("New York", Country.USA, null, 0);
        Country country = location.getCountry();
        String city = location.getCity();
        int building = location.getBuiling();

        Location location1 = geoService.byIp(ip);
        Country country1 = location1.getCountry();
        String city1 = location1.getCity();
        int building1 = location1.getBuiling();
        Assertions.assertEquals(country, country1);
        Assertions.assertEquals(city, city1);
        Assertions.assertEquals(building, building1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"172.00.000.000"})
    void byIpRus(String ip) {
        Location location = new Location("Moscow", Country.RUSSIA, null, 0);
        Country country = location.getCountry();
        String city = location.getCity();
        int building = location.getBuiling();

        Location location1 = geoService.byIp(ip);
        Country country1 = location1.getCountry();
        String city1 = location1.getCity();
        int building1 = location1.getBuiling();
        Assertions.assertEquals(country, country1);
        Assertions.assertEquals(city, city1);
        Assertions.assertEquals(building, building1);
    }
}