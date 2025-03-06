package org.automation.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    public boolean isElementDisplayed(By locator) {
        return browserManager.getDriver().findElement(locator).isDisplayed();
    }

}
