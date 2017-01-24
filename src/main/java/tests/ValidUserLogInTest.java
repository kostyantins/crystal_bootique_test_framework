package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobjects.UserAccountPage;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;
import static pageobjects.UserAccountPage.USER;

public class ValidUserLogInTest extends TestRunner {

    @Test
    public final void testValidUserLogIn() {

        homePage
                .openLogInPage()
                .setEmail()
                .setPassword()
                .doLogIn();

        assertThat(USER).isLogInAs("Vasiliy Pupkin");
    }

    @AfterMethod
    public final void logOut() {

        userAccountPage = new UserAccountPage();

        userAccountPage
                .doLogOut();
    }
}
