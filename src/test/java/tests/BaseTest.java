package tests;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {

    String username, password;

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass(description = "Open browser", alwaysRun = true)
    public void setUp(ITestContext testContext) {
        username = System.getenv().getOrDefault("USER_NAME", PropertyReader.getProperty("saucedemo.username"));
        password = System.getenv().getOrDefault("USER_PASS", PropertyReader.getProperty("saucedemo.password"));
        String browser = System.getProperty("browser");
        driver =  DriverFactory.getDriver("chrome");
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
