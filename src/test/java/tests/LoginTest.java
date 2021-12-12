package tests;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {

    @AfterMethod
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @Issue("1234")
    @TmsLink("5678")
    @Test (description = "Description for Login positive test", groups = {"Smoke", "Positive"})
    @Description("Additional test description")
    public void loginPositiveTest() {
        boolean isLoggedIn = loginPage.login(USERNAME, PASSWORD).isPageOpened();
        Assert.assertTrue(isLoggedIn);
    }

    @Test (dataProvider = "Negative Login Test Data", groups = {"Negative"})
    @Description("Desc2")
    public void loginNegativeTest(String username, String password, String expectedErrorMessage) {
        loginPage.login(username, password);
        String actualErrorMessageText = loginPage.getErrorMessageText();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(actualErrorMessageText, expectedErrorMessage);
    }

    @DataProvider(name = "Negative Login Test Data")
    public Object[][] getNegativeLoginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "", ""},
        };
    }

}
