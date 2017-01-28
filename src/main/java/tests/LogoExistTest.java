package tests;

import org.testng.annotations.Test;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;

public class LogoExistTest extends TestRunner {

    @Test
    public final void testLogoExist() {

        assertThat(homePage.getLogo()).isDisplayed();
    }
}
