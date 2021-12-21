package tests;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {
    final static String USERNAME = "standard_user";
    final static String PASSWORD = "secret_sauce";

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass(description = "Open browser", alwaysRun = true)
    public void setUp(ITestContext testContext) {
        String browser = System.getProperty("browser");
        driver =  DriverFactory.getDriver(browser);
        testContext.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.
                manage().
                timeouts().
                implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        driver.quit();
    }
}
