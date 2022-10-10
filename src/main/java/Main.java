import netology.geo.GeoService;
import netology.geo.GeoServiceImpl;
import netology.i18n.LocalizationService;
import netology.i18n.LocalizationServiceImpl;
import netology.sender.MessageSender;
import netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {

    //Тестовый пример
    public static void main(String[] args) {
        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        messageSender.send(headers);
    }
}