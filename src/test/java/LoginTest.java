import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.LoginPage;
import org.automation.pageobjects.ShoppingCart;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)

public class LoginTest {

    LoginPage loginPage = new LoginPage();
    Logger log = LogManager.getRootLogger();


    @BeforeAll
    public static void setUp(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.openHomePage();
        shoppingCart.acceptCookies();
    }


    @Order(value = 1)
   @Test
    @DisplayName("Verify if user can log in successfully with a valid account")
    public void loginTest(){
        log.info("Verify if user can log in successfully with a valid account");
        loginPage.clickLoginButton();
        loginPage.loginWithValidAccount();
        String result = loginPage.verifyLogin();
        assertTrue(result.contains("SALUT"));

    }


    @Order(value = 2)
    @Test
    @DisplayName("Verify if user can logout successfully from the application")
    public void logoutTest(){
        log.info("Verify if user can logout successfully from the application");
        loginPage.clickAccountMenuButton();
        loginPage.clickLogoutButton();
        String result = loginPage.verifyLogout();
        assertTrue(result.contains("LOGIN"));

    }




    @Order(value = 3)
    @Test
    @DisplayName("Verify if user login fails with invalid account information")
    public void loginTestWithInvalidEmail() {
        log.info("Verify if user login fails with invalid account information");
        loginPage.clickLoginButton();
        loginPage.loginWithInvalidMail();

        String messageLoginFailed = loginPage.getLoginFailedMassage();
        System.out.println("Login Failed. Error message: " + messageLoginFailed);
        assertEquals("Adresă de email sau parolă incorectă.", messageLoginFailed, "I found: " + messageLoginFailed);


    }

    @Order(value = 4)
    @Test
    @DisplayName("Verify if user login fails with empty account credentials.")
    public void loginTestWithEmptyCredentials() {

        log.info("Verify if user login fails with empty account credentials.");
        loginPage.clickLoginButton();
        loginPage.loginWithEmptyCredentials();

        List<String> labelsText = loginPage.getErrorMessages();

        log.info("Validate error messages for email and password field");

        System.out.println("The error is: " + labelsText.get(0));
        System.out.println("The error is: " + labelsText.get(1));
        assertEquals("Acest câmp trebuie completat.", labelsText.get(0), "I found: " + labelsText.get(0));
        assertEquals("Acest câmp trebuie completat.", labelsText.get(1), "I found: " + labelsText.get(1));

        loginPage.closePopupLogin();
    }



    @AfterAll
    public static void tearDown() {
        BrowserManager.closeDriver();
    }
}
