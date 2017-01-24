package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

@Getter
public class PaymentPage extends AbstractPageObject {

    private static final By PAYMENT_BY_CASH_LINK = By.xpath("//*[@id='HOOK_PAYMENT']//a");

    @Step
    public final SupportOrderPage choosePayment() {

        clickTo(PAYMENT_BY_CASH_LINK);

        return new SupportOrderPage();
    }
}
