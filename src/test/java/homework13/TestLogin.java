package homework13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLogin {
    @Test
    public void testLoginAsASignedInUser() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();

        driver.get("http://training.skillo-bg.com:4300/posts/all");
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();
        wait.until(webDriver -> webDriver.getCurrentUrl().equals("http://training.skillo-bg.com:4300/users/login"));

        String actualLoginPageUrl = driver.getCurrentUrl();
        String expectedLoginPageUrl = "http://training.skillo-bg.com:4300/users/login";
        Assert.assertEquals(actualLoginPageUrl, expectedLoginPageUrl, "Login page URL is incorrect!");

        WebElement signInElement = driver.findElement(By.xpath("//p[text()='Sign in']"));
        Assert.assertTrue(signInElement.isDisplayed(), "The 'Sign in' text is not displayed!");

        WebElement userNameField = driver.findElement(By.id("defaultLoginFormUsername"));
        userNameField.sendKeys("realtester");

        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys("123456");

        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        Assert.assertTrue(signInButton.isEnabled(), "The Sign In button is disabled!");
        signInButton.click();

        wait.until(webDriver -> webDriver.getCurrentUrl().equals("http://training.skillo-bg.com:4300/posts/all"));
        wait.until(webDriver -> webDriver.findElement(By.id("nav-link-profile")).isDisplayed());
        WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
        Assert.assertTrue(profileLink.isDisplayed(), "The profile link is not displayed!");

        profileLink.click();
        String expectedProfilePage = "http://training.skillo-bg.com:4300/users/3974";
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users/3974"));

        WebElement userNameElement = driver.findElement(By.tagName("h2"));
        String actualUserName = userNameElement.getText();
        String expectedUserName = "realtester";
        Assert.assertEquals(actualUserName, expectedUserName, "The user name is incorrect!");

        driver.close();
    }
}
