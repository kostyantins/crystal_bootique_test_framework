package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobjects.UserAddressesPage;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;
import static pageobjects.UserAddressesPage.USER_ADDRESS;

public class AddUserAddressTest extends TestRunner {

    @Test
    public final void testAddUserAddress() {

        homePage
                .openLogInPage()
                .setEmail()
                .setPassword()
                .doLogIn()
                .openUserAddressesPage()
                .startAddAddress()
                .setAddress()
                .setPostcode()
                .setCity()
                .setMobilePhone()
                .setState()
                .createAddress();

        assertThat(USER_ADDRESS).isCreatedAs("Ukraine");

    }

    @AfterMethod
    public final void removeAddress() {

        userAddressesPage = new UserAddressesPage();

        userAddressesPage
                .deleteAddress()
                .doLogOut();
    }
}
