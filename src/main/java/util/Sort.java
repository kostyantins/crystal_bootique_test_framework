package util;

import org.openqa.selenium.WebElement;
import pageobjects.SwarovskiElementsPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public final class Sort {

    private Sort() {
    }

    @Step
    public static final boolean isListElementsContains(final List<WebElement> elementsList, final String order) {

        for (final WebElement element : elementsList) {
            if (element.getText().contains(order)) {
                return true;
            }
        }
        return false;
    }

    @Step
    public static final boolean isListElementsEquals(final List<WebElement> elementsList, final String order) {

        for (final WebElement element : elementsList) {
            if (element.getText().equals(order)) {
                return true;
            }
        }
        return false;
    }

    @Step
    public static final boolean isListElementsEquals(final List<WebElement> elementsList, final int order) {

        return elementsList.size() == order;
    }
}

