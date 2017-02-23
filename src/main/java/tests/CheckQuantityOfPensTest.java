package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.SwarovskiElementsPage;
import util.TestRunner;

import static asserts.CommonAssert.assertThat;
import static pageobjects.SwarovskiElementsPage.elementsTable;
import static pageobjects.SwarovskiElementsPage.pensCheckBox;
import static util.Sort.isListElementsEquals;

public class CheckQuantityOfPensTest extends TestRunner {

    @BeforeMethod
    public final void initializationPageObject() {

        swarovskiElementsPage = new SwarovskiElementsPage();
    }

    //TODO use DataProvider to test all dropdown functionality at ones
    @Test
    public final void testCheckQuantityOfPens() {

        homePage
                .openSwarovskiElementsPage()
                .set(pensCheckBox);

        assertThat(isListElementsEquals(swarovskiElementsPage.collectElementsS(elementsTable), 25)).isTrue();
    }
}
