package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.SupportOrderPage;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;

public class CreateOrderTest extends TestRunner {

    @BeforeMethod
    public final void initialisePageObjects() {

        supportOrderPage = new SupportOrderPage();

        homePage
                .openLogInPage()
                .setEmailToAddAddress()
                .setPassword()
                .doLogIn()
                .openHomePage();
    }

    @Test
    public final void testAddUserAddress() {

        homePage
                .openSwarovskiElementsPage()
                .chooseItem()
                .startCreateOrder()
                .submitChosenItem()
                .submitAddress()
                .submitDelivery()
                .choosePayment();

        assertThat(supportOrderPage.getOrder()).isCreated();
    }

    @AfterMethod
    public final void emptyBasket() {

        supportOrderPage
                .makeBasketEmpty();
    }
}
