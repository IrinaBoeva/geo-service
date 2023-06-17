package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    public void test_Locale_Russia() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String selected = localizationService.locale(Country.RUSSIA);
        String expected = "Добро пожаловать";

        Assertions.assertEquals(expected, selected);
    }

    @Test
    public void test_Locale_Other() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String selected = localizationService.locale(Country.GERMANY);
        String expected = "Welcome";

        Assertions.assertEquals(expected, selected);
    }

}