package asserts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static util.Wait.getPresentElement;

public class WebElementAsserts {

    private By actual;

    private WebElementAsserts(final By actual) {
        this.actual = actual;
    }

    public static final WebElementAsserts assertThat(final By actual) {

        return new WebElementAsserts(actual);
    }

    @Step
    private final WebElementAsserts isNotNull() {

        if (actual == null) {
            Assert.fail("Element should be not null");
        }
        return this;
    }

    @Step
    public final WebElementAsserts isDisplayed() {

        isNotNull();

        final WebElement webElement = getPresentElement(actual);

        if (!webElement.isDisplayed()) {

            Assert.fail("Element {" + actual + "} should be displayed !");
        }
        return this;
    }

    @Step
    public final WebElementAsserts textContains(final String elementsText) {

        isNotNull();

        final WebElement webElement = getPresentElement(actual);

        if (!webElement
                .getText()
                .contains(elementsText)) {

            Assert.fail("Element's {" + actual + "} text {" + actual +
                    "} should contain {" + elementsText + "} !");
        }
        return this;
    }

    @Step
    public final WebElementAsserts isEqual(final String elementsText) {

        isNotNull();

        final WebElement webElement = getPresentElement(actual);

        if (!webElement
                .getText()
                .equalsIgnoreCase(elementsText)) {

            Assert.fail("Element's {" + actual + "} text {" + actual +
                    "} should be equal {" + elementsText + "} !");
        }
        return this;
    }

    @Step
    public final WebElementAsserts isCreatedAs(final String userName) {

        isNotNull();

        final WebElement webElement = getPresentElement(actual);

        if (!webElement
                .getText()
                .equalsIgnoreCase(userName)) {

            Assert.fail("Element's {" + actual + "} text {" + actual +
                    "} should be equal {" + userName + "} !");
        }
        return this;
    }

    @Step
    public final WebElementAsserts isLogInAs(final String userName) {

        isNotNull();

        final WebElement webElement = getPresentElement(actual);

        if (!webElement
                .getText()
                .equalsIgnoreCase(userName)) {

            Assert.fail("Element's {" + actual + "} text {" + actual +
                    "} should be equal {" + userName + "} !");
        }
        return this;
    }

    @Step
    public final WebElementAsserts isNotLogIn() {

        isNotNull();

        final WebElement webElement = getPresentElement(actual);

        if (!webElement.isDisplayed()) {

            Assert.fail("User {" + actual + "} shouldn't be Log In !");
        }
        return this;
    }

    @Step
    public final WebElementAsserts isCreated() {

        isNotNull();

        final WebElement webElement = getPresentElement(actual);

        if (!webElement.isDisplayed()) {

            Assert.fail("Element {" + actual + "} should be displayed !");
        }
        return this;
    }
}
