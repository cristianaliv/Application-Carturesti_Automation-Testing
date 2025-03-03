package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.constants.LoginDetails;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;

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

    public void openHomePage() {
        log.info("Open Carturesti home page");
        manager.openBrowser();
        manager.getDriver().get("https://carturesti.ro/");
        manager.getDriver().manage().window().maximize();
    }

    public void acceptCookies(){
       actions.waitElementToBeClickable(ACCEPT_COOKIES_BUTTON,10);
       actions.clickElement(ACCEPT_COOKIES_BUTTON);
    }

    public void clickLoginButton(){
        log.info("Click Login button");
        actions.waitElementToBeClickable(LOGIN_BUTTON, 10);
        actions.clickElement(LOGIN_BUTTON);
        actions.waitElementToBeVisible(POPUP_LOGIN,10);
    }

    public void loginPageCarturesti(){
        log.info("Login on the page Carturesti");
        actions.clickElement(UTILIZATOR_EXISTENT_BUTTON);
        actions.waitElementToBeVisible(EMAIL_FIELD,5);
        actions.waitElementToBeVisible(PAROLA_FIELD,5);

        String email = LoginDetails.LOGIN_USER.getEmail();
        String pass = LoginDetails.LOGIN_USER.getPassword();

        actions.waitElementToBeClickable(EMAIL_FIELD, 10);
        log.info("Enter the valid email address in the “Email” field");
        actions.sendKeys(EMAIL_FIELD, email);
        log.info("Enter the valid password in the “Parolă” field");
        actions.sendKeys(PAROLA_FIELD, pass);
        log.info("Click on the “AUTENTIFICARE” button");
        actions.clickElement(AUTENTIFICARE_BUTTON);

    }

    public String verifyLogin(){

        log.info("Verify that the user is logged in");
        actions.waitElementToBeVisible(ACCOUNT_MENU_BUTTON, 10);
        return actions.getElementText(ACCOUNT_MENU_BUTTON);


    }
}
