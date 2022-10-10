package netology.i18n;

import netology.entity.Country;
import netology.geo.GeoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static netology.entity.Country.RUSSIA;
import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    private LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

    @ParameterizedTest
    @ValueSource(strings = {"RUSSIA"})
    void localeRus(Country country) {
        String actualMessage = localizationService.locale(country);
        String expectedMessage = "Добро пожаловать";
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"GERMANY"})
    void localeEng(Country country) {
        String actualMessage = localizationService.locale(country);
        String expectedMessage = "Welcome";
        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}