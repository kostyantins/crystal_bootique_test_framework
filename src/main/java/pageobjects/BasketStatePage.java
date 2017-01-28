package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Link;

@Getter
public class BasketStatePage extends AbstractPageObject {

    @Name("Make order link")
    @FindBy(xpath = "//*[@id='center_column']/p[2]/a[1]")
    @Timeout(30)
    private Link makeOrderLink;

    @Step
    public UserAddressesPage submitChosenItem() {

        clickTo(makeOrderLink);

        return new UserAddressesPage();
    }
}
