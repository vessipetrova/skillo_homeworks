package homework12;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class testingWebDriverFunctionalities {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.close();
    }

    private void testMyFirstWebDriver(ChromeDriver driver) {
        driver.get("http://training.skillo-bg.com:4300/posts/all");
    }

    private void testFindElement(ChromeDriver driver) {
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
    }

    private void testFindElements(ChromeDriver driver) {
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        List<WebElement> images = driver.findElements(By.xpath("//*[@class='post-feed-img']"));
        System.out.println("The number of post elements is: " + images.size());
    }

    private void testClick(ChromeDriver driver) {
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();
    }

    private void testSendKeys(ChromeDriver driver) {
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();
        WebElement userName = driver.findElement(By.id("defaultLoginFormUsername"));
        String name = "realtester";
        userName.sendKeys(name);
        userName.clear();
        userName.sendKeys("test");
    }

    private void testCommonCommands(ChromeDriver driver) {
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        String titleOfThePage = driver.getTitle();
        System.out.println("The title is: " + titleOfThePage);

        WebElement login = driver.findElement(By.id("nav-link-login"));
        login.click();
        WebElement rememberMe = driver.findElement(By.xpath("//input[@formcontrolname='rememberMe']"));
        rememberMe.click();
        System.out.println("Element is selected: " + rememberMe.isSelected());

        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        String buttonText = signInButton.getText();
        System.out.println("The text of the element is: " + buttonText);

        System.out.println("The element is displayed: " + signInButton.isDisplayed());

        System.out.println("The element is enabled: " + signInButton.isEnabled());
    }

    private void testDropdowns(ChromeDriver driver) {
        driver.get("https://www.mobile.bg/pcgi/mobile.cgi");
        Select dropdownMarka = new Select(driver.findElement(By.name("marka")));
        dropdownMarka.selectByVisibleText("Volvo");
    }
}