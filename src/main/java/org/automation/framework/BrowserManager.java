package org.automation.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BrowserManager {

    private static WebDriver driver;

    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=1");
        driver =  new ChromeDriver(options);
    }


    public WebDriver getDriver(){
        return driver;
    }

    public static void closeDriver() {
        driver.close();

    }
    
}

