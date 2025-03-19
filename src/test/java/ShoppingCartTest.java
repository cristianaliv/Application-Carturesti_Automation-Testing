import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.SearchPage;
import org.automation.pageobjects.ShoppingCart;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)

public class ShoppingCartTest {


    Logger log = LogManager.getRootLogger();
    ShoppingCart shoppingCart = new ShoppingCart();
    SearchPage searchPage = new SearchPage();

    @BeforeAll
    public static void setUp(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.openHomePage();
        shoppingCart.acceptCookies();
    }

    @Order(value = 1)
    @Test
    @DisplayName("Verify if the shopping cart button is visible and enabled")
    public void validateShoppingCart() {
       log.info("Verify if the shopping cart button is visible and enabled");
        boolean isButtonDisplayed = shoppingCart.isShoppingCartDisplayed();
        boolean isButtonEnabled = shoppingCart.isShoppingCartEnabled();
        assertTrue(isButtonDisplayed, "Banner is not displayed");
        assertTrue(isButtonEnabled, "Banner is not enabled");
        shoppingCart.clickShoppingCart();
    }

    @Order(value = 2)
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verify if user can successfully add a product to the cart")
    public void addProductToCart(){

        log.info("Verify if user can successfully add a product to the cart");
        searchPage.searchProductUsingEnterKey("Cat timp infloresc lamaii");
        List<WebElement> results = searchPage.getSearchResults();
        assertNotNull(results, "List of products is null");
        assertTrue(results.get(0).getText().contains("Cat timp infloresc lamaii"));
        log.info("Open the first product displayed");
        results.get(0).click();

        String productTitleFromPreview = shoppingCart.getProductTitleFromPreview();
        String productPriceFromPreview = shoppingCart.getProductPriceFromPreview();
        shoppingCart.clickAdaugaInCosButton();
        shoppingCart.clickShoppingCart();

        String productTitleFromCart = shoppingCart.getProductTitleFromCart();
        String productPriceFromCart = shoppingCart.getProductPriceFromCart();

        log.info("Verify if title and price of product is displayed correctly");
        assertTrue(productTitleFromCart.toLowerCase().contains(productTitleFromPreview.toLowerCase()), "I found item: " + productTitleFromCart);
        assertTrue(productPriceFromCart.toLowerCase().contains(productPriceFromPreview.toLowerCase()), "I found item: " + productPriceFromCart);
        System.out.println("The title of the product from shopping cart is:  " + productTitleFromCart);
        System.out.println("The price of the product from the shopping cart is:  " + productPriceFromCart + "RON");


        String totalAmountFromCart = shoppingCart.getTotalAmountFromCart();
        System.out.println("The total amount from shopping cart is: " + totalAmountFromCart + "RON");

    }

    @Order(value = 3)
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verify if user can successfully remove a product from the cart")
    public void removeProductFromCart() {

        log.info("Verify if user can successfully remove a product from the cart");
        shoppingCart.clickShoppingCart();
        shoppingCart.clickDeleteButton();

        String emptyCart = shoppingCart.getEmptyCartMessage();
        log.info("Verify if the shopping cart is empty");
        assertTrue(emptyCart.toLowerCase().contains("Coșul tău este gol.".toLowerCase()), "I found item: " + emptyCart);

        System.out.println("The message from shopping cart is: " + emptyCart);
    }



    @AfterAll
    public static void tearDown() {
        BrowserManager.closeDriver();
    }
}
