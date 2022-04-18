package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        WebElement usernameField = driver.findElement(By.id("username"));
        //Send email address to email field
        usernameField.sendKeys("tomsmith");
        //Find Element of Password field
        WebElement passwordField = driver.findElement(By.name("password"));
        // Send password to Password field
        passwordField.sendKeys("SuperSecretPassword!");
        //Find Element of login button
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();
        //Find Element of Message
        String expectedMessage = "Secure Area";
        //find log out text element
        WebElement actualMessageElement = driver.findElement(By.xpath("//div[@class='example']//h2"));
        String actualMessage = actualMessageElement.getText();
        //Validate actual and expected message
        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        WebElement usernameField = driver.findElement(By.id("username"));
        //Send email address to email field
        usernameField.sendKeys("tomsmith1");
        //Find Element of Password field
        WebElement passwordField = driver.findElement(By.name("password"));
        // Send password to Password field
        passwordField.sendKeys("SuperSecretPassword!");
        //Find Element of login button
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();
        //Find Element of Message
        String expectedMessage = "Your username is invalid!\n×";
        //find log out text element
        WebElement actualMessageElement = driver.findElement(By.id("flash"));
        String actualMessage = actualMessageElement.getText();
        //Validate actual and expected message
        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        WebElement usernameField = driver.findElement(By.id("username"));
        //Send email address to email field
        usernameField.sendKeys("tomsmith");
        //Find Element of Password field
        WebElement passwordField = driver.findElement(By.name("password"));
        // Send password to Password field
        passwordField.sendKeys("SuperSecretPassword");
        //Find Element of login button
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();
        //Find Element of Message
        String expectedMessage = "Your password is invalid!\n×";
        //find log out text element
        WebElement actualMessageElement = driver.findElement(By.id("flash"));
        String actualMessage = actualMessageElement.getText();
        //Validate actual and expected message
        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);
    }

    @After

    public void tearDown() {
        closeBrowser();
    }
}
