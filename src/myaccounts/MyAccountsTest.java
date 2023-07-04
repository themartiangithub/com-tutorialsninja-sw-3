package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class = 'list-inline']//a"));
        for (WebElement list : options) {
            if (option.equalsIgnoreCase(list.getText())) {
                list.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Register");

        String expected = "Register Account";
        String actual = getTextFromElement(By.xpath("//h1[contains(text(),'Register Account')]"));
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Login");

        String expected = "Returning Customer";
        String actual = getTextFromElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void VerifyThatUserRegisterAccountSuccessfully(){

        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Register");

        sendTextToElement(By.id("input-firstname"),"YK");
        sendTextToElement(By.id("input-lastname"),"Modi");
        sendTextToElement(By.id("input-email"),"rk15@gmail.com");
        sendTextToElement(By.id("input-telephone"),"01234567891");
        sendTextToElement(By.id("input-password"),"Prime@123");
        sendTextToElement(By.id("input-confirm"),"Prime@123");
        clickOnElement(By.xpath("//label[@class = 'radio-inline']//input[@value = '1']"));
        clickOnElement(By.xpath("//input[@type = 'checkbox']"));
        clickOnElement(By.xpath("//input[@type = 'submit']"));

        String eMsg = "Your Account Has Been Created!";
        String aMsg = getTextFromElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        Assert.assertEquals(eMsg,aMsg);

        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Logout");

        String eLogout = "Account Logout";
        String aLogout = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals(eLogout,aLogout);
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }

    @Test
    public void VerifyThatUserLoginAndLogoutSuccessfully(){

        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Login");

        sendTextToElement(By.id("input-email"),"rk13@gmail.com");
        sendTextToElement(By.id("input-password"),"Prime@123");
        clickOnElement(By.xpath("//input[@type = 'submit']"));

        String eAccount = "My Account";
        String aAccount = getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]"));
        Assert.assertEquals(eAccount,aAccount);

        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Logout");

        String eLogout = "Account Logout";
        String aLogout = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals(eLogout,aLogout);
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @After
    public void tearDown() {

        closeBrowser();
    }
}
