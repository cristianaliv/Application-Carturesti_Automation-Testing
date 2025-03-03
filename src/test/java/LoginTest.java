import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    LoginPage loginPage = new LoginPage();
    Logger log = LogManager.getRootLogger();


    @BeforeEach
    public void setUp(){
        loginPage.openHomePage();
        loginPage.acceptCookies();
    }

    @Test
    @DisplayName("Verify if user can log in successfully with a valid account")
    public void loginTest(){
        loginPage.clickLoginButton();
        loginPage.loginPageCarturesti();
        String result = loginPage.verifyLogin();
        assertTrue(result.contains("SALUT"));

    }

    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }
}
