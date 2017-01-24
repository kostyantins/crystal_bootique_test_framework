package tests;

import org.testng.annotations.Test;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;
import static pageobjects.HomePage.LOGO;

public class LogoExistTest extends TestRunner {

    @Test
    public final void testLogoExist() {

        assertThat(LOGO).isDisplayed();
    }
}
