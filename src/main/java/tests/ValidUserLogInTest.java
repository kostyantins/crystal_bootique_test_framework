package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.UserAccountPage;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;

public class ValidUserLogInTest extends TestRunner {

    @BeforeMethod
    public void initialisedPageObject(){

        userAccountPage = new UserAccountPage();
    }

    @Test
    public final void testValidUserLogIn() {

        homePage
                .openLogInPage()
                .setEmail()
                .setPassword()
                .doLogIn();

        assertThat(userAccountPage.getUser()).isLogInAs("Vasiliy Pupkin");
    }

    @AfterMethod
    public final void logOut() {

        userAccountPage
                .doLogOut();
    }
}
