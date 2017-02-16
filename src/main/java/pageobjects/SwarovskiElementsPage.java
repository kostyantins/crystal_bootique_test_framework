package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.Table;

import java.util.ArrayList;
import java.util.List;

import static util.Sort.isListElementsEquals;

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

    // element to check quantity of page items
    @Name("Table elements on page")
    @FindBy(xpath = "//*[@id='center_column']//ul[@class='product_list row list']/li")
    @Timeout(30)
    public static List<WebElement> elementsTable;

    @Name("Show items dropdown")
    @FindBy(id = "nb_item")
    @Timeout(30)
    private Select showItemDropdown;

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

    @Step
    public final SwarovskiElementsPage setItemsLikeList() {

        clickTo(itemListLink);

        return this;
    }

    @Step
    public final SwarovskiElementsPage setItemsOnPage(final String itemQuantity) {

        showItemDropdown
                .selectByValue(itemQuantity);

        return this;
    }
}
