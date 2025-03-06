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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {


    LoginPage loginPage = new LoginPage();
    SearchPage searchPage = new SearchPage();

    @BeforeEach
    public void setUp(){
        loginPage.openHomePage();
        loginPage.acceptCookies();
    }


   @Test
   @DisplayName("Verify if search functionality works for a specific book title ")
   public void searchTestForASpecificBookTitle(){

        searchPage.searchProduct("Cat timp infloresc lamaii");

        List<WebElement> results = searchPage.getSearchResults();
       for (WebElement item : results) {
         assertTrue(item.getText().contains("Cat timp infloresc lamaii"), "I found item: " + item.getText());

       }

}

    @ParameterizedTest
    @DisplayName("Verify if search functionality works for a specific book title using enum")
    @EnumSource(value = ProductsSearch.class, names = {"FIRST_PRODUCT", "THIRD_PRODUCT"})
    public void searchTestWithEnum(ProductsSearch products){
        searchPage.searchProduct(products.getProductSearch());

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
