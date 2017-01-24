package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;
import util.PropertiesReader;

@Getter
public class LogInPage extends AbstractPageObject {

    private static final By EMAIL_CREATE_INPUT_FIELD = By.id("email_create");
    private static final By SUBMIT_NEW_CREATION_BUTTON = By.id("SubmitCreate");
    private static final By EMAIL_INPUT_FIELD = By.id("email");
    private static final By PASS_INPUT_FIELD = By.id("passwd");
    private static final By SUBMIT_LOGIN_BUTTON = By.id("SubmitLogin");

    // page element to check whether user log in or not; // ERROR_LOGIN_ALERT
    public static final By INVALID_USER = By.xpath("//*[@id='center_column']/div[1]");

    // while creating new user here should be another email cuz current is existed !!!
    private String EmailToCreate = PropertiesReader.getProperty("email.to.create");
    private String EmailToAddAddress = PropertiesReader.getProperty("email.to.add.address");
    private String EmailToLogin = PropertiesReader.getProperty("email.to.login");
    private String invalidEmailToLogin = PropertiesReader.getProperty("invalid.mail.to.login");
    private String validPass = PropertiesReader.getProperty("valid.pass");
    private String invalidPass = PropertiesReader.getProperty("invalid.pass");

    @Step
    public final LogInPage setEmailToCreate() {

        fillInputAs(EMAIL_CREATE_INPUT_FIELD, EmailToCreate);

        return this;
    }

    @Step
    public final CreateNewUserPage submitEmail() {

        clickTo(SUBMIT_NEW_CREATION_BUTTON);

        return new CreateNewUserPage();
    }

    @Step
    public final LogInPage setEmail() {

        fillInputAs(EMAIL_INPUT_FIELD, EmailToLogin);

        return this;
    }

    @Step
    public final LogInPage setEmailToAddAddress() {

        fillInputAs(EMAIL_INPUT_FIELD, EmailToAddAddress);

        return this;
    }

    @Step
    public final LogInPage setPassword() {

        fillInputAs(PASS_INPUT_FIELD, validPass);

        return this;
    }

    @Step
    public final UserAccountPage doLogIn() {

        clickTo(SUBMIT_LOGIN_BUTTON);

        return new UserAccountPage();
    }

    @Step
    public final LogInPage setInvalidEmail(final String invalidEmail) {

        fillInputAs(EMAIL_INPUT_FIELD, invalidEmail);

        return this;
    }

    @Step
    public final LogInPage setInvalidPassword(final String invalidPass) {

        fillInputAs(PASS_INPUT_FIELD, invalidPass);

        return this;
    }

}
