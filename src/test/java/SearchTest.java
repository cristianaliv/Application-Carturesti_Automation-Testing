import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.automation.constants.ProductsSearch;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.LoginPage;
import org.automation.pageobjects.SearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {


    private static final Logger log = LoggerFactory.getLogger(SearchTest.class);
    LoginPage loginPage = new LoginPage();
    SearchPage searchPage = new SearchPage();

    @BeforeEach
    public void setUp(){
        loginPage.openHomePage();
        loginPage.acceptCookies();
    }


   @Test
   @Severity(SeverityLevel.NORMAL)
   @DisplayName("Verify if search functionality works for a specific book title title using the search button (magnifying glass icon) ")
   public void searchTestUsingSearchButton(){
        log.info("Verify if search functionality works for a specific book title title using the search button (magnifying glass icon) ");
        searchPage.searchProductUsingSearchButton("Cat timp infloresc lamaii");

        List<WebElement> results = searchPage.getSearchResults();
       for (WebElement item : results) {
         assertTrue(item.getText().contains("Cat timp infloresc lamaii"), "I found item: " + item.getText());

       }

}

    @Test
    @DisplayName("Verify if search functionality works for a specific book title using 'Enter' key")
    public void searchTestUsingEnterKey(){
        log.info("Verify if search functionality works for a specific book title using 'Enter' key");
        searchPage.searchProductUsingEnterKey("Cat timp infloresc lamaii");

        List<WebElement> results = searchPage.getSearchResults();
        for (WebElement item : results) {
            assertTrue(item.getText().contains("Cat timp infloresc lamaii"), "I found item: " + item.getText());

        }

    }


    @ParameterizedTest
    @DisplayName("Verify if search functionality works for a specific book title using enum ")
    @EnumSource(value = ProductsSearch.class, names = {"FIRST_PRODUCT", "THIRD_PRODUCT"})
    public void searchTestWithEnum(ProductsSearch products){
        log.info("Verify if search functionality works for a specific book title using enum ");
        searchPage.searchProductUsingEnterKey(products.getProductSearch());

        List<WebElement> results = searchPage.getSearchResults();
        for (WebElement item : results) {
            assertTrue(item.getText().contains(products.getProductSearch()), "I found item: " + item.getText());
        }

    }

    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }
}
