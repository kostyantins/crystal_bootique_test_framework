package tests;

import org.testng.annotations.Test;
import util.DataProvider;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;
import static pageobjects.LogInPage.INVALID_USER;

public class InvalidUserLogInTest extends TestRunner {

    @Test(dataProvider = "testDataLogIn", dataProviderClass = DataProvider.class)
    public void testInvalidUserLogIn(final String invalidEmail, final String invalidPass) {

        homePage
                .openLogInPage()
                .setInvalidEmail(invalidEmail)
                .setInvalidPassword(invalidPass)
                .doLogIn();

        assertThat(INVALID_USER).isNotLogIn();
    }
}
