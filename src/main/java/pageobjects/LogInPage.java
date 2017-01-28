package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import util.PropertiesReader;

@Getter
public class LogInPage extends AbstractPageObject {

    @Name("Create email input field")
    @FindBy(id = "email_create")
    @Timeout(30)
    private TextInput createEmailInput;

    @Name("Submit new creation button")
    @FindBy(id = "SubmitCreate")
    @Timeout(30)
    private Button submitNewCreationButton;

    @Name("Email input field")
    @FindBy(id = "email")
    @Timeout(30)
    private TextInput emailInput;

    @Name("Password input field")
    @FindBy(id = "passwd")
    @Timeout(30)
    private TextInput passInput;

    @Name("Submit login button")
    @FindBy(id = "SubmitLogin")
    @Timeout(30)
    private Button submitLoginButton;

    // page element to check whether user log in or not; // ERROR_LOGIN_ALERT
    @Name("Invalid user")
    @FindBy(xpath = "//*[@id='center_column']/div[1]")
    @Timeout(30)
    private HtmlElement invalidUser;

    // while creating new user here should be another email cuz current is existed !!!
    private String EmailToCreate = PropertiesReader.getProperty("email.to.create");
    private String EmailToAddAddress = PropertiesReader.getProperty("email.to.add.address");
    private String EmailToLogin = PropertiesReader.getProperty("email.to.login");
    private String invalidEmailToLogin = PropertiesReader.getProperty("invalid.mail.to.login");
    private String validPass = PropertiesReader.getProperty("valid.pass");
    private String invalidPass = PropertiesReader.getProperty("invalid.pass");

    @Step
    public final LogInPage setEmailToCreate() {

        fillInputAs(createEmailInput, EmailToCreate);

        return this;
    }

    @Step
    public final CreateNewUserPage submitEmail() {

        clickTo(submitNewCreationButton);

        return new CreateNewUserPage();
    }

    @Step
    public final LogInPage setEmail() {

        fillInputAs(emailInput, EmailToLogin);

        return this;
    }

    @Step
    public final LogInPage setEmailToAddAddress() {

        fillInputAs(emailInput, EmailToAddAddress);

        return this;
    }

    @Step
    public final LogInPage setPassword() {

        fillInputAs(passInput, validPass);

        return this;
    }

    @Step
    public final UserAccountPage doLogIn() {

        clickTo(submitLoginButton);

        return new UserAccountPage();
    }

    @Step
    public final LogInPage setInvalidEmail(final String invalidEmail) {

        fillInputAs(emailInput, invalidEmail);

        return this;
    }

    @Step
    public final LogInPage setInvalidPassword(final String invalidPass) {

        fillInputAs(passInput, invalidPass);

        return this;
    }

}
