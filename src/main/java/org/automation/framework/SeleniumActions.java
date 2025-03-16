package org.automation.framework;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumActions {

    private final BrowserManager browserManager;

    public SeleniumActions(BrowserManager browserManager) {
        this.browserManager = browserManager;
    }



    public void clickElement(By locator) {
        browserManager.getDriver().findElement(locator).click();
    }

    public String getElementText(By locator) {
        return browserManager.getDriver().findElement(locator).getText();
    }

    public void waitElementToBeClickable(By locator, int timeOut) {
        Wait<WebDriver> wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public void waitElementToBeVisible(By locator, int timeOut) {
        Wait<WebDriver> wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public List<WebElement> getElements(By locator) {
        return browserManager.getDriver().findElements(locator);
    }

    public void sendKeys(By locator, String text) {
        browserManager.getDriver().findElement(locator).sendKeys(text);
    }

    public void sendEnter(By locator) {
        browserManager.getDriver().findElement(locator).sendKeys(Keys.ENTER);
    }

    public boolean isElementEnabled(By locator) {
        return browserManager.getDriver().findElement(locator).isEnabled();
    }

    public boolean isElementDisplayed(By locator) {
        return browserManager.getDriver().findElement(locator).isDisplayed();
    }


    public String getAttribute(By locator, String attributeName) {
        return browserManager.getDriver().findElement(locator).getAttribute(attributeName);
    }

    public void hoverElement(By locator, WebDriver driver) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).build().perform();
    }


    public void waitFluentElementVisible(By locator, int timeOut) {
        Wait<WebDriver> wait = new FluentWait<>(browserManager.getDriver())
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }


    public void switchToIframe(By iframeLocator) {
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));
    }

    public void switchToDefaultContent() {
        browserManager.getDriver().switchTo().defaultContent();
    }

    public void completeCaptcha(By iframeLocator, By captchaCheckbox) {
        switchToIframe(iframeLocator);
        clickElement(captchaCheckbox);
        switchToDefaultContent();
    }
}
