package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderTest {
    private GeoService geoService;
    private LocalizationService localizationService;
    private MessageSender messageSender;
    private Map<String, String> headers;


    @BeforeEach
    void setUp(){
        geoService = Mockito.mock(GeoService.class);
        localizationService = Mockito.mock(LocalizationService.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
        headers = new HashMap<>();
    }

    @Test
    public void test_SendMessage_Russia(){
        Mockito.when(geoService.byIp("172."))
                .thenReturn(new Location("Tyumen", Country.RUSSIA, "Shirotnaya", 165));
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");
        String selected = messageSender.send(headers);
        String expected = localizationService.locale(Country.RUSSIA);

        Assertions.assertEquals(expected, selected);
    }
    @Test
    public void test_SendMessage_USA(){
        Mockito.when(geoService.byIp("96."))
                .thenReturn(new Location("Dallas", Country.USA, "Wood", 5));
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");
        String selected = messageSender.send(headers);
        String expected = localizationService.locale(Country.USA);

        Assertions.assertEquals(expected, selected);
    }


}