package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.SwarovskiElementsPage;
import util.TestRunner;

import java.sql.Time;

import static asserts.CommonAssert.assertThat;
import static pageobjects.SwarovskiElementsPage.elementsTable;
import static util.Sort.isListElementsEquals;

public class PageItemsExistTest extends TestRunner {

    @BeforeMethod
    public final void initializationPageObject() {

        swarovskiElementsPage = new SwarovskiElementsPage();
    }

    //TODO use DataProvider to test all dropdown functionality at ones
    @Test
    public final void testPageItemsExistTest() {

        homePage
                .openSwarovskiElementsPage()
                .setItemsOnPage("24");

        assertThat(isListElementsEquals(elementsTable, 24)).isTrue();
    }
}