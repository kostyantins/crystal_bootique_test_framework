package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@Getter
public class UserAddressesPage extends AbstractPageObject {

    @Name("Add address link")
    @FindBy(xpath = "//*[@id='center_column']/div/a")
    @Timeout(30)
    private Link addAddressLink;

    @Name("User address element")
    @FindBy(xpath = "(//*[@id='center_column']//ul//span)[5]")
    @Timeout(30)
    private HtmlElement userAddress;

    @Name("Make order button")
    @FindBy(xpath = "//*[@id='center_column']//button")
    @Timeout(30)
    private Button makeAddressButton;

    @Name("Delete address link")
    @FindBy(xpath = "//*[@id='center_column']//ul/li[11]/a[2]/span/i")
    @Timeout(30)
    private Link deleteAddressLink;

    @Step
    public final UserAddressPage startAddAddress() {

        clickTo(addAddressLink);

        return new UserAddressPage();
    }

    @Step
    public final DeliveryPage submitAddress() {

        clickTo(makeAddressButton);

        return new DeliveryPage();
    }

    @Step
    public final DeliveryPage deleteAddress() {

        clickTo(deleteAddressLink);
        acceptAlert();

        return new DeliveryPage();
    }

}
