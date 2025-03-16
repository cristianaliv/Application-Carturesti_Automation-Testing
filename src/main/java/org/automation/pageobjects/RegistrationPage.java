package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.constants.LoginDetails;
import org.automation.constants.RegistrationDetails;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;

import java.util.List;

public class RegistrationPage {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);


    private final static By ACCEPT_COOKIES_BUTTON = By.xpath("//a[@aria-label = 'allow cookies']");
    private final static By LOGIN_BUTTON = By.xpath("(//button[@role='menuitem' and @data-target='#modalLogin'])[2]");
    private final static By POPUP_LOGIN = By.xpath("(//div[@class ='modal-content'])[1]");
    private final static By UTILIZATOR_NOU_BUTTON = By.xpath("//button[@id='signupTrigger']");
    private final static By INREGISTRARE_TEXT = By.xpath("(//div[@class = 'modal-header'])[1]");
    private final static By EMAIL_FIELD = By.xpath("//input[@id = 'signupform-email']");
    private final static By EMAIL_TEXT = By.xpath("//label[@for = 'signupform-email']");
    private final static By PAROLA_FIELD = By.xpath("//input[@id = 'signupform-password']");
    private final static By PAROLA_TEXT= By.xpath("//label[@for = 'signupform-password']");
    private final static By SIGNUP_BUTTON = By.xpath("//button[@name ='signup-button']");
    private final static By CAPTCHA_IFRAME = By.xpath("//iframe[@title='reCAPTCHA']");
    private final static By CAPTCHA_CHECKBOX = By.xpath("(//div[@class='rc-inline-block'])[1]");
    private final static By ERROR_MESSAGE = By.xpath("//div[text() = 'Exista deja un cont creat cu aceasta adresa de email.']");


    public void openHomePage() {
        log.info("Open Carturesti home page");
        manager.openBrowser();
        manager.getDriver().get("https://carturesti.ro/");
        manager.getDriver().manage().window().maximize();
    }


    public void acceptCookies() {
        log.info("Click 'Accept cookies' button");
        actions.waitElementToBeClickable(ACCEPT_COOKIES_BUTTON, 10);
        actions.clickElement(ACCEPT_COOKIES_BUTTON);
    }

    public void clickLoginButton() {
        log.info("Click 'LOGIN' button");
        actions.waitElementToBeClickable(LOGIN_BUTTON, 10);
        actions.clickElement(LOGIN_BUTTON);
        actions.waitElementToBeVisible(POPUP_LOGIN, 10);
    }

    public void clickUtilizatorNouButton() {
        log.info("Click 'UTILIZATOR NOU' button");
        actions.clickElement(UTILIZATOR_NOU_BUTTON);
        actions.waitElementToBeVisible(EMAIL_FIELD, 5);
        actions.waitElementToBeVisible(PAROLA_FIELD, 5);
    }

    public List<String> getAccountLabels() {
        log.info("Get account labels");

        String inregistrareText = actions.getElementText(INREGISTRARE_TEXT);
        String utilizatorNouText = actions.getElementText(UTILIZATOR_NOU_BUTTON);
        String emailText = actions.getElementText(EMAIL_TEXT);
        String parolaText = actions.getElementText(PAROLA_TEXT);
        String signupText = actions.getElementText(SIGNUP_BUTTON);

        return List.of(inregistrareText, utilizatorNouText, emailText, parolaText, signupText);
    }



    public void registrationWithRegisteredEmail() {
        log.info("Registration with an already email registered");

        actions.waitElementToBeVisible(EMAIL_FIELD, 5);
        actions.waitElementToBeVisible(PAROLA_FIELD, 5);

        String emailValid = RegistrationDetails.REGISTERED_EMAIL.getEmail();
        String passValid = RegistrationDetails.REGISTERED_EMAIL.getPassword();

        actions.waitElementToBeClickable(EMAIL_FIELD, 10);
        log.info("Enter the registered email in the “Email” field");
        actions.sendKeys(EMAIL_FIELD, emailValid);
        log.info("Enter the password in the “Parolă” field");
        actions.sendKeys(PAROLA_FIELD, passValid);

    }

    public void completeCaptcha() {
        log.info("Complete reCaptcha");
        actions.completeCaptcha(CAPTCHA_IFRAME, CAPTCHA_CHECKBOX);
    }

    public void clickSignUp() {
        log.info("Click 'SIGNUP' button");
        actions.clickElement(SIGNUP_BUTTON);
    }

    public String getErrorMessage(){
        log.info("Get error message");
        actions.waitFluentElementVisible(ERROR_MESSAGE, 20);
        return actions.getElementText(ERROR_MESSAGE);

    }

}
