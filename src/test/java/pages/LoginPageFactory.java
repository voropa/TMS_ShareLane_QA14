package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage {

    @FindBy (id= "user-name")
    private WebElement usernameInput;
    @FindBy (id = "password")
    private WebElement passwordInput;
    @FindBy (id= "login-button")
    private WebElement loginButton;
    @FindBy (css = "[data-test=error]")
    private WebElement errorMessage;
    @FindBy (id = "qweasdzxc")
    private WebElement qwe;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public BasePage open() {
        return null;
    }


    private WebElement getItemContainer(String productName) {
        return driver.findElement(By.xpath("//div[contains(text(), '" + productName + "')]/ancestor::div[@class='inventory_item']"));
    }


    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        waitForPasswordInputClickable();
        passwordInput.sendKeys(password);
        waitUntilClickable(loginButton);
        loginButton.click();
    }

    public void  setUsername() {
        usernameInput.sendKeys("sds");
    }

    public void waitForPasswordInputClickable() {
        waitUntilClickable(passwordInput);
    }


}
