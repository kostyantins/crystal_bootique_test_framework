package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;
import util.PropertiesReader;

@Getter
public class UserAddressPage extends AbstractPageObject {

    private static final By ADDRESS_INPUT_FIELD = By.id("address1");
    private static final By POSTCODE_INPUT_FIELD = By.id("postcode");
    private static final By CITY_INPUT_FIELD = By.id("city");
    private static final By MOBILE_PHONE_INPUT_FIELD = By.id("phone_mobile");
    private static final By STATE_CHECKBOX = By.id("id_state");
    private static final By SUBMIT_ADDRESS_BUTTON = By.id("submitAddress");
    private static final String STATE = ("Ивано-Франковская область");

    private String address = PropertiesReader.getProperty("address");
    private String postcode = PropertiesReader.getProperty("postcode");
    private String city = PropertiesReader.getProperty("city");
    private String mobilePhone = PropertiesReader.getProperty("mobile.phone");
    private String state = PropertiesReader.getProperty("state");


    @Step
    public final UserAddressPage setAddress() {

        fillInputAs(ADDRESS_INPUT_FIELD, address);

        return this;
    }

    @Step
    public final UserAddressPage setPostcode() {

        fillInputAs(POSTCODE_INPUT_FIELD, postcode);

        return this;
    }

    @Step
    public final UserAddressPage setCity() {

        fillInputAs(CITY_INPUT_FIELD, city);

        return this;
    }

    @Step
    public final UserAddressPage setMobilePhone() {

        fillInputAs(MOBILE_PHONE_INPUT_FIELD, mobilePhone);

        return this;
    }

    @Step
    public final UserAddressPage setState() {

        fillInputAs(STATE_CHECKBOX, STATE);

        return this;
    }

    @Step
    public final UserAddressesPage createAddress() {

        clickTo(SUBMIT_ADDRESS_BUTTON);

        return new UserAddressesPage();
    }
}
