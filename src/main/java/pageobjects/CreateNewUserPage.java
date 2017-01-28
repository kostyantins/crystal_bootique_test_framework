package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.TextInput;
import util.PropertiesReader;

@Getter
public class CreateNewUserPage extends AbstractPageObject {

    // here should be another credentials cuz current user is created !!!
    private String userName = PropertiesReader.getProperty("user.name");
    private String userLastname = PropertiesReader.getProperty("user.lastname");
    private String userPass = PropertiesReader.getProperty("user.pass");
    private String day = PropertiesReader.getProperty("user.birthday.day");
    private String month = PropertiesReader.getProperty("user.birthday.month");
    private String year = PropertiesReader.getProperty("user.birthday.year");

    @Name("MR radiobutton")
    @FindBy(id = "id_gender1")
    @Timeout(30)
    private Button mrRadiobutton;

    @Name("Name input field")
    @FindBy(id = "customer_firstname")
    @Timeout(30)
    private TextInput nameInput;

    @Name("Password input field")
    @FindBy(id = "customer_lastname")
    @Timeout(30)
    private TextInput lastnameInput;

    @Name("Lastname input field")
    @FindBy(id = "passwd")
    @Timeout(30)
    private TextInput passInput;

    @Name("Daya check box")
    @FindBy(id = "days")
    @Timeout(30)
    private CheckBox daysCheckBox;

    @Name("Month check box")
    @FindBy(id = "months")
    @Timeout(30)
    private CheckBox monthCheckBox;

    @Name("Years check box")
    @FindBy(id = "years")
    @Timeout(30)
    private CheckBox yearsCheckBox;

    @Name("Submit account button")
    @FindBy(id = "submitAccount")
    @Timeout(30)
    private Button submitAccountButton;

    @Step
    public final CreateNewUserPage setSexAsMr() {

        clickTo(mrRadiobutton);

        return this;
    }

    @Step
    public final CreateNewUserPage setName() {

        fillInputAs(nameInput, userName);

        return this;
    }

    @Step
    public final CreateNewUserPage setLastname() {

        fillInputAs(lastnameInput, userLastname);

        return this;
    }

    @Step
    public final CreateNewUserPage setPassword() {

        fillInputAs(passInput, userPass);

        return this;
    }

    @Step
    public final CreateNewUserPage setBirthdayDay() {

        fillInputAs(daysCheckBox, day);

        return this;
    }

    @Step
    public final CreateNewUserPage setBirthdayMonth() {

        fillInputAs(monthCheckBox, month);

        return this;
    }

    @Step
    public final CreateNewUserPage setBirthdayYear() {

        fillInputAs(yearsCheckBox, year);

        return this;
    }

    @Step
    public final UserAccountPage createUser() {

        clickTo(submitAccountButton);

        return new UserAccountPage();
    }
}
