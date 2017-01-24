package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static pageobjects.HomePage.LOGO_LINK;

@Getter
public class UserAccountPage extends AbstractPageObject {

    // element to check if user log in or created
    public static final By USER = By.xpath("//*[@id='header']//nav//a/span");
    private static final By MY_ADDRESS_LINK = By.xpath("(//*[@id='center_column']//a)[4]");
    public static final By LOG_OUT_LINK = By.xpath("(//*[@id='header']//a)[2]");

    @Step
    public final UserAddressesPage openUserAddressesPage() {

        clickTo(MY_ADDRESS_LINK);

        return new UserAddressesPage();
    }

    @Step
    public final HomePage openHomePage() {

        clickTo(LOGO_LINK);

        return new HomePage();
    }
}
