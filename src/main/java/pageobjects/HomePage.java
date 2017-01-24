package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

@Getter
public class HomePage extends AbstractPageObject {

    private static final By LOG_IN_PAGE_LINK = By.xpath("(//*[@id='header']//nav//a)[1]");
    public static final By LOGO = By.xpath("//*[@id='header_logo']/a/img");
    public static final By LOGO_LINK = By.xpath("//*[@id='header_logo']/a");
    private static final By SWAROVSKI_ELEMENT_LINK = By.xpath("//*[@id='block_top_menu']/ul/li[1]/a");

    @Step
    public LogInPage openLogInPage() {

        clickTo(LOG_IN_PAGE_LINK);

        return new LogInPage();
    }

    @Step
    public SwarovskiElementsPage openSwarovskiElementsPage() {

        clickTo(SWAROVSKI_ELEMENT_LINK);

        return new SwarovskiElementsPage();
    }


}

