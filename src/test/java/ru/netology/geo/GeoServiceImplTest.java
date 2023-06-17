package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @Test
    public void test_ByIp_Russia(){
        GeoService geoService = new GeoServiceImpl();
        Country selected = geoService.byIp("172.").getCountry();
        Country expected = new Location("Tyumen", Country.RUSSIA, "Shirotnaya", 165).getCountry();

        Assertions.assertEquals(expected, selected);
    }

    @Test
    public void test_ByIp_USA(){
        GeoService geoService = new GeoServiceImpl();
        Country selected = geoService.byIp("96.").getCountry();
        Country expected = new Location("Dallas", Country.USA, "Wood", 5).getCountry();

        Assertions.assertEquals(expected, selected);
    }

}