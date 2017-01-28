package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@Getter
public class UserAccountPage extends AbstractPageObject {

    @Name("Log out link")
    @FindBy(xpath = "(//*[@id='header']//a)[2]")
    @Timeout(30)
    private Link logOutLink;

    // element to check if user log in or created
    @Name("Log out link")
    @FindBy(xpath = "//*[@id='header']//nav//a/span")
    @Timeout(30)
    private HtmlElement user;

    @Name("My address link")
    @FindBy(xpath = "(//*[@id='center_column']//a)[4]")
    @Timeout(30)
    private Link myAddressLink;

    @Step
    public final UserAddressesPage openUserAddressesPage() {

        clickTo(myAddressLink);

        return new UserAddressesPage();
    }

    @Step
    public final HomePage openHomePage() {

        final HomePage homePage = new HomePage();

        clickTo(homePage.getLogoLink());

        return new HomePage();
    }
}
