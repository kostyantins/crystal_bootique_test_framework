package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.Select;

import java.util.LinkedList;
import java.util.List;

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
    @FindBy(xpath = "//*[@id='center_column']/ul/li")
    @Timeout(30)
    public static List<WebElement> elementsTable;

    @Name("Show items dropdown")
    @FindBy(xpath = "//*[@id='nb_item']")
    @Timeout(30)
    private Select showItemDropdown;

    @Name("Pens check box")
    @FindBy(id = "layered_category_8")
    @Timeout(30)
    public static CheckBox pensCheckBox;

    @Name("Table pages to go")
    @FindBy(xpath = "//*[@id='pagination_bottom']/ul/li")
    @Timeout(30)
    public static List<WebElement> tablePagesToGo;

    @Name("Pagination next link")
    @FindBy(xpath = "//*[@id='pagination_next']/a")
    @Timeout(30)
    private Link paginationNextLink;

    @Name("Pagination back link")
    @FindBy(xpath = "//*[@id='pagination_previous']/a")
    @Timeout(30)
    private Link paginationBackLink;

    public SwarovskiElementsPage() {
    }

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

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }

    @Step
    public final SwarovskiElementsPage lookForNextPage() {

        if (tablePagesToGo.iterator().hasNext()) {

            paginationNextLink.click();
        }

        return this;
    }

    @Step
    public final SwarovskiElementsPage set(final WebElement checkBoxName) {

        if (checkBoxName.isSelected()) {
            checkBoxName.clear();
        } else {
            checkBoxName
                    .click();
        }
        return this;
    }

    //TODO method needs to be decompose, throw functionality in some util class and here just to call a method
    @Step
    public final List<WebElement> collectElements(final List<WebElement> webElementsList) {

        final List<WebElement> newWebElementsList = new LinkedList<>();

        newWebElementsList.addAll(webElementsList);

        if (paginationNextLink.isEnabled()) {

            for (int i = 3; i <= tablePagesToGo.size() - 1; i++) {

                paginationNextLink.click();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                newWebElementsList.addAll(webElementsList);
            }
        } else return newWebElementsList;

        return newWebElementsList;
    }
}
