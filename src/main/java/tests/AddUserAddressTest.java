package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.UserAddressesPage;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;

public class AddUserAddressTest extends TestRunner {

    @BeforeMethod
    public void initializedPageObject(){

        userAddressesPage = new UserAddressesPage();
    }

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

        assertThat(userAddressesPage.getUserAddress()).isCreatedAs("Ukraine");

    }

    @AfterMethod
    public final void removeAddress() {

        userAddressesPage
                .deleteAddress()
                .doLogOut();
    }
}
