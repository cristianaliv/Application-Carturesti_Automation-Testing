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
    @DisplayName("Validate title test")
    public void validateTitle() {
        log.info("Validate title");
        String title = homePage.homePageTitle();
        assertEquals("Cărturești - Librărie Online - Carte Ceai Muzică Film", title, "Title of page was: " + title);
    }


    @Test
    @DisplayName("Validate Carturesti logo")
    public void checkLogoButton(){
        homePage.isLogoButtonVisible();
        homePage.clickLogoButton();
        homePage.isBannerDisplayed();

    }



    @Test
    @DisplayName("Validate banner test and")
    public void validateBanner() throws InterruptedException {
        log.info("Validate home page banner");
        boolean isBannerDisplayed = homePage.isBannerDisplayed();
        boolean isBannerEnabled = homePage.isBannerEnabled();
        assertTrue(isBannerDisplayed, "Banner is not displayed");
        assertTrue(isBannerEnabled, "Banner is not enabled");


        Map<String, Integer> slideCounts = new HashMap<>();
        int slideCount = 11;

        System.out.println("Numărul total de slide-uri: " + slideCount);

        for (int i = 0; i < slideCount; i++) {

            homePage.goToNextSlide();
            Thread.sleep(2000); // Așteptăm schimbarea

            // Obținem identificatorul slide-ului curent

            String currentSlide = homePage.getCurrentSlide();
            System.out.println("Identificatorul slide-ului curent: " + currentSlide);

// Contorizăm aparițiile identificatorului
            slideCounts.put(currentSlide, slideCounts.getOrDefault(currentSlide, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : slideCounts.entrySet()) {
            System.out.println("Slide-ul " + entry.getKey() + " a apărut de " + entry.getValue() + " ori.");
        }

// Verificăm dacă toate slide-urile au fost afișate
//        if (slideCounts.size() == slideCount) {
//            System.out.println("Test reușit: Toate slide-urile au fost afișate.");
//        } else {
//            System.out.println("Test eșuat: Nu toate slide-urile s-au schimbat.");
//        }


        assertEquals(slideCount, slideCounts.size(), "i found" + slideCounts.size());

    }




        @Test
        @DisplayName("Validate 'PRODUSE' menu")
        public void validateProduseMenu(){



        String titleMenu = homePage.getMenuTitle();
        assertEquals("PRODUSE", titleMenu, "i found: "+ titleMenu);
        homePage.clickProduseButton();
        homePage.hoverElementsMenu();

            List<String> labelsText = homePage.getMenuLabels();

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
