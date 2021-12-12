package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.FieldPosition;

public class DemoTest extends BaseTest{

    @Test
    public void test1() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.cssSelector("#hot-spot"))).build().perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean isAlertDisplayed() {
        boolean onDisplay;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try  {
            wait.until(ExpectedConditions.alertIsPresent());
            onDisplay = true;
        } catch (TimeoutException ex){
            onDisplay = false;
        }
        return onDisplay;
    }

    public void waitForFileDownloaded(WebDriver driver, final String fileName){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return Files.exists(Paths.get(fileName));
            }
        });
    }
}
