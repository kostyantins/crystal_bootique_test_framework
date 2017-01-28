package asserts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class WebElementAsserts {

    private WebElement actual;

    private WebElementAsserts(final WebElement actual) {
        this.actual = actual;
    }

    public static final WebElementAsserts assertThat(final WebElement actual) {

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

//        final WebElement webElement = getPresentElement(actual);

        if (!actual.isDisplayed()) {

            Assert.fail("Element {" + actual + "} should be displayed !");
        }
        return this;
    }

    @Step
    public final WebElementAsserts textContains(final String elementsText) {

        isNotNull();

//        final WebElement webElement = getPresentElement(actual);

        if (!actual
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

//        final WebElement webElement = getPresentElement(actual);

        if (!actual
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

//        final WebElement webElement = getPresentElement(actual);

        if (!actual
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

//        final WebElement webElement = getPresentElement(actual);

        if (!actual
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

//        final WebElement webElement = getPresentElement(actual);

        if (!actual.isDisplayed()) {

            Assert.fail("User {" + actual + "} shouldn't be Log In !");
        }
        return this;
    }

    @Step
    public final WebElementAsserts isCreated() {

        isNotNull();

//        final WebElement webElement = getPresentElement(actual);

        if (!actual.isDisplayed()) {

            Assert.fail("Element {" + actual + "} should be displayed !");
        }
        return this;
    }
}
