package util;

import org.openqa.selenium.WebElement;

import java.util.List;

public final class Sort {

    private Sort() {
    }

    public static final boolean isListElementsContains(final List<WebElement> elementsList, final String order) {

        for (WebElement element : elementsList) {
            if (element.getText().contains(order)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isListElementsEquals(final List<WebElement> elementsList, final String order) {

        for (WebElement element : elementsList) {
            if (element.getText().equals(order)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isListElementsEquals(final List<WebElement> elementsList, final int order) {

        return elementsList.size() == order;

    }
}
