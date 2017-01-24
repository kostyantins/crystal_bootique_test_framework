package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;
import util.PropertiesReader;

@Getter
public class CreateNewUserPage extends AbstractPageObject {

    private static final By MR_RADIOBUTTON = By.id("id_gender1");
    private static final By NAME_INPUT_FIELD = By.id("customer_firstname");
    private static final By LASTNAME_INPUT_FIELD = By.id("customer_lastname");
    private static final By PASS_INPUT_FIELD = By.id("passwd");
    private static final By DAYS_CHECK_BOX = By.id("days");
    private static final By MONTHS_CHECK_BOX = By.id("months");
    private static final By YEARS_CHECK_BOX = By.id("years");
    private static final By SUBMIT_ACCOUNT_BUTTON = By.id("submitAccount");

    // here should be another credentials cuz current user is created !!!
    private String userName = PropertiesReader.getProperty("user.name");
    private String userLastname = PropertiesReader.getProperty("user.lastname");
    private String userPass = PropertiesReader.getProperty("user.pass");
    private String day = PropertiesReader.getProperty("user.birthday.day");
    private String month = PropertiesReader.getProperty("user.birthday.month");
    private String year = PropertiesReader.getProperty("user.birthday.year");


    @Step
    public final CreateNewUserPage setSexAsMr() {

        clickTo(MR_RADIOBUTTON);

        return this;
    }

    @Step
    public final CreateNewUserPage setName() {

        fillInputAs(NAME_INPUT_FIELD, userName);

        return this;
    }

    @Step
    public final CreateNewUserPage setLastname() {

        fillInputAs(LASTNAME_INPUT_FIELD, userLastname);

        return this;
    }

    @Step
    public final CreateNewUserPage setPassword() {

        fillInputAs(PASS_INPUT_FIELD, userPass);

        return this;
    }

    @Step
    public final CreateNewUserPage setBirthdayDay() {

        fillInputAs(DAYS_CHECK_BOX, day);

        return this;
    }

    @Step
    public final CreateNewUserPage setBirthdayMonth() {

        fillInputAs(MONTHS_CHECK_BOX, month);

        return this;
    }

    @Step
    public final CreateNewUserPage setBirthdayYear() {

        fillInputAs(YEARS_CHECK_BOX, year);

        return this;
    }

    @Step
    public final UserAccountPage createUser() {

        clickTo(SUBMIT_ACCOUNT_BUTTON);

        return new UserAccountPage();
    }
}
