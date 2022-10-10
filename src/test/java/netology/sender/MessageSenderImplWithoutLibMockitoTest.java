package netology.sender;

import netology.entity.Country;
import netology.entity.Location;
import netology.geo.GeoServiceImpl;
import netology.geo.GeoServiceImplMock;
import netology.i18n.LocalizationServiceImpl;
import netology.i18n.LocalizationServiceImplMock;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static netology.entity.Country.RUSSIA;
import static netology.entity.Country.USA;
import static netology.sender.MessageSenderImpl.IP_ADDRESS_HEADER;

public class MessageSenderImplWithoutLibMockitoTest {
    private static final String IP_ADDRESS_HEADER = "x-real-ip";
    private static final Country countryRus = RUSSIA;
    private static final Country countryUSA = USA;
    private GeoServiceImplMock geoService;
    private LocalizationServiceImplMock localizationService;
    private MessageSenderImpl messageSender;

    @Test
    public void sendOnlyRussianMessage() {
        geoService = new GeoServiceImplMock();
        geoService.setValue(new Location("Moscow", Country.RUSSIA, null, 0));

        localizationService = new LocalizationServiceImplMock();
        localizationService.setValue("Добро пожаловать");

        messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(IP_ADDRESS_HEADER, "172.000.00.00");

        String actualMessage = messageSender.send(headers);
        String expectedMessage = localizationService.locale(countryRus);
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test

    public void sendOnlyEnglishMessage() {
        geoService = new GeoServiceImplMock();
        geoService.setValue(new Location("New York", USA, null, 0));

        localizationService = new LocalizationServiceImplMock();
        localizationService.setValue("Welcome");

        messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(IP_ADDRESS_HEADER, "96.00.000.000");

        String actualMessage = messageSender.send(headers);
        String expectedMessage = localizationService.locale(countryUSA);
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

}

