package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;

import java.util.List;

public class HomePage {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private final static By ACCEPT_COOKIES_BUTTON = By.xpath("//a[@aria-label = 'allow cookies']");
    private final static By LOGO_BUTTON = By.xpath("//a[@class='logo-cartu']");
    private final static By HOME_PAGE_BANNER = By.xpath("//div[@class= 'cartuSlider clean-a ng-scope']");
    private final static By PRODUSE_BUTTON = By.xpath("//span[@class='coco']");
    private final static By MENU_PRODUSE = By.xpath("//md-list[@role='list']");
    private final static By CARTE_BUTTON = By.xpath("//a[@data-ng-href='/raft/carte-109']");
    private final static By CARTE_STRAINA_BUTTON = By.xpath("//a[@data-ng-href='/raft/carte-straina-1937']");
    private final static By SCOLARESTI_BUTTON = By.xpath("//a[@data-ng-href='/raft/scolaresti-1141']");
    private final static By RAFTURI_ALESE_BUTTON = By.xpath("//a[@data-ng-href='/raft/rafturi-alese-823']");
    private final static By MANGA_BUTTON = By.xpath("//a[@data-ng-href='/raft/manga-1191097']");
    private final static By REVISTE_BUTTON = By.xpath("//a[@data-ng-href='/raft/reviste-1189047']");
    private final static By MUZICA_BUTTON = By.xpath("//a[@data-ng-href='/raft/muzica-110']");
    private final static By HOME_DECO_BUTTON = By.xpath("//a[@data-ng-href='/raft/home-deco-1181088']");
    private final static By FILM_BUTTON = By.xpath("//a[@data-ng-href='/raft/film-111']");
    private final static By GOURMET_SI_VIN_BUTTON = By.xpath("//a[@data-ng-href='/raft/gourmet-si-vin-1181063']");
    private final static By ROD_BUTTON = By.xpath("//a[@data-ng-href='/raft/rod-1191409']");
    private final static By PAPETARIE_BUTTON = By.xpath("//a[@data-ng-href='/raft/papetarie-146']");
    private final static By CEAI_ACCESORII_BUTTON = By.xpath("//a[@data-ng-href='/raft/ceai-accesorii-113']");
    private final static By HAINE_SI_ACCESORII_BUTTON = By.xpath("//a[@data-ng-href='/raft/haine-si-accesorii-1181425']");
    private final static By BOARD_GAMES_BUTTON = By.xpath("//a[@data-ng-href='/raft/board-games-1445']");
    private final static By JOCURI_SI_JUCARII_BUTTON = By.xpath("//a[@data-ng-href='/raft/jocuri-si-jucarii-854']");
    private final static By GADGETURI_SI_ACCESORII_BUTTON = By.xpath("//a[@data-ng-href='/raft/gadgeturi-si-accesorii-1181431']");
    private final static By PLAYGROUND_BUTTON = By.xpath("//a[@data-ng-href='/raft/playground-1479']");
    private final static By COSMETICE_BUTTON = By.xpath("//a[@data-ng-href='/raft/cosmetice-1181413']");
    private final static By DISNEY_BUTTON = By.xpath("//a[@data-ng-href='/raft/disney-1042']");
    private final static By PROMOTII_SI_SELECTII_BUTTON = By.xpath("//a[@data-ng-href='/offer']");
    private final static By HOVER_RESULTS = By.xpath("//canvas[@id='menuCanvas']");


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


    public String homePageTitle() {
        log.info("Get home page title");
        return manager.getDriver().getTitle();
    }

    public boolean isLogoButtonVisible(){
        log.info("Check if logo is visible");
        return actions.isElementDisplayed(LOGO_BUTTON);
    }

    public void clickLogoButton(){
        log.info("Click logo button");
        actions.clickElement(LOGO_BUTTON);
        actions.waitElementToBeVisible(HOME_PAGE_BANNER, 10);
    }

    public boolean isBannerDisplayed() {
        log.info("Check if banner is displayed");
        return actions.isElementDisplayed(HOME_PAGE_BANNER);
    }

    public boolean isBannerEnabled() {
        log.info("Check if banner is enabled");
        return actions.isElementEnabled(HOME_PAGE_BANNER);
    }


    public String getMenuTitle() {
        log.info("Get menu title");
        return actions.getElementText(PRODUSE_BUTTON);

    }

    public void clickProduseButton(){
        log.info("Click 'PRODUSE' menu");
        actions.clickElement(PRODUSE_BUTTON);
        actions.waitElementToBeVisible(MENU_PRODUSE,10);
    }

    public void hoverElementsMenu(){
        log.info("Hovering over menu elements");
        actions.hoverElement(CARTE_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(CARTE_STRAINA_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(SCOLARESTI_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(RAFTURI_ALESE_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(MANGA_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(REVISTE_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(MUZICA_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(HOME_DECO_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(FILM_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(GOURMET_SI_VIN_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(ROD_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(PAPETARIE_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(CEAI_ACCESORII_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(HAINE_SI_ACCESORII_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(BOARD_GAMES_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(JOCURI_SI_JUCARII_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(GADGETURI_SI_ACCESORII_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(PLAYGROUND_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(COSMETICE_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(DISNEY_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);
        actions.hoverElement(PROMOTII_SI_SELECTII_BUTTON, manager.getDriver() );
        actions.waitElementToBeVisible(HOVER_RESULTS,5);

    }


    public List<String> getMenuLabels() {
        log.info("Get 'PRODUSE' menu  labels");

        String carteText = actions.getElementText(CARTE_BUTTON);
        String carteStrainaText = actions.getElementText(CARTE_STRAINA_BUTTON);
        String scolarestiText = actions.getElementText(SCOLARESTI_BUTTON);
        String rafturiAleseText = actions.getElementText(RAFTURI_ALESE_BUTTON);
        String mangaText = actions.getElementText(MANGA_BUTTON);
        String revisteText = actions.getElementText(REVISTE_BUTTON);
        String muzicaText = actions.getElementText(MUZICA_BUTTON);
        String homeDecoText = actions.getElementText(HOME_DECO_BUTTON);
        String filmText = actions.getElementText(FILM_BUTTON);
        String gourmetVinText = actions.getElementText(GOURMET_SI_VIN_BUTTON);
        String rodText = actions.getElementText(ROD_BUTTON);
        String papetarieText = actions.getElementText(PAPETARIE_BUTTON);
        String ceaiAccesoriiText = actions.getElementText(CEAI_ACCESORII_BUTTON);
        String haineAccesoriiText = actions.getElementText(HAINE_SI_ACCESORII_BUTTON);
        String boardGamesText = actions.getElementText(BOARD_GAMES_BUTTON);
        String jocuriJucariiText = actions.getElementText(JOCURI_SI_JUCARII_BUTTON);
        String gadgeturiAccesoriiText = actions.getElementText(GADGETURI_SI_ACCESORII_BUTTON);
        String playgroundText = actions.getElementText(PLAYGROUND_BUTTON);
        String cosmeticeText = actions.getElementText(COSMETICE_BUTTON);
        String disneyText = actions.getElementText(DISNEY_BUTTON);
        String promotiiText = actions.getElementText(PROMOTII_SI_SELECTII_BUTTON);


        return List.of(carteText, carteStrainaText, scolarestiText,rafturiAleseText, mangaText, revisteText, muzicaText, homeDecoText,
                filmText, gourmetVinText,rodText, papetarieText,ceaiAccesoriiText, haineAccesoriiText, boardGamesText, jocuriJucariiText,
                gadgeturiAccesoriiText, playgroundText, cosmeticeText, disneyText, promotiiText);
    }



}
