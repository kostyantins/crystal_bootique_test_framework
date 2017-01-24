package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static pageobjects.UserAccountPage.LOG_OUT_LINK;
import static util.Wait.getClickableElement;
import static util.Wait.getPresentElement;
import static util.WebDriverFactory.getDriver;

@Getter
public abstract class AbstractPageObject {

    public final AbstractPageObject clickTo(final By element) {

        findElementToClick(element).click();

        return this;
    }

    public final AbstractPageObject fillInputAs(final By input, final String textToInput) {

        findElement(input).sendKeys(textToInput);

        return this;
    }

    public final WebElement findElementToClick(By pageElement) {

        return getClickableElement(pageElement);
    }

    public final WebElement findElement(By pageElement) {

        return getPresentElement(pageElement);
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

    public final void moveToElement(final By elementToMove) {

        final Actions actions = new Actions(getDriver());

        actions
                .moveToElement(getClickableElement(elementToMove))
                .perform();
    }

    public final LogInPage doLogOut() {

        clickTo(LOG_OUT_LINK);

        return new LogInPage();
    }
}
