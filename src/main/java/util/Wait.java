package util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static util.WebDriverFactory.getDriver;

public final class Wait {

    private Wait() {
    }

    private static int timeout = 30;

    //TODO what I should do with "By", cuz I need to send parameter WebElement???
    public static WebElement getPresentElement(final By element) {

        return new WebDriverWait(getDriver(), timeout)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static WebElement getClickableElement(final WebElement element) {

        return new WebDriverWait(getDriver(), timeout)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    //TODO what I should do with "By", cuz I need to send parameter WebElement???
    public static WebElement getVisibleElement(final By element) {

        return new WebDriverWait(getDriver(), timeout)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
