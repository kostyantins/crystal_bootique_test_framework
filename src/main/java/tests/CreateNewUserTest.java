package tests;

import org.testng.annotations.Test;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;

public class CreateNewUserTest extends TestRunner {

    @Test
    public final void testCreateNewUser() {

        homePage
                .openLogInPage()
                .setEmailToCreate()
                .submitEmail()
                .setSexAsMr()
                .setName()
                .setLastname()
                .setPassword()
                .setBirthdayDay()
                .setBirthdayMonth()
                .setBirthdayYear()
                .createUser();

        assertThat(userAccountPage.getUser()).isCreatedAs("Vasiliy Pupkin");
    }
}


// here should be @AfterMethod which delete created user from DB