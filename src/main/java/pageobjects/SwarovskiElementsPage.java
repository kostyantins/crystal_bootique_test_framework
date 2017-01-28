package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Link;

@Getter
public class SwarovskiElementsPage extends AbstractPageObject {

    @Name("In basket link")
    @FindBy(xpath = "//*[@id='center_column']/ul/li[12]//div[3]/div/div[1]/a[1]")
    @Timeout(30)
    private Link inBasketLink;

    @Name("Make order link")
    @FindBy(xpath = "//*[@id='layer_cart']//a")
    @Timeout(30)
    private Link makeOrderLink;

    @Name("Item list link")
    @FindBy(xpath = "//*[@id='list']/a")
    @Timeout(30)
    private Link itemListLink;

    @Step
    public final SwarovskiElementsPage chooseItem() {

        clickTo(itemListLink);

        clickTo(inBasketLink);

        return this;
    }

    @Step
    public final BasketStatePage startCreateOrder() {

        clickTo(makeOrderLink);

        return new BasketStatePage();
    }
}
