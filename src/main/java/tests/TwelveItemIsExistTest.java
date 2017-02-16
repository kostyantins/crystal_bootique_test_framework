package tests;

import org.testng.annotations.Test;
import pageobjects.SwarovskiElementsPage;
import util.TestRunner;

import static asserts.CommonAssert.assertThat;
import static pageobjects.SwarovskiElementsPage.elementsTable;
import static util.Sort.isListElementsEquals;

public class TwelveItemIsExistTest extends TestRunner {

    @Test
    public final void testTwelveItemIsExist() {

        swarovskiElementsPage = new SwarovskiElementsPage();

        homePage
                .openSwarovskiElementsPage()
                .setItemsLikeList()
                .setItemsOnPage("24");

        assertThat(isListElementsEquals(elementsTable, 24));
    }
}
