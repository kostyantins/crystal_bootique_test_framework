package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

@Getter
public class UserAddressesPage extends AbstractPageObject {

    private static final By ADD_ADDRESS_LINK = By.xpath("//*[@id='center_column']/div/a");
    public static final By USER_ADDRESS = By.xpath("(//*[@id='center_column']//ul//span)[5]");
    private static final By MAKE_ORDER_LINK = By.xpath("//*[@id='center_column']//button");
    private static final By DELETE_ADDRESS_LINK = By.xpath("//*[@id='center_column']//ul/li[11]/a[2]/span/i");

    @Step
    public final UserAddressPage startAddAddress() {

        clickTo(ADD_ADDRESS_LINK);

        return new UserAddressPage();
    }

    @Step
    public final DeliveryPage submitAddress() {

        clickTo(MAKE_ORDER_LINK);

        return new DeliveryPage();
    }

    @Step
    public final DeliveryPage deleteAddress() {

        clickTo(DELETE_ADDRESS_LINK);
        acceptAlert();

        return new DeliveryPage();
    }

}
