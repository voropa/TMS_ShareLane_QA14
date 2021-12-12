package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public abstract class BasePage {

    protected final static String URL = "https://www.saucedemo.com/";

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public abstract boolean isPageOpened();
    public abstract BasePage open();

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }


    // waitUntilElementVisible(element);
    // WebElement elment = driver.findElement(by.csslocaltor("abc"));

    public void waitUntilElementNotDisabled(WebElement element) {
        System.getProperty("blalbalalbl");
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "disabled"));
    }

    public void waitUntilElementNotDisabled1(WebElement element) {
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(element, "style", "color:red")));
    }

    public void waitUntilElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void abc() {
        driver.findElement(By.id("df"));
        driver.findElement(By.id("df"));
    }

    public void waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
    }


}
