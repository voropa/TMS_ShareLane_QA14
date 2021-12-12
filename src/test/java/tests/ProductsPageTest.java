package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductsPageTest extends BaseProductsTest {
    private final static int EXPECTED_PRODUCTS_COUNT = 6;
    private String productName;
    private String expectedProductPrice;

    @BeforeClass(alwaysRun = true)
    public void setUpExtProductTests() {
        System.out.println("Products Before Class");
    }

    @Test (description = "Backpack product info test", groups = {"Smoke"})
    public void verifySauceLabsBackpackInfo() {
        productName = "Sauce Labs Backpack";
        expectedProductPrice = "29.99$";
        loginPage.login(USERNAME,PASSWORD);
        Assert.assertEquals(productsPage.getProductPrice(productName), expectedProductPrice);
        Assert.assertEquals(productsPage.getProductDescription(productName), "2esfsdfdfsdfdfdsfdsf");
    }

    @Test (description = "Products Count test", groups = {"Smoke"})
    public void verifyProductsCount() {
        productName = "Sauce labs bike light";
        loginPage.login(USERNAME,PASSWORD);
        Assert.assertEquals(productsPage.getProductsCount(), EXPECTED_PRODUCTS_COUNT);
    }

    @Test
    public void verifyBikeLightInfo() {
        productName = "Sauce Labs Bike Light";
        loginPage.open();
        boolean isLoginPageOpened = loginPage.isPageOpened();
        Assert.assertTrue(isLoginPageOpened, "Login page should be opened");
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(productsPage.isPageOpened(), "Products page should be opened");
        productsPage.clickAddToCartButton(productName);
    }
}
