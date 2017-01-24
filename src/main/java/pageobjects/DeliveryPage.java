package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

@Getter
public class DeliveryPage extends AbstractPageObject {

    private static final By MAKE_ORDER_LINK = By.xpath("//*[@id='form']//button");

    @Step
    public final PaymentPage submitDelivery() {

        clickTo(MAKE_ORDER_LINK);

        return new PaymentPage();
    }
}
