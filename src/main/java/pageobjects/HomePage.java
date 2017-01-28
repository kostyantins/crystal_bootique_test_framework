package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Image;
import ru.yandex.qatools.htmlelements.element.Link;

@Getter
public class HomePage extends AbstractPageObject {

    @Name("Home page logo")
    @FindBy(xpath = "//*[@id='header_logo']/a/img")
    @Timeout(30)
    private Image logo;

    @Name("Login page link")
    @FindBy(xpath = "(//*[@id='header']//nav//a)[1]")
    @Timeout(30)
    private Link loginPageLink;

    @Name("Home page logo link")
    @FindBy(xpath = "//*[@id='header_logo']/a")
    @Timeout(30)
    private Link logoLink;

    @Name("Swarovski element link")
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
    @Timeout(30)
    private Link swarovskiElementLink;

    @Step
    public LogInPage openLogInPage() {

        clickTo(loginPageLink);

        return new LogInPage();
    }

    @Step
    public SwarovskiElementsPage openSwarovskiElementsPage() {

        clickTo(swarovskiElementLink);

        return new SwarovskiElementsPage();
    }


}

