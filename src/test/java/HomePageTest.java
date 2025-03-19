import com.google.common.util.concurrent.ListenableFutureTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest {

    Logger log = LogManager.getRootLogger();
    HomePage homePage = new HomePage();


    @BeforeEach
    public void setUp(){
        homePage.openHomePage();
        homePage.acceptCookies();
    }

    @Test
    @DisplayName("Validate title of the page Carturesti")
    public void validateTitle() {
        log.info("Validate title of the page Carturesti");
        String title = homePage.homePageTitle();
        assertEquals("Cărturești - Librărie Online - Carte Ceai Muzică Film", title, "Title of page was: " + title);
    }


    @Test
    @DisplayName("Validate Carturesti logo")
    public void checkLogoButton(){
        log.info("Validate Carturesti logo");
        homePage.isLogoButtonVisible();
        homePage.clickLogoButton();
        homePage.isBannerDisplayed();

    }



    @Test
    @DisplayName("Validate home page banner")
    public void validateBanner() throws InterruptedException {
        log.info("Validate home page banner");
        boolean isBannerDisplayed = homePage.isBannerDisplayed();
        boolean isBannerEnabled = homePage.isBannerEnabled();
        assertTrue(isBannerDisplayed, "Banner is not displayed");
        assertTrue(isBannerEnabled, "Banner is not enabled");

    }


        @Test
        @DisplayName("Validate 'PRODUSE' menu")
        public void validateProduseMenu(){

        log.info("Validate 'PRODUSE' menu");

        String titleMenu = homePage.getMenuTitle();
        assertEquals("PRODUSE", titleMenu, "i found: "+ titleMenu);
        homePage.clickProduseButton();
        homePage.hoverElementsMenu();

            List<String> labelsText = homePage.getMenuLabels();
            log.info("Validate menu labels");
            assertEquals("CARTE", labelsText.get(0), "I found: " + labelsText.get(0));
            assertEquals("CARTE STRAINA", labelsText.get(1), "I found: " + labelsText.get(1));
            assertEquals("SCOLARESTI", labelsText.get(2), "I found: " + labelsText.get(2));
            assertEquals("RAFTURI ALESE", labelsText.get(3), "I found: " +labelsText.get(3));
            assertEquals("MANGA", labelsText.get(4), "I found: " + labelsText.get(4));
            assertEquals("REVISTE", labelsText.get(5), "I found: " + labelsText.get(5));
            assertEquals("MUZICA", labelsText.get(6), "I found: " + labelsText.get(6));
            assertEquals("HOME & DECO", labelsText.get(7), "I found: " +labelsText.get(7));
            assertEquals("FILM", labelsText.get(8), "I found: " + labelsText.get(8));
            assertEquals("GOURMET SI VIN", labelsText.get(9), "I found: " + labelsText.get(9));
            assertEquals("ROD", labelsText.get(10), "I found: " +labelsText.get(10));
            assertEquals("PAPETARIE", labelsText.get(11), "I found: " + labelsText.get(11));
            assertEquals("CEAI & ACCESORII", labelsText.get(12), "I found: " + labelsText.get(12));
            assertEquals("HAINE SI ACCESORII", labelsText.get(13), "I found: " + labelsText.get(13));
            assertEquals("BOARD GAMES", labelsText.get(14), "I found: " +labelsText.get(14));
            assertEquals("JOCURI SI JUCARII", labelsText.get(15), "I found: " + labelsText.get(15));
            assertEquals("GADGETURI SI ACCESORII", labelsText.get(16), "I found: " + labelsText.get(16));
            assertEquals("PLAYGROUND", labelsText.get(17), "I found: " + labelsText.get(17));
            assertEquals("COSMETICE", labelsText.get(18), "I found: " +labelsText.get(18));
            assertEquals("DISNEY", labelsText.get(19), "I found: " + labelsText.get(19));
            assertEquals("PROMOȚII ȘI SELECȚII", labelsText.get(20), "I found: " +labelsText.get(20));

        }


    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }
}
