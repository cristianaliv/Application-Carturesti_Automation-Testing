import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.RegistrationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTest {


    RegistrationPage registrationPage = new RegistrationPage();
    Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp(){
        registrationPage.openHomePage();
        registrationPage.acceptCookies();
    }


    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Validate create account fields")
    public void validateCreateAccountFields(){
        log.info("Validate create account fields");
        registrationPage.clickLoginButton();
        registrationPage.clickUtilizatorNouButton();
        List<String> labelsText = registrationPage.getAccountLabels();
        System.out.println("Account fields are: " + labelsText);

        assertTrue(labelsText.get(0).contains("LOGIN / ÎNREGISTRARE"), "I found: " + labelsText.get(0));
        assertEquals("UTILIZATOR NOU", labelsText.get(1), "I found: " + labelsText.get(1));
        assertEquals("Email", labelsText.get(2), "I found: " + labelsText.get(2));
        assertEquals("Parolă", labelsText.get(3), "I found: " + labelsText.get(3));
        assertEquals("SIGNUP", labelsText.get(4), "I found: " +labelsText.get(4));
    }


//
//    @Test
//    @DisplayName("Verify if registration fails when using an email already registered in the system ")
//    public void verifyRegistrationWithAnEmailRegistered(){
//          log.info("Verify if registration fails when using an email already registered in the system ");
//        registrationPage.clickLoginButton();
//        registrationPage.clickUtilizatorNouButton();
//          registrationPage.registrationWithRegisteredEmail();
//        registrationPage.completeCaptcha();
//        registrationPage.clickSignUp();
//        String errorMessage = registrationPage.getErrorMessage();
//        System.out.println("Error message is: " + errorMessage);
//        assertEquals("Exista deja un cont creat cu aceasta adresa de email.", errorMessage, "I found: " + errorMessage);
//
//    }

    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }
}
