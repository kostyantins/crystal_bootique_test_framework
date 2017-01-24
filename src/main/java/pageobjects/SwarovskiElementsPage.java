package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

@Getter
public class SwarovskiElementsPage extends AbstractPageObject {

    private static final By IN_BASKET_LINK = By.xpath("//*[@id='center_column']/ul/li[12]//div[3]/div/div[1]/a[1]");
    private static final By MAKE_ORDER_LINK = By.xpath("//*[@id='layer_cart']//a");
    private static final By ITEM_LIST_LINK = By.xpath("//*[@id='list']/a");

    @Step
    public final SwarovskiElementsPage chooseItem() {

        clickTo(ITEM_LIST_LINK);

        clickTo(IN_BASKET_LINK);

        return this;
    }

    @Step
    public final BasketStatePage startCreateOrder() {

        clickTo(MAKE_ORDER_LINK);

        return new BasketStatePage();
    }
}
