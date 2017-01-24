package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

@Getter
public class SupportOrderPage extends AbstractPageObject {

    public static final By ORDER = By.xpath("//*[@id='cart_navigation']/button");
    private static final By BASKET_LINK = By.xpath("//*[@id='header']/div[2]/div/div/div[3]/div/a");
    private static final By DELETE_ITEM_FROM_BASKET_LINK = By.xpath("//*[@id='header']//dl/dt/span/a");

    @Step
    public final SupportOrderPage goToBasket() {

        moveToElement(BASKET_LINK);

        return this;
    }

    @Step
    public final SupportOrderPage makeBasketEmpty() {

        goToBasket();

        clickTo(DELETE_ITEM_FROM_BASKET_LINK);

        return this;
    }
}
