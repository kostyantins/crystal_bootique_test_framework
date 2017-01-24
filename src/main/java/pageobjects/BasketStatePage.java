package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

@Getter
public class BasketStatePage extends AbstractPageObject {

    private static final By MAKE_ORDER_LINK = By.xpath(".//*[@id='center_column']/p[2]/a[1]");

    @Step
    public UserAddressesPage submitChosenItem() {

        clickTo(MAKE_ORDER_LINK);

        return new UserAddressesPage();
    }
}
