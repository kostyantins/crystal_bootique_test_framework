package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Link;

@Getter
public class PaymentPage extends AbstractPageObject {

    @Name("Payment by cash link")
    @FindBy(xpath = "//*[@id='HOOK_PAYMENT']//a")
    @Timeout(30)
    private Link paymentByCashLink;

    @Step
    public final SupportOrderPage choosePayment() {

        clickTo(paymentByCashLink);

        return new SupportOrderPage();
    }
}
