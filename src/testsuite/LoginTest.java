package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com";

    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        String expectedMessage = "Products";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='title']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Not directed to Products Page", expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        List<WebElement> productNo = driver.findElements(By.className("inventory_item"));
        int totalProducts = productNo.size();
        int expectedNumber = 6;
        Assert.assertEquals("Products numbers not matching", expectedNumber, totalProducts);
    }
}





