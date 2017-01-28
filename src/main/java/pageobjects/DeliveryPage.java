package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Button;

@Getter
public class DeliveryPage extends AbstractPageObject {

    @Name("Make order link")
    @FindBy(xpath = "//*[@id='form']//button")
    @Timeout(30)
    private Button makeOrderButton;

    @Step
    public final PaymentPage submitDelivery() {

        clickTo(makeOrderButton);

        return new PaymentPage();
    }
}
