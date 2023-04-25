package testsuite;

import Utilites.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “standard_user” username
        //driver.findElement(By.id("user-name")).sendKeys("standard_user");
        sendTextToElement(By.id("user-name"), "standard_user");

        //Enter “secret_sauce” password
        //driver.findElement(By.id("password")).sendKeys("secret_sauce");
        sendTextToElement(By.id("password"), "secret_sauce");


        //click on login button
        // driver.findElement(By.id("login-button")).click();
        clickOnElement(By.id("login-button"));

        //verify the text products
        String expectedMessage = "Products";
        //WebElement actualTextElement = driver.findElement(By.xpath("//span[@class = 'title']"));
        // String actualMessage = actualTextElement.getText();
        String actualMessage = getTextFromElement(By.xpath("//span[@class = 'title']"));
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //enter username
        //driver.findElement(By.id("user-name")).sendKeys("standard_user");
        sendTextToElement(By.id("user-name"), "standard_user");
        // enter password
        //driver.findElement(By.id("password")).sendKeys("“secret_sauce”");
        sendTextToElement(By.id("password"), "secret_sauce");

        // click on login button
        //driver.findElement(By.id("login-button")).click();
        clickOnElement(By.id("login-button"));

        // verify the 6 products
        //List<WebElement> totalProducts = driver.findElements(By.className("inventory_item"));

        //System.out.println("Total Numbers of Products" + totalProducts.size());
        verifyListOfElements(By.className("inventory_item"));
    }
}
