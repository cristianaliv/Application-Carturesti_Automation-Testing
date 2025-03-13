package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;


public class ShoppingCart {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private final static By ACCEPT_COOKIES_BUTTON = By.xpath("//a[@aria-label = 'allow cookies']");
    private final static By SHOPPING_CART_BUTTON = By.xpath("//a[@class='checkout__button']");
    private final static By SHOPPING_CART_POPUP = By.xpath("//div[@class='checkout__order-inner']");
    private final static By PRODUCT_TITLE_SHOPPING_CART = By.xpath("//div[@class='cartProductName']");
    private final static By PRODUCT_PRICE_SHOPPING_CART = By.xpath("//span[@data-ng-bind='numberFormat(p.price)']");
    private final static By ADAUGA_IN_COS_BUTTON = By.xpath("//a[@title='Adaugă în coș']");
    private final static By PRODUCT_TITLE_PREVIEW = By.xpath("//h1[@class='titluProdus']");
    private final static By PRODUCT_PRICE_PREVIEW = By.xpath("(//div[@class='col-sm-6'])[2]");
    private final static By TOTAL_AMOUNT_SHOPPING_CART = By.xpath("//span[@data-ng-bind='numberFormat(cart.total)']");
    private final static By DELETE_BUTTON_FROM_CART = By.xpath("//a[@class='removeFromCart']//i[@class='material-icons']");
    private final static By EMPTY_CART_MESSAGE = By.xpath("//div[@data-ng-if='!(cart.products.length)']");

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

    public boolean isShoppingCartDisplayed() {
        log.info("Check if shopping cart button is displayed");
        return actions.isElementDisplayed(SHOPPING_CART_BUTTON);
    }

    public boolean isShoppingCartEnabled() {
        log.info("Check if shopping cart button is enabled");
        return actions.isElementEnabled(SHOPPING_CART_BUTTON);
    }

    public void clickShoppingCart(){
        log.info("Click 'Shopping Cart' button");
        actions.clickElement(SHOPPING_CART_BUTTON);
        actions.waitElementToBeVisible(SHOPPING_CART_POPUP, 10);
    }


    public String getProductTitleFromPreview(){
        log.info("Get product title from preview");
        return actions.getElementText(PRODUCT_TITLE_PREVIEW);
    }

    public String getProductPriceFromPreview(){
        log.info("Get product price from preview");
        return actions.getElementText(PRODUCT_PRICE_PREVIEW);
    }

    public void clickAdaugaInCosButton(){
        log.info("Click 'Adauga In Cos' button");
        actions.waitElementToBeClickable(ADAUGA_IN_COS_BUTTON,50);
        actions.clickElement(ADAUGA_IN_COS_BUTTON);

    }


    public String getProductTitleFromCart(){
        log.info("Get product title from shopping cart");
        return actions.getElementText(PRODUCT_TITLE_SHOPPING_CART);

    }

    public String getProductPriceFromCart(){
        log.info("Get product price from shopping cart");
        return actions.getElementText(PRODUCT_PRICE_SHOPPING_CART);
    }

    public String getTotalAmountFromCart(){
        log.info("Get total amount from the shopping cart");
        return actions.getElementText(TOTAL_AMOUNT_SHOPPING_CART);
    }


    public void clickDeleteButton(){
        log.info("Click delete button from shopping cart");
        actions.waitElementToBeClickable(DELETE_BUTTON_FROM_CART, 18);
        actions.clickElement(DELETE_BUTTON_FROM_CART);
    }

    public String getEmptyCartMessage(){
        log.info("Get empty shopping cart message");
        return actions.getElementText(EMPTY_CART_MESSAGE);

    }

}
