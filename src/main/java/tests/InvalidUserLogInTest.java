package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LogInPage;
import util.DataProvider;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;

public class InvalidUserLogInTest extends TestRunner {

    @BeforeMethod
    public void initializedPageObject(){

        logInPage = new LogInPage();
    }

    @Test(dataProvider = "testDataLogIn", dataProviderClass = DataProvider.class)
    public void testInvalidUserLogIn(final String invalidEmail, final String invalidPass) {

        homePage
                .openLogInPage()
                .setInvalidEmail(invalidEmail)
                .setInvalidPassword(invalidPass)
                .doLogIn();

        assertThat(logInPage.getInvalidUser()).isNotLogIn();
    }
}
