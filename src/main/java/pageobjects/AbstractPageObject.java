package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import static util.Wait.getClickableElement;
import static util.WebDriverFactory.getDriver;

@Getter
public abstract class AbstractPageObject {

    public AbstractPageObject() {

        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(getDriver())), this);
    }

    public final AbstractPageObject clickTo(final WebElement element) {

        findElementToClick(element).click();

        return this;
    }

    public final AbstractPageObject fillInputAs(final WebElement input, final String textToInput) {

        findElement(input).sendKeys(textToInput);

        return this;
    }

    public final WebElement findElementToClick(final WebElement pageElement) {

        return getClickableElement(pageElement);
    }

    public final WebElement findElement(final WebElement pageElement) {

//TODO need a risen as for waits which accept "By" type
        return pageElement;    // getPresentElement(pageElement);
    }

    public final AbstractPageObject acceptAlert() {

        getDriver()
                .switchTo()
                .alert()
                .accept();

        return this;
    }

    public final AbstractPageObject dismissAlert() {

        getDriver()
                .switchTo()
                .alert()
                .dismiss();

        return this;
    }

    public final AbstractPageObject refreshPage() {

        getDriver()
                .navigate()
                .refresh();

        return this;
    }

    public final void moveToElement(final WebElement elementToMove) {

        final Actions actions = new Actions(getDriver());

        actions
                .moveToElement(getClickableElement(elementToMove))
                .perform();
    }

    public final LogInPage doLogOut() {

        final UserAccountPage userAccountPage = new UserAccountPage();

        clickTo(userAccountPage.getLogOutLink());

        return new LogInPage();
    }
}
