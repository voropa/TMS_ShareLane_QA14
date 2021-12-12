package tests;

import org.testng.annotations.BeforeClass;
import pages.ProductsPage;

public class BaseProductsTest extends BaseTest {
    protected ProductsPage productsPage;
    @BeforeClass(alwaysRun = true)
    public void baseSetUpProductTests() {
        productsPage = new ProductsPage(driver);
        System.out.println("Base Products before class");
    }
}
