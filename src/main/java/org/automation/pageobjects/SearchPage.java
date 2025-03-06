package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {


    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private final static By ACCEPT_COOKIES_BUTTON = By.xpath("//a[@aria-label = 'allow cookies']");
    private final static By SEARCH_BAR = By.xpath("//input[@id = 'search-input']");
    //private final static By SEARCH_BUTTON = By.xpath("//div[@class = 'search-container']//i[@class = 'material-icons']");
    private final static By SEARCH_BUTTON = By.xpath("/html/body/div[4]/div[1]/div/div[1]/div[2]/i");
    private final static By SEARCH_RESULTS = By.xpath("//h5[@class='md-title ng-binding']");



    public void openHomePage() {
        log.info("Open Carturesti home page");
        manager.openBrowser();
        manager.getDriver().get("https://carturesti.ro/");
        manager.getDriver().manage().window().maximize();
    }

    public void acceptCookies(){
        log.info("Accept cookies");
        actions.waitElementToBeClickable(ACCEPT_COOKIES_BUTTON,10);
        actions.clickElement(ACCEPT_COOKIES_BUTTON);
    }

    public void searchProduct(String searchElement){
        log.info("Search for element: {}", searchElement);
        actions.waitElementToBeVisible(SEARCH_BAR,5);
        actions.clickElement(SEARCH_BAR);
        actions.sendKeys(SEARCH_BAR, searchElement);
//        actions.clickElement(SEARCH_BUTTON);
        actions.sendEnter(SEARCH_BAR);
    }


    public List<WebElement> getSearchResults() {
        log.info("Get search results");
        return actions.getElements(SEARCH_RESULTS);
    }



}
