package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;
import util.PropertiesReader;

@Getter
public class UserAddressPage extends AbstractPageObject {

    //TODO do something with this konstance the test should work with property
    private static final String STATE = ("Ивано-Франковская область");

    @Name("Address input field")
    @FindBy(id = "address1")
    @Timeout(30)
    private TextInput addressInput;

    @Name("Postcode input field")
    @FindBy(id = "postcode")
    @Timeout(30)
    private TextInput postcodeInput;

    @Name("City input field")
    @FindBy(id = "city")
    @Timeout(30)
    private TextInput cityInput;

    @Name("Mobile phone input field")
    @FindBy(id = "phone_mobile")
    private TextInput mobilePhoneInput;

    @Name("State checkbox")
    @FindBy(id = "id_state")
    private Select stateCheckbox;

    @Name("Submit address button")
    @FindBy(id = "submitAddress")
    private Button submitAddressButton;

    private String address = PropertiesReader.getProperty("address");
    private String postcode = PropertiesReader.getProperty("postcode");
    private String city = PropertiesReader.getProperty("city");
    private String mobilePhone = PropertiesReader.getProperty("mobile.phone");
    private String state = PropertiesReader.getProperty("state");


    @Step
    public final UserAddressPage setAddress() {

        fillInputAs(addressInput, address);

        return this;
    }

    @Step
    public final UserAddressPage setPostcode() {

        fillInputAs(postcodeInput, postcode);

        return this;
    }

    @Step
    public final UserAddressPage setCity() {

        fillInputAs(cityInput, city);

        return this;
    }

    @Step
    public final UserAddressPage setMobilePhone() {

        fillInputAs(mobilePhoneInput, mobilePhone);

        return this;
    }

    @Step
    public final UserAddressPage setState() {

        fillInputAs(stateCheckbox, STATE);

        return this;
    }

    @Step
    public final UserAddressesPage createAddress() {

        clickTo(submitAddressButton);

        return new UserAddressesPage();
    }
}
