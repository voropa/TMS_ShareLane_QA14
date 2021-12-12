package pages;

import bo.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContractsPage extends BasePage{
    public ContractsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public BasePage open() {
        return null;
    }

    public void clickNewContactButton() {

    }

    public void setFirstName(String firstName) {
        driver.findElement(By.cssSelector("")).sendKeys(firstName);
    }

    public void fillContactInfo(Contact contact) {

        if (contact.getFirstName() != null ) {
            setFirstName(contact.getFirstName());
        }
        if (contact.getLastName() != null ) {
            driver.findElement(By.cssSelector("last_name_input"))
                    .sendKeys(contact.getLastName());
        }
        // .... and 20 more
    }


}
