package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;

@Getter
public class SupportOrderPage extends AbstractPageObject {

    @Name("Order button")
    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    @Timeout(30)
    private Button order;

    @Name("Basket link")
    @FindBy(xpath = "//*[@id='header']/div[2]/div/div/div[3]/div/a")
    @Timeout(30)
    private Link basketLink;

    @Name("Delete item from basket link")
    @FindBy(xpath = "//*[@id='header']//dl/dt/span/a")
    @Timeout(30)
    private Link deleteItem;

    @Step
    public final SupportOrderPage goToBasket() {

        moveToElement(basketLink);

        return this;
    }

    @Step
    public final SupportOrderPage makeBasketEmpty() {
//TODO get some information about HtmlElements to work with Action class
//        goToBasket();
        basketLink.click();

        clickTo(deleteItem);

        return this;
    }
}
