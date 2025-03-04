package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private final static By UTILIZATOR_NOU_TEXT = By.xpath("//button[@id='signupTrigger']");
    private final static By EMAIL_TEXT = By.xpath("//label[@for = 'signupform-email']");
    private final static By PAROLA_TEXT = By.xpath("//label[@for = 'signupform-password']");
    private final static By SIGNUP_TEXT = By.xpath("//button[@name ='signup-button']");


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

    public void clickUtilizatorNouButton(){
        log.info("Click 'Utilizator Nou' button");
        actions.clickElement(UTILIZATOR_NOU_BUTTON);
        actions.waitElementToBeVisible(EMAIL_TEXT, 5);
        actions.waitElementToBeVisible(PAROLA_TEXT, 5);
    }

    public List<String> getAccountLabels() {
        log.info("Get account labels");

        String inregistrareText = actions.getElementText(INREGISTRARE_TEXT);
        String utilizatorNouText = actions.getElementText(UTILIZATOR_NOU_TEXT);
        String emailText = actions.getElementText(EMAIL_TEXT);
        String parolaText = actions.getElementText(PAROLA_TEXT);
        String signupText = actions.getElementText(SIGNUP_TEXT);

        return List.of(inregistrareText, utilizatorNouText,emailText, parolaText, signupText);
    }


    public void validateRegistrationFields() {
        log.info("Validate registration fields on the page Carturesti");


    }
}
