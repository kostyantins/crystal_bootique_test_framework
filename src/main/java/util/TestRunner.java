package util;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.*;
import pageobjects.*;
import ru.yandex.qatools.allure.annotations.*;

import java.net.MalformedURLException;

import static util.WebDriverFactory.getDriver;
import static util.WebDriverFactory.setDriver;

@Listeners({Listener.class})
public class TestRunner {

    protected HomePage homePage;
    protected LogInPage logInPage;
    protected CreateNewUserPage createNewUserPage;
    protected UserAccountPage userAccountPage;
    protected UserAddressesPage userAddressesPage;
    protected UserAddressPage userAddressPage;
    protected SwarovskiElementsPage swarovskiElementsPage;
    protected BasketStatePage basketStatePage;
    protected DeliveryPage deliveryPage;
    protected PaymentPage paymentPage;
    protected SupportOrderPage supportOrderPage;

    @Step
    @Parameters({"browser", "version", "platform"})
    @BeforeMethod
    public final void setUp(@Optional("default") final String browser,
                            @Optional("47") final String version,
                            @Optional("mac") final String platform) throws MalformedURLException {

        final String homePageUrl = PropertiesReader.getProperty("home.page.url");

        setDriver(browser, version, platform);

        getDriver()
                .manage()
                .window()
                .maximize();

        getDriver()
                .get(homePageUrl);

        homePage = new HomePage();
    }

    @Step
    @AfterTest
    public final void tarnDown() {

        if (getDriver() != null) {
            try {
                getDriver()
                        .quit();
            } catch (WebDriverException e) {
                System.out.println("***** CAUGHT EXCEPTION IN DRIVER TEARDOWN *****" + e);
            }
        }
    }
}
