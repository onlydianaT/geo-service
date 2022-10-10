package netology.i18n;

import netology.entity.Country;

public class LocalizationServiceImplMock extends LocalizationServiceImpl {
    private String value;

    @Override
    public String locale(Country country) {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
