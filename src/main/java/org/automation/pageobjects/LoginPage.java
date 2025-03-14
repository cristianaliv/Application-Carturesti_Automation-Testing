package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.constants.LoginDetails;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;

import java.util.List;

public class LoginPage {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private final static By ACCEPT_COOKIES_BUTTON = By.xpath("//a[@aria-label = 'allow cookies']");
    private final static By LOGIN_BUTTON = By.xpath("(//button[@role='menuitem' and @data-target='#modalLogin'])[2]");
    private final static By POPUP_LOGIN = By.xpath("(//div[@class ='modal-content'])[1]");
    private final static By UTILIZATOR_EXISTENT_BUTTON = By.xpath("//button[@id='loginTrigger']");
    private final static By EMAIL_FIELD = By.xpath("//input[@id = 'loginform-email']");
    private final static By PAROLA_FIELD = By.xpath("//input[@id = 'loginform-password']");
    private final static By AUTENTIFICARE_BUTTON = By.xpath("//button[@name = 'login-button']");
    private final static By ACCOUNT_MENU_BUTTON = By.xpath("//button[@id = 'accountDropdown']");
    private final static By ERROR_MESSAGE_LOGIN_FAILED = By.xpath("//div[@class='form-group field-loginform-password required has-error registered-gtm-error']//div[@class='help-block']");
    private final static By EMAIL_ERROR_TEXT = By.xpath("(//div[text() = 'Acest câmp trebuie completat.'])[1]");
    private final static By PASSWORD_ERROR_TEXT = By.xpath("(//div[text() = 'Acest câmp trebuie completat.'])[2]");
    private final static By CLOSE_POPUP_BUTTON = By.xpath("(//button[@class='close'])[1]");
    private final static By LOGOUT_BUTTON = By.xpath("//li//a[@href='/site/logout']");


    public void openHomePage() {
        log.info("Open Carturesti home page");
        manager.openBrowser();
        manager.getDriver().get("https://carturesti.ro/");
        manager.getDriver().manage().window().maximize();
    }

    public void acceptCookies(){
        log.info("Click 'Accept cookies' button");
       actions.waitElementToBeClickable(ACCEPT_COOKIES_BUTTON,10);
       actions.clickElement(ACCEPT_COOKIES_BUTTON);
    }

    public void clickLoginButton(){
        log.info("Click 'LOGIN' button");
        actions.waitElementToBeClickable(LOGIN_BUTTON, 10);
        actions.clickElement(LOGIN_BUTTON);
        actions.waitElementToBeVisible(POPUP_LOGIN,10);
    }

    public void loginWithValidAccount(){
        log.info("Login with a valid account");
        actions.clickElement(UTILIZATOR_EXISTENT_BUTTON);
        actions.waitElementToBeVisible(EMAIL_FIELD,5);
        actions.waitElementToBeVisible(PAROLA_FIELD,5);

        String emailValid = LoginDetails.LOGIN_USER.getEmail();
        String passValid = LoginDetails.LOGIN_USER.getPassword();

        actions.waitElementToBeClickable(EMAIL_FIELD, 10);
        log.info("Enter the valid email address in the “Email” field");
        actions.sendKeys(EMAIL_FIELD, emailValid);
        log.info("Enter the valid password in the “Parolă” field");
        actions.sendKeys(PAROLA_FIELD, passValid);
        log.info("Click on the “AUTENTIFICARE” button");
        actions.clickElement(AUTENTIFICARE_BUTTON);

    }

    public String verifyLogin(){
        log.info("Verify the login");
        actions.waitElementToBeVisible(ACCOUNT_MENU_BUTTON, 10);
        return actions.getElementText(ACCOUNT_MENU_BUTTON);

    }

    public void clickAccountMenuButton(){
        log.info("Click 'SALUT' button");
        actions.clickElement(ACCOUNT_MENU_BUTTON);

    }

    public void clickLogoutButton(){
        log.info("Click 'Logout' button");
        actions.clickElement(LOGOUT_BUTTON);
    }

    public String verifyLogout(){
        log.info("Verify the logout");
        actions.waitElementToBeVisible(LOGIN_BUTTON, 10);
        return actions.getElementText(LOGIN_BUTTON);
    }

    public void loginWithInvalidMail(){
        log.info("Login with invalid account");
        actions.clickElement(UTILIZATOR_EXISTENT_BUTTON);
        actions.waitElementToBeVisible(EMAIL_FIELD,5);
        actions.waitElementToBeVisible(PAROLA_FIELD,5);

        String emailInvalid = LoginDetails.INVALID_USER.getEmail();
        String passInvalid = LoginDetails.INVALID_USER.getPassword();

        actions.waitElementToBeClickable(EMAIL_FIELD, 10);
        log.info("Enter the invalid email address in the “Email” field");
        actions.sendKeys(EMAIL_FIELD, emailInvalid);
        log.info("Enter the invalid password in the “Parolă” field");
        actions.sendKeys(PAROLA_FIELD, passInvalid);
        log.info("Click on the “AUTENTIFICARE” button");
        actions.clickElement(AUTENTIFICARE_BUTTON);

    }


    public String getLoginFailedMassage(){
        log.info("Get error message for login failed");
        actions.waitElementToBeVisible(ERROR_MESSAGE_LOGIN_FAILED, 10);
        return actions.getElementText(ERROR_MESSAGE_LOGIN_FAILED);
    }



    public void loginWithEmptyCredentials(){
        log.info("Login with empty credentials");
        actions.clickElement(UTILIZATOR_EXISTENT_BUTTON);
        actions.waitElementToBeVisible(EMAIL_FIELD,5);
        actions.waitElementToBeVisible(PAROLA_FIELD,5);

        String emptyEmail = LoginDetails.EMPTY_USER.getEmail();
        String emptyPass = LoginDetails.EMPTY_USER.getPassword();

        actions.waitElementToBeClickable(EMAIL_FIELD, 10);
        log.info("Leave the 'Email' field empty.");
        actions.sendKeys(EMAIL_FIELD, emptyEmail);

        log.info("Leave the 'Parolă' field empty.");
        actions.sendKeys(PAROLA_FIELD, emptyPass);

        log.info("Click on the “AUTENTIFICARE” button");
        actions.clickElement(AUTENTIFICARE_BUTTON);

    }

    public List<String> getErrorMessages() {
        log.info("Get error messages");

        actions.waitFluentElementVisible(EMAIL_ERROR_TEXT, 15);
        String emailErrorText = actions.getElementText(EMAIL_ERROR_TEXT);
        actions.waitFluentElementVisible(PASSWORD_ERROR_TEXT, 15);
        String passErrorText = actions.getElementText(PASSWORD_ERROR_TEXT);

        return List.of(emailErrorText, passErrorText);
   }


   public void closePopupLogin(){
        log.info("Close popup login ");
        actions.waitElementToBeVisible(PASSWORD_ERROR_TEXT, 15);
        actions.clickElement(CLOSE_POPUP_BUTTON);
   }


}
